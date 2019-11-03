package app.scene.title.controller;

import app.scene.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class TitleController {

	@FXML private Label titleLogo;
	@FXML private Label startLabel, rankingLabel;
	@FXML private Polygon cursorPolygon;

	private Transition transition;
	//private Cursor cursor;

	@FXML
	private void initialize() {
		transition = new Transition();
		//cursor = new Cursor(cursorPolygon);
	}

	@FXML
	private void startGame() {
		transition.transitionTo(Transition.GAME_PATH);
	}

	@FXML
	private void transitionRanking() {
		transition.transitionTo(Transition.RANKING_PATH);
	}

}
