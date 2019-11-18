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
		backScreen1.setTranslateY(backScreen1.getTranslateY() + downSpeed);
		backScreen2.setTranslateY(backScreen2.getTranslateY() + downSpeed);
		if (Double.compare(backScreen1.getTranslateY(), 0.0) == 0) {
			changeScreen(backScreen2);
		}
		if (Double.compare(backScreen2.getTranslateY(), 0.0) == 0) {
			changeScreen(backScreen1);
		}
	}

	public void changeScreen(AnchorPane backScreen) {
		backScreen.setTranslateY(-backScreen.getPrefHeight());
	}

}
