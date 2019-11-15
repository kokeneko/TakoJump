package app.scene;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Tako {

	private ImageView takoImage;
	private boolean isAir; // 空中にいるかどうか
	private Timeline timer;
	private Duration duration;

	public Tako(ImageView tako) {
		this.takoImage = tako;
		this.isAir = true;
	}

	public void leftSlide() {
		if (isAir) {
			takoImage.setLayoutX(takoImage.getLayoutX() - 10);
		}
	}

	public void rightSlide() {
		if (isAir) {
			takoImage.setLayoutX(takoImage.getLayoutX() + 10);
		}
	}

	public AnchorPane jump(AnchorPane base, Wave wave) {
		// base.getChildren().get(3)が一番下の床
		Node floor = base.getChildren().get(3);
		if (isAir) {
			floor.setLayoutY(floor.getLayoutY() + 10);
			wave.waveDown(10);
			// 床とタコの画像が被ったら床を動かなくする
			if (collideObject(takoImage, floor)) {
				floor.setLayoutY(floor.getLayoutY());
				isAir = false;
			}
		}
		return base;
	}

	// object1とobject2がぶつかっているかを返す
	private boolean collideObject(Node object1, Node object2) {
		if (object1.getBoundsInParent().intersects(object2.getBoundsInParent())) {
			isAir = false;
			return true;
		}
		return false;
	}

	public void GameOver(ImageView takoImage, Rectangle waveRectangle, Wave wave) {
		duration = Duration.millis(100);
		KeyFrame keyFrame = new KeyFrame(duration, (ActionEvent) ->  {
			if ( collideObject(takoImage, waveRectangle) ) {
				System.out.println("game-over");
				timer.stop();
				// ゲームオーバーの演出
				// 仮置きで波加速
				wave.waveStart(0.1);
			}
		});
		timer = new Timeline(keyFrame);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
}
