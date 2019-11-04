package app;

import app.scene.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private SceneManager sceneManager  = new SceneManager();

	@Override
	public void start(Stage primaryStage) {
		sceneManager.transitionFirstScene();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
