package app.scene.game.controller;

import app.scene.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {

	@FXML Button helloButton;

	@FXML
	private void hello() {
		Transition transition = new Transition();
		transition.transitionTo(Transition.RESULT_PATH);
	}

}
