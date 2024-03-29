package app.scene;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Wave {

	private Rectangle wave;
	private Duration waveDuration;
	private Timeline timer;

	public Wave(Rectangle waveRectangle) {
		this.wave = waveRectangle;
	}

	public void waveStart(double seconds) {
		waveDuration = Duration.seconds(seconds);
		if ( timer != null ) {
			timer.stop();
		}
		KeyFrame keyFrame = new KeyFrame(waveDuration, (ActionEvent) ->  {
			if ( wave.getLayoutY() <= 0 ) {
				waveStop();
			}
			waveUp(15);
		});
		timer = new Timeline(keyFrame);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	private void waveStop() {
		if ( timer != null ) {
			timer.stop();
		}
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.RESULT_PATH);
	}

	public void waveUp(double risingWidth) {
		wave.setLayoutY(wave.getLayoutY() - risingWidth);
	}

	public void waveDown(double downWidth) {
		wave.setLayoutY(downWidth);
	}

	public double getWaveY() {
		return wave.getLayoutY();
	}

	public Rectangle getWaveRectangle() {
		return wave;
	}
}
