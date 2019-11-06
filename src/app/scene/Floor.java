package app.scene;

import java.net.URISyntaxException;

import app.scene.game.controller.GameController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Floor {

	private String type;//ブロックの種類

	public final static String FLOOR_NORMAL = "./images/floor_normal.png" ;

	//画像をtype毎に代入する
	public Image assignmentImage(String type) {
		if(type.equals("normal")) {
				try {
					this.type = getClass().getResource(FLOOR_NORMAL).toURI().toString();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
		}
		return new Image(this.type);
	}
	//床を座標(x, y)にblocks 分生成する
	public void generate(Image image, double x, double y, int blocks) {
		//blocks 分
		double width = image.getWidth();
		for(int i = 0;i < blocks;i++) {
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setX(x);
			imageView.setY(y);
			GameController.group.getChildren().add(imageView);
			x += width;
		}
	}
}
