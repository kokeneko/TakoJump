package app.scene;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Tako {

	private ImageView takoImage;
	private static boolean isAir; // 空中にいるかどうか
	private Timeline timer;
	private Duration duration;
	private Floor newFloor = new Floor();

	public Tako(ImageView tako) {
		this.takoImage = tako;
		isAir = false;
	}

	public void leftSlide() {
		if (isAir) {
			if ( takoImage.getLayoutX() <= 0 ) {
				takoImage.setLayoutX(takoImage.getLayoutX() + 400);
			}
			takoImage.setLayoutX(takoImage.getLayoutX() - 10);
		}
	}

	public void rightSlide() {
		if (isAir) {
			if ( takoImage.getLayoutX() >= 400 ) {
				takoImage.setLayoutX(takoImage.getLayoutX() - 400 );
			}
			takoImage.setLayoutX(takoImage.getLayoutX() + 10);
		}
	}

	private Timeline jumpTimer;
	private int k;
	private float time;
	private double y;
	private double groundY;
	private Node floor;

	public void jump(AnchorPane base, BackScreen backScreen, Wave wave) {
		isAir = true;

		double distortion = 1; // ゆがみ(ここを調整するとジャンプの感じが変わる) 要調整！
		int jumpHeight = 100; // ジャンプの高さ 要調整！
		time = 0;

		jumpTimer = new Timeline();
		Duration jumpDuration = Duration.millis(50);

		int listNumber;
		List<Double> list = new ArrayList<Double>();
		// listにchildren()のy座標を格納
		for ( listNumber = 0; listNumber < base.getChildren().size(); listNumber++ ) {
			list.add(base.getChildren().get(listNumber).getLayoutY());
		}

		KeyFrame keyFrame = new KeyFrame(jumpDuration, (ActionEvent) ->  {
			if ( isAir ) { // 空中の間
				time += (float)1/50; // 要調整！
				// base.getChildren().get(4)が一番下の床
				for ( k = 4; k < base.getChildren().size(); k++ ) {
					floor = base.getChildren().get(k);

					// 床の座標獲得
					groundY = list.get(k);
					// 次の座標計算
					y = groundY + (1.0 - Math.pow(1.0 - Math.sin(Math.PI*time), distortion))*jumpHeight;
					floor.setLayoutY(y);

					if ( time > 0.5 && collideObject(takoImage, floor) ) {
						isAir = false;
						jumpTimer.stop();
					}
				}
				// 床と背景降下
				wave.waveDown(y);
				backScreen.downScreen(y);
			}
		});
		jumpTimer = new Timeline(keyFrame);
		jumpTimer.setCycleCount(Timeline.INDEFINITE);
		jumpTimer.play();
	}

	// object1とobject2がぶつかっているかを返す
	private boolean collideObject(Node object1, Node object2) {
		if (object1.getBoundsInParent().intersects(object2.getBoundsInParent())) {
			return true;
		}
		return false;
	}

	public void GameOver(ImageView takoImage, Rectangle waveRectangle, Wave wave) {
		duration = Duration.millis(500);
		KeyFrame keyFrame = new KeyFrame(duration, (ActionEvent) ->  {
			if ( collideObject(takoImage, waveRectangle) ) {
				timer.stop();
				// ゲームオーバーの演出
				// 仮置きでコンソール表示と波加速
				// System.out.println("game-over");
				wave.waveStart(0.05);
			}
		});
		timer = new Timeline(keyFrame);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	public boolean getIsAir() {
		return isAir;
	}
}