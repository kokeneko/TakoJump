package app.scene.game.controller;

import app.scene.Wave;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;

public class WaveController {
	@FXML private Rectangle waveRectangle;
	private Wave wave;

	@FXML
	private void initialize() {
		wave = new Wave(waveRectangle);
		wave.waveStart(1);
	}
}