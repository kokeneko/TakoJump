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
			waveUp(10);
		});
		timer = new Timeline(keyFrame);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	private void waveUp(int risingWidth) {
		wave.setLayoutY(wave.getLayoutY() - risingWidth);
	}

	public void waveDown(int downWidth) {
		wave.setLayoutY(wave.getLayoutY() + downWidth);
	}
}
