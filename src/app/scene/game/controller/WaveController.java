package app.scene.game.controller;

import app.scene.Wave;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class WaveController {
	@FXML private Rectangle waveRectangle;
	@FXML private AnchorPane baseChild;

	private Wave wave;

	@FXML
	private void initialize() {
		wave = new Wave(waveRectangle);
		wave.waveStart(0.2);
	}

	public Wave getWave() {
		System.out.println(wave);
		return wave;
	}
}