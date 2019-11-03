package app.scene;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Transition {
	public static Stage stage = new Stage();
	public static Scene scene;

	public static final String TITLE_PATH = "./title/fxml/Title.fxml";
	public static final String GAME_PATH = "./game/fxml/Game.fxml";
	public static final String RESULT_PATH = "./result/fxml/Result.fxml";
	public static final String RANKING_PATH = "./ranking/fxml/Ranking.fxml";

	public void transitionFirstScene() {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(TITLE_PATH));
			scene = new Scene(root, 400, 400);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public void transitionTo(String path) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(path));
			scene.setRoot(root);
			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
