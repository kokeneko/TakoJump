package app.scene.ranking.controller;

import java.util.List;

import app.database.DatabaseManager;
import app.font.FontManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class RankingController {
	@FXML private AnchorPane base;
	@FXML private Label rankingLabel, transitionLabel;
	@FXML private List<Label> rankList;

	private List<Integer> dataList;

	@FXML
	private void initialize() {
		DatabaseManager databaseManager = new DatabaseManager();
		dataList = databaseManager.getData();
		for (int i = 0; i < dataList.size(); i++) {
			// 順位は5桁の空白埋め、スコアは20桁の空白埋め
			// レイアウトがいい感じになるようにしているので特に桁数に意味は無し
			rankList.get(i).setText(String.format("%5s", (i + 1)) + "位 " + String.format("%20s", dataList.get(i)) + "点");

		}

		FontManager fontManager = new FontManager();
		Font font = fontManager.getFont(25);
		rankingLabel.setFont(font);
		transitionLabel.setFont(font);
		for (Label rank : rankList) {
			rank.setFont(font);
		}
	}

}
