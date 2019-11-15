package app.scene.game.controller;

import app.scene.Floor;
import app.scene.SceneManager;
import app.scene.Tako;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameController {

	@FXML private Button helloButton;
	@FXML private AnchorPane base;
	@FXML private ImageView takoImage;

	private Image image;

	@FXML
	private void initialize() {
		Floor floor = new Floor();
		image = floor.assignImage("normal");

		Tako tako = new Tako(takoImage);
		base.setOnKeyPressed(e -> keyPressedEvent(e, tako));

		//始めの床を生成し、paneに載せる
		base.getChildren().add(floor.generate(image, 0, 300, 13));
	}

	@FXML
	private void hello() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.RESULT_PATH);
	}

	private void keyPressedEvent(KeyEvent e, Tako tako) {
		switch(e.getCode()) {
			case LEFT: tako.leftSlide(); break;
			case RIGHT: tako.rightSlide(); break;
			case DOWN: base = tako.jump(base); break;
			default: break;
		}
	}
}