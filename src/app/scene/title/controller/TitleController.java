package app.scene.title.controller;

import app.scene.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class TitleController {

	@FXML Label titleLogo;
	@FXML Label startLabel, rankingLabel;
	@FXML Polygon cursor;

	@FXML
	private void startGame() {
		Transition transition = new Transition();
		transition.transitionTo(Transition.GAME_PATH);

	}

}
