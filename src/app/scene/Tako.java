package app.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private Timeline timeline;
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
	private double y;
	private Node floor;
	private double time;			// x軸の値
	private int height;
	private double scale;
	private double moveDistance;
	private boolean isTop;
	private double waveLayoutY;
	private double nextFloorY;

	public void jump(AnchorPane base, BackScreen backScreen, Wave wave, int keyPressTime) {
		isAir = true;
		isTop = false;
		time = 0;

		Random rand = new Random();
		int nextFloorX = rand.nextInt(35)*10;
		// 最初の波の高さ
		waveLayoutY = wave.getWaveY();

		if ( keyPressTime <= 150 ) {
			height = keyPressTime;
			scale = 4.0 - (double)height/50;
		} else {
			height = 200;
			scale = 0.7;
		}

		jumpTimer = new Timeline();
		Duration jumpDuration = Duration.millis(50);

		int listNumber;
		List<Double> list = new ArrayList<Double>();
		// listにchildren()のy座標を格納
		int childrenSize = base.getChildren().size();
		for ( listNumber = 0; listNumber < childrenSize; listNumber++ ) {
			list.add(base.getChildren().get(listNumber).getLayoutY());
			System.out.println(list.get(listNumber));
		}

		KeyFrame keyFrame = new KeyFrame(jumpDuration, (ActionEvent) ->  {
			if ( isAir ) { // 空中の間
				time += (double)1/60;
				// base.getChildren().get(4)が一番下の床
				for ( k = 4; k < childrenSize; k++ ) {
					floor = base.getChildren().get(k);

					y = - height * Math.E * (time * scale) * Math.log(time * scale) + list.get(k);
					moveDistance = y - list.get(k);	// 実際に動いた距離
					floor.setLayoutY(y);

					if ( moveDistance + 0.1 >= height ) {
						isTop = true;
					}

					if ( isTop && collideObject(takoImage, floor) ) {
						nextFloorY = floor.getLayoutY() - rand.nextInt(50);
						if ( (childrenSize - 1) == k ) {
							base.getChildren().add(newFloor.generate(newFloor.randType(), nextFloorX, nextFloorY, newFloor.randBlocks(Timer.time)));
						}
						isAir = false;
						// 床のランダム生成
						jumpTimer.stop();
					}
				}
				// 床と背景降下
				wave.waveDown(waveLayoutY + moveDistance);
				backScreen.downScreen(5);
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
		Timer timer = new Timer();
		duration = Duration.millis(500);
		KeyFrame keyFrame = new KeyFrame(duration, (ActionEvent) ->  {
			if ( collideObject(takoImage, waveRectangle) ) {
				// 内部タイマーの停止
				timer.timerStop();

				// ゲームオーバー判定のtimelineストップ
				timeline.stop();

				// ゲームオーバーの演出
				// 仮置きでコンソール表示と波加速
				// System.out.println("game-over");
				wave.waveStart(0.05);
			}
		});
		timeline = new Timeline(keyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	public boolean getIsAir() {
		return isAir;
	}
}
