package app.scene.result.controller;

import app.scene.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ResultController {

	@FXML Button helloButton;

	@FXML
	private void hello() {
		Transition transition = new Transition();
		transition.transitionTo(Transition.TITLE_PATH);
	}

}
