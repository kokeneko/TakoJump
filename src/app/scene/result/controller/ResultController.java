package app.scene.result.controller;

import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class ResultController {
	@FXML private Label newRecordLabel;
	@FXML private Label score, highScore;
	@FXML private Label restartLabel, toTitleLabel;
	@FXML private Polygon cursorPolygon;

	@FXML
	private void restartGame() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.GAME_PATH);
	}

	@FXML
	private void backToTitle() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.TITLE_PATH);
	}

}
