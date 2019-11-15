package app.scene.game.controller;

import app.scene.Floor;
import app.scene.Tako;
import app.scene.Wave;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameController {

	@FXML private AnchorPane base;
	@FXML private ImageView takoImage;
	@FXML private WaveController waveController;

	private Image image;
	private Wave wave;

	@FXML
	private void initialize() {
		WaveController waveController = new WaveController();
		wave = waveController.getWave();

		Floor floor = new Floor();
		image = floor.assignImage("normal");

		Tako tako = new Tako(takoImage);
		base.setOnKeyPressed(e -> keyPressedEvent(e, tako, wave));

		//始めの床を生成し、paneに載せる
		base.getChildren().add(floor.generate(image, 0, 300, 13));
	}
	private void keyPressedEvent(KeyEvent e, Tako tako, Wave wave) {
		switch(e.getCode()) {
			case LEFT: tako.leftSlide(); break;
			case RIGHT: tako.rightSlide(); break;
			case DOWN: base = tako.jump(base, wave); break;
			default: break;
		}
	}
}