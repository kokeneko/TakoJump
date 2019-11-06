package app.scene.ranking.controller;

import java.util.List;

import app.database.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RankingController {
	@FXML private List<Label> rankList;

	private List<Integer> dataList;

	@FXML
	private void initialize() {
		DatabaseManager databaseManager = new DatabaseManager();
		dataList = databaseManager.readData();

		for (int i = 0; i < dataList.size(); i++) {
			rankList.get(i).setText((i + 1) + "位 " + dataList.get(i) + "点");
		}
	}

}
