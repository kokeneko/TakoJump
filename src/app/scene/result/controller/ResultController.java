package app.scene.result.controller;

import java.util.ArrayList;
import java.util.List;

import app.font.FontManager;
import app.scene.SceneManager;
import app.scene.result.ResultScoreManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

public class ResultController {

	@FXML private Label gameoverLabel, highScoreTextLabel;
	@FXML private Label newRecordLabel;
	@FXML private Label scoreLabel, highScoreLabel;
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

		// スコアは仮に適当な値を入れてます
		// 確認するときは勝手に値を入れてね
		ResultScoreManager rsm = new ResultScoreManager(scoreLabel, highScoreLabel, newRecordLabel, 500000);

		FontManager fontManager = new FontManager();
		gameoverLabel.setFont(fontManager.getFont(50));
		newRecordLabel.setFont(fontManager.getFont(20));
		scoreLabel.setFont(fontManager.getFont(40));
		Font font = fontManager.getFont(25);
		highScoreTextLabel.setFont(font);
		highScoreLabel.setFont(font);
		restartLabel.setFont(font);
		toTitleLabel.setFont(font);
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
