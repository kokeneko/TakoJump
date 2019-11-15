package app.scene.game.controller;

import app.scene.BackScreen;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class BackScreenController {

	@FXML
	private AnchorPane backScreen1;
	@FXML
	private AnchorPane backScreen2;

	private BackScreen backScreen;

	@FXML
	private void initialize() {
		backScreen = new BackScreen(backScreen1, backScreen2);
	}

}
