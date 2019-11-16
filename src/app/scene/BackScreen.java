package app.scene;

import javafx.scene.layout.AnchorPane;

public class BackScreen {

	private AnchorPane backScreen1;
	private AnchorPane backScreen2;

	public BackScreen(AnchorPane backScreenBase) {
		this.backScreen1 = (AnchorPane) backScreenBase.getChildren().get(0);
		this.backScreen2 = (AnchorPane) backScreenBase.getChildren().get(1);
		changeScreen(backScreen2);
	}

	public void downBackScreen(double downSpeed) {
		backScreen1.setTranslateY(backScreen1.getLayoutY() + downSpeed);
		backScreen2.setTranslateY(backScreen2.getLayoutY() + downSpeed);
		if (backScreen1.getTranslateY() == 0) {
			changeScreen(backScreen2);
		}
		if (backScreen2.getTranslateY() == 0) {
			changeScreen(backScreen1);
		}
	}

	private void changeScreen(AnchorPane backScreen) {
		backScreen.setTranslateY(-backScreen.getPrefHeight());
	}

}
