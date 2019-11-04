package app.scene.game.controller;

import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {

	@FXML Button helloButton;

	@FXML
	private void hello() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.RESULT_PATH);
	}

}
