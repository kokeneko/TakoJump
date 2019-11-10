package app.scene;

import javafx.scene.image.ImageView;

public class Tako {

	private ImageView takoImage;

	public Tako(ImageView tako) {
		this.takoImage = tako;
	}

	public void leftSlide() {
		takoImage.setLayoutX(takoImage.getLayoutX() - 10);
	}

	public void rightSlide() {
		takoImage.setLayoutX(takoImage.getLayoutX() + 10);
	}
}
