package app.scene.result.controller;

import java.util.ArrayList;
import java.util.List;

import app.database.DatabaseManager;
import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class ResultController {
	@FXML private Label newRecordLabel;
	@FXML private Label scoreLabel, highScoreLabel;
	@FXML private Label restartLabel, toTitleLabel;
	@FXML private Polygon cursorPolygon;

	// ラベルと遷移先のパスのリスト
	// タイトル画面と同じくFXMLとは関係がないため、ここに書くべきではないかもしれない。
	public static List<Label> resultOptionsLabel;
	public static List<String> resultOptionsPath;

	// データベース読み書き用
	private DatabaseManager databaseManager = new DatabaseManager();

	@FXML
	private void initialize() {
		resultOptionsLabel = new ArrayList<>();
		resultOptionsLabel.add(restartLabel);
		resultOptionsLabel.add(toTitleLabel);
		resultOptionsPath = new ArrayList<>();
		resultOptionsPath.add(SceneManager.GAME_PATH);
		resultOptionsPath.add(SceneManager.TITLE_PATH);

		// スコアは仮に1000で固定
		setScore(1000);
		setHighScore();
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

	private void setScore(int score) {
		scoreLabel.setText(score + "");
		databaseManager.writeData(score);
	}

	private void setHighScore() {
		highScoreLabel.setText(databaseManager.getData().get(0) + "");
	}

}
