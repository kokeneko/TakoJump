package app.scene.game.controller;
import app.scene.Floor;
import app.scene.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class GameController {
	@FXML
	private Button helloButton;
	@FXML
	private AnchorPane base;
	
	private Image image ;

	@FXML
	private void initialize() {
		Floor floor = new Floor();
		image = floor.assignImage("normal");
		//始めの床を生成し、paneに載せる
		base.getChildren().add(floor.generate(image, 0, 300, 13));
	}
	@FXML
	private void hello() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.transitionTo(SceneManager.RESULT_PATH);
	}
}