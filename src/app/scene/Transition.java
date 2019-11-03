package app.scene;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
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
			scene.setOnKeyPressed(e -> keyPressedEvent(e, root.getChildren()));
			root.getChildren();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
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

	public void keyPressedEvent(KeyEvent e, ObservableList<Node> observableList) {
		switch(e.getCode()) {
		case UP: up(observableList); break;
		case DOWN: down(observableList); break;
		default: break;
		}
	}

	public void up(ObservableList<Node> observableList) {
		System.out.println("up");
		observableList.get(3).setLayoutY(observableList.get(1).getLayoutY() + 18);
	}

	public void down(ObservableList<Node> observableList) {
		System.out.println("down");
		observableList.get(3).setLayoutY(observableList.get(2).getLayoutY() + 18);
	}

}
