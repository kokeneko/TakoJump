package app.scene;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Tako {

	private ImageView takoImage;
	private boolean isAir; // 空中にいるかどうか

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

	public AnchorPane jump(AnchorPane base) {
		// base.getChildren().get(2)が一番下の床
		Node floor = base.getChildren().get(2);
		if (isAir) {
			System.out.print("空中");
			floor.setLayoutY(floor.getLayoutY() - 10);
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
}
