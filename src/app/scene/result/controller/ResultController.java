package app.scene.result.controller;

import java.util.ArrayList;
import java.util.List;

import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class ResultController {
	@FXML private Label newRecordLabel;
	@FXML private Label score, highScore;
	@FXML private Label restartLabel, toTitleLabel;
	@FXML private Polygon cursorPolygon;

	// ラベルと遷移先のパスのリスト
	// タイトル画面と同じくFXMLとは関係がないため、ここに書くべきではないかもしれない。
	public static List<Label> resultOptionsLabel;
	public static List<String> resultOptionsPath;

	@FXML
	private void initialize() {
		resultOptionsLabel = new ArrayList<>();
		resultOptionsLabel.add(restartLabel);
		resultOptionsLabel.add(toTitleLabel);
		resultOptionsPath = new ArrayList<>();
		resultOptionsPath.add(SceneManager.GAME_PATH);
		resultOptionsPath.add(SceneManager.TITLE_PATH);
	}

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
