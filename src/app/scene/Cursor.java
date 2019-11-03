package app.scene;

import java.util.List;

import javafx.scene.Node;

public class Cursor {
	private Node cursor;
	private List<Node> optionList;

	public Cursor(Node cursor, List<Node> optionList) {
		this.cursor = cursor;
		this.optionList = optionList;
	}

	public void up() {
		System.out.println("up");
		cursor.setLayoutY(optionList.get(0).getLayoutY() + 18);
	}

	public void down() {
		System.out.println("down");
		cursor.setLayoutY(optionList.get(1).getLayoutY() + 18);
	}

}
