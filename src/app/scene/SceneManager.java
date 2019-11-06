package app.scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.scene.result.controller.ResultController;
import app.scene.title.controller.TitleController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneManager {
	public static Stage stage = new Stage();
	public static Scene scene;

	public static final String TITLE_PATH = "./title/fxml/Title.fxml";
	public static final String GAME_PATH = "./game/fxml/Game.fxml";
	public static final String RESULT_PATH = "./result/fxml/Result.fxml";
	public static final String RANKING_PATH = "./ranking/fxml/Ranking.fxml";

	private final Map<String, AnchorPane> roots = new HashMap<>();

	public void transitionFirstScene() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(TITLE_PATH));
			roots.put(TITLE_PATH, root);
			scene = new Scene(root, 400, 400);
			Cursor cursor = new Cursor(root.getChildren().get(3), TitleController.titleOptionsLabel, TitleController.titleOptionsPath);
			scene.setOnKeyPressed(e -> keyPressedEvent(e, cursor));
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void transitionTo(String path) {
		try {
			AnchorPane root;
			if (roots.get(path) == null) {
				root = (AnchorPane)FXMLLoader.load(getClass().getResource(path));
				roots.put(path, root);
			}
			root = roots.get(path);
			scene.setRoot(root);
			if (path.equals(TITLE_PATH)) {
				Cursor cursor = new Cursor(root.getChildren().get(3), TitleController.titleOptionsLabel, TitleController.titleOptionsPath);
				scene.setOnKeyPressed(e -> keyPressedEvent(e, cursor));
			}
			else if (path.equals(RESULT_PATH)) {
				Cursor cursor = new Cursor(root.getChildren().get(7), ResultController.resultOptionsLabel, ResultController.resultOptionsPath);
				scene.setOnKeyPressed(e -> keyPressedEvent(e, cursor));
			}
			else {
				scene.setOnKeyPressed(null);
			}
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void keyPressedEvent(KeyEvent e, Cursor cursor) {
		switch(e.getCode()) {
		case UP: cursor.up(); break;
		case DOWN: cursor.down(); break;
		case ENTER: cursor.select(); break;
		default: break;
		}
	}

}
