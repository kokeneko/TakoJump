package app.scene;

import java.io.IOException;

import app.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Transition {
	public static final String TITLE_PATH = "./title/fxml/Title.fxml";
	public static final String GAME_PATH = "./game/fxml/Game.fxml";
	public static final String RESULT_PATH = "./result/fxml/Result.fxml";
	public static final String RANKING_PATH = "./ranking/fxml/Ranking.fxml";

	public void transitionTo(String path) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource(path));
			Scene scene = new Scene(root,400,400);
			Main.stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
