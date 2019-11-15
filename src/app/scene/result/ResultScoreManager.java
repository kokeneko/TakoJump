package app.scene.result;

import app.database.DatabaseManager;
import javafx.scene.control.Label;

public class ResultScoreManager {
	// データベース読み書き用
	private DatabaseManager databaseManager = new DatabaseManager();

	public ResultScoreManager(Label scoreLabel, Label highScoreLabel, Label newRecordLabel, int score) {
		showNewRecordLabel(newRecordLabel, score);
		setScore(scoreLabel, score);
		setHighScore(highScoreLabel);
	}

	private void setScore(Label scoreLabel, int score) {
		scoreLabel.setText(score + "");
		databaseManager.writeData(score);
	}

	private void setHighScore(Label highScoreLabel) {
		highScoreLabel.setText(databaseManager.getData().get(0) + "");
	}

	private void showNewRecordLabel(Label newRecordLabel, int score) {
		if (score > databaseManager.getData().get(0)) {
			newRecordLabel.setVisible(true);
		}
		else {
			newRecordLabel.setVisible(false);
		}
	}

}
