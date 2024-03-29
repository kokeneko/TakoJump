package app.scene.game.controller;

import app.scene.BackScreen;
import app.scene.Floor;
import app.scene.Tako;
import app.scene.Timer;
import app.scene.Wave;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameController {

	@FXML
	private AnchorPane base;
	@FXML
	private AnchorPane backScreenBase;
	@FXML
	private ImageView takoImage;

	private Wave wave;
	private int downKeyPressTime = 0;
	private int LRKeyPressTime = 0;

	@FXML
	private void initialize() {
		Timer timer = new Timer();
		timer.timerStart();

		WaveController waveController = new WaveController();
		wave = waveController.getWave();

		Tako tako = new Tako(takoImage);

		BackScreen backScreen = new BackScreen(backScreenBase);
		base.setOnKeyPressed(e -> keyPressedEvent(e, tako));
		base.setOnKeyReleased(e -> keyReleasedEvent(e, tako, backScreen, wave));

		Floor floor = new Floor();
		// 始めの床を生成し、paneに載せる
		base.getChildren().add(floor.generate(Floor.FLOOR_NORMAL, 0, 300, 13));
		// ここの二個目の床に関しては今は固定してる、固定じゃダメですか？
		base.getChildren().add(floor.generate(Floor.FLOOR_NORMAL, 20, 200, 5));

		tako.GameOver(takoImage, wave.getWaveRectangle(), wave);

	}

	private void keyPressedEvent(KeyEvent e, Tako tako) {
		switch (e.getCode()) {
		case LEFT:
			LRKeyPressTime--;
			tako.leftSlide();
			break;
		case RIGHT:
			LRKeyPressTime++;
			tako.rightSlide();
			break;
		case C:
			downKeyPressTime += 20;
			break;
		default:
			break;
		}
	}

	private void keyReleasedEvent(KeyEvent e, Tako tako, BackScreen backScreen, Wave wave) {
		switch (e.getCode()) {
		case C:
			if (!tako.getIsAir()) {
				tako.jump(base, backScreen, wave, downKeyPressTime, LRKeyPressTime);
				downKeyPressTime = 0;
				LRKeyPressTime = 0;
			}
			break;
		default:
			break;
		}
	}
}