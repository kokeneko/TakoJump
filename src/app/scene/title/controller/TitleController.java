package app.scene.title.controller;

import app.scene.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TitleController {

	@FXML Button startButton;

	@FXML
	private void start() {
		Transition transition = new Transition();
		transition.transitionTo(Transition.GAME_PATH);

	}

}
