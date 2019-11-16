package app.scene.game.controller;

import app.scene.BackScreen;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GameBackScreenController {

	@FXML private AnchorPane backScreenBase;

	@FXML
	private void initialize() {
		BackScreen backScreen = new BackScreen(backScreenBase);
	}
}
