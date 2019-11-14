package app.scene;

import java.net.URISyntaxException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Floor {
	private String type; //ブロックの種類
	private static final  String FLOOR_NORMAL = "./images/floor_normal.png";
	private Group group = new Group(); //床をグループ化する

	//画像をtype毎に代入する
	public Image assignImage(String type) {
		if (type.equals("normal")) {
				try {
					this.type = getClass().getResource(FLOOR_NORMAL).toURI().toString();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
		}
		return new Image(this.type);
	}

	//床を座標(x, y)にblocks 分生成する
	public Group generate(Image image, double x, double y, int blocks) {
		//blocks分
		double width = image.getWidth();
		for (int i = 0; i < blocks; i++) {
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			imageView.setX(x);
			imageView.setY(y);
			group.getChildren().add(imageView);
			x += width;
		}
		return group;
	}
}