package app.scene;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Tako {

	private ImageView takoImage;
	private boolean isAir; //空中にいるかどうか

	public Tako(ImageView tako) {
		this.takoImage = tako;
		this.isAir = true;
	}

	public void leftSlide() {
		if (this.isAir == true ) {
			takoImage.setLayoutX(takoImage.getLayoutX() - 10);
		}
	}

	public void rightSlide() {
		if (this.isAir == true) {
			takoImage.setLayoutX(takoImage.getLayoutX() + 10);
		}
	}

	public AnchorPane jump(AnchorPane base) {
		//base.getChildren().get(2)が一番下の床
		if (this.isAir == true) {
			base.getChildren().get(2).setLayoutY(base.getChildren().get(2).getLayoutY() - 10) ;
			//床とタコの画像が被ったら
			if (base.getChildren().get(2).getBoundsInParent().intersects(takoImage.getBoundsInParent())) {
				base.getChildren().get(2).setLayoutY(base.getChildren().get(2).getLayoutY());
				System.out.print("地上だよ\n");
				this.isAir = false;
			}
		}
		return base;
	}
}


