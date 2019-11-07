package app.scene.title.controller;

import java.util.ArrayList;
import java.util.List;

import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class TitleController {
	@FXML private Label titleLogo;
	@FXML private Label startLabel, rankingLabel;
	@FXML private Polygon cursorPolygon;

	private SceneManager sceneManager;
	// ラベルと遷移先のパスのラベル
	// FXMLとは関係がないため、ここに書くべきではないかもしれない。
	public static List<Label> titleOptionsLabel;
	public static List<String> titleOptionsPath;

	@FXML
	private void initialize() {
		sceneManager = new SceneManager();
		titleOptionsLabel = new ArrayList<>();
		titleOptionsLabel.add(startLabel);
		titleOptionsLabel.add(rankingLabel);
		titleOptionsPath = new ArrayList<>();
		titleOptionsPath.add(SceneManager.GAME_PATH);
		titleOptionsPath.add(SceneManager.RANKING_PATH);
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
