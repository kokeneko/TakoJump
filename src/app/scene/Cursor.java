package app.scene;

import java.util.List;

import javafx.scene.Node;

public class Cursor {
	private Node cursor;
	private List<Node> optionList;
	private int selectedOptionNumber = 0;

	private SceneManager sceneManager = new SceneManager();

	public Cursor(Node cursor, List<Node> optionList) {
		this.cursor = cursor;
		this.optionList = optionList;
		selectedOptionNumber = 0;
	}

	public void up() {
		if (selectedOptionNumber > 0) {
			selectedOptionNumber -= 1;
		}
		else {
			selectedOptionNumber = optionList.size() - 1;
		}
		cursor.setLayoutY(optionList.get(selectedOptionNumber).getLayoutY() + 18);
	}

	public void down() {
		if (selectedOptionNumber < optionList.size() - 1) {
			selectedOptionNumber += 1;
		}
		else {
			selectedOptionNumber = 0;
		}
		cursor.setLayoutY(optionList.get(selectedOptionNumber).getLayoutY() + 18);
	}

	public void select() {
		switch (selectedOptionNumber) {
		case 0: sceneManager.transitionTo(SceneManager.GAME_PATH); break;
		case 1: sceneManager.transitionTo(SceneManager.RANKING_PATH); break;
		default: break;
		}
	}

}
