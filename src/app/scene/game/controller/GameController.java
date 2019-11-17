package app.scene.game.controller;

import app.scene.BackScreen;
import app.scene.Floor;
import app.scene.Tako;
import app.scene.Timer;
import app.scene.Wave;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class GameController {

	@FXML private AnchorPane base;
	@FXML private AnchorPane backScreenBase;
	@FXML private ImageView takoImage;

	private Image image;
	private Wave wave;

	@FXML
	private void initialize() {
		Timer timer = new Timer();
		timer.timerStart();

		WaveController waveController = new WaveController();
		wave = waveController.getWave();

		Floor floor = new Floor();
		image = floor.assignImage("normal");
		// 初期配置の床2個目
		Floor floor2 = new Floor();
		image = floor2.assignImage("normal");

		Tako tako = new Tako(takoImage);

		BackScreen backScreen = new BackScreen(backScreenBase);
		base.setOnKeyPressed(e -> keyPressedEvent(e, tako, backScreen, wave));

		//始めの床を生成し、paneに載せる
		base.getChildren().add(floor.generate(image, 0, 300, 13));
		//ここの二個目の床に関しては今は固定してる、固定じゃダメですか？
		base.getChildren().add(floor2.generate(image, 20, 200, 5));

		tako.GameOver(takoImage, wave.getWaveRectangle(), wave);
	}

	private void keyPressedEvent(KeyEvent e, Tako tako, BackScreen backScreen, Wave wave) {
		switch(e.getCode()) {
			case LEFT: tako.leftSlide(); break;
			case RIGHT: tako.rightSlide(); break;
			case DOWN: if ( !tako.getIsAir() ) { tako.jump(base, backScreen, wave); } break;
			default: break;
		}
	}
}