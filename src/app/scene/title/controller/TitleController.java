package app.scene.title.controller;

import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class TitleController {
	@FXML private Label titleLogo;
	@FXML private Label startLabel, rankingLabel;
	@FXML private Polygon cursorPolygon;

	private SceneManager sceneManager;

	@FXML
	private void initialize() {
		sceneManager = new SceneManager();
	}

	@FXML
	private void startGame() {
		sceneManager.transitionTo(SceneManager.GAME_PATH);
	}

	@FXML
	private void transitionRanking() {
		sceneManager.transitionTo(SceneManager.RANKING_PATH);
	}

}
