package app.scene;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Label;

public class Cursor {
	private Node cursor;
	private List<Label> labelList;
	private List<String> optionList;
	private int selectedOptionNumber = 0;

	private SceneManager sceneManager = new SceneManager();

	public Cursor(Node cursor, List<Label> titleOptionsLabel, List<String> titleOptionsPath) {
		this.cursor = cursor;
		this.labelList = titleOptionsLabel;
		this.optionList = titleOptionsPath;
		selectedOptionNumber = 0;
	}

	public void up() {
		if (selectedOptionNumber > 0) {
			selectedOptionNumber -= 1;
		}
		else {
			selectedOptionNumber = labelList.size() - 1;
		}
		cursor.setLayoutY(labelList.get(selectedOptionNumber).getLayoutY() + 18);
	}

	public void down() {
		if (selectedOptionNumber < labelList.size() - 1) {
			selectedOptionNumber += 1;
		}
		else {
			selectedOptionNumber = 0;
		}
		cursor.setLayoutY(labelList.get(selectedOptionNumber).getLayoutY() + 18);
	}

	public void select() {
		sceneManager.transitionTo(optionList.get(selectedOptionNumber));
	}

}