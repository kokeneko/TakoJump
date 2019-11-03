package app;

import app.scene.Transition;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private Transition transition  = new Transition();;

	@Override
	public void start(Stage primaryStage) {
		transition.transitionFirstScene();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
