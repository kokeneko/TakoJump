package app.scene;

import app.scene.game.controller.WaveController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Timer {

	private static Timeline timer;
	private Duration duration;
	public static int time;

	public void timerStart() {
		time = 0;
		WaveController waveController = new WaveController();
		Wave wave = waveController.getWave();

		// 1秒ごとに
		duration = Duration.millis(1000);
		KeyFrame keyFrame = new KeyFrame(duration, (ActionEvent) ->  {
			time++;
			changeSpeed(time, wave);
		});
		timer = new Timeline(keyFrame);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	private void changeSpeed(int time, Wave wave) {
		// timeに応じて早さを変える
		switch (time) {
			case 0: wave.waveStart(2); break;
			case 5: wave.waveStart(1.5); break;
			case 15: wave.waveStart(1.0); break;
			case 20: wave.waveStart(0.7); break;
			case 25: wave.waveStart(0.5); break;
			default: break;
		}
	}

	public void timerStop() {
		if ( timer != null ) {
			timer.stop();
		}
	}
}
