package app.scene.result.controller;

import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ResultController {

	@FXML Button helloButton;

	@FXML
	private void hello() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.TITLE_PATH);
	}

}
