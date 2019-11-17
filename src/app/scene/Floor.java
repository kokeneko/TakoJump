package app.scene;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Floor {

	private String type; // ブロックの種類
	private static final String FLOOR_NORMAL = "./images/floorNormal.png";
	private static final String FLOOR_ICE = "./images/floorIce.png";
	private static final String FLOOR_ROLL = "./images/floorRoll.png";
	private static final String FLOOR_SLIDE = "./images/floorSlide.png";

	private Group group = new Group(); // 床をグループ化する

	// 画像をtype毎に代入する
	public Image assignImage(String type) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("normal", FLOOR_NORMAL);
		hashmap.put("ice", FLOOR_ICE);
		hashmap.put("roll", FLOOR_ROLL);
		hashmap.put("slide", FLOOR_SLIDE);

		try {
			this.type = getClass().getResource(hashmap.get(type)).toURI().toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new Image(this.type);
	}

	// 床を座標(x, y)にblocks 分生成する
	public Group generate(Image image, double x, double y, int blocks) {
		// blocks分
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

//画面サイズからブロック分を引く
	public int randX(int score) {
		Random rand = new Random();
		return rand.nextInt(400 - (randBlocks(score) * 32));
	}

	// スコアによってブロック数を変える
	public int randBlocks(int score) {
		int blocks;
		if (score <= 5000) {
			blocks = 5;
		} else if (score <= 10000) {
			blocks = 4;
		} else if (score <= 15000) {
			blocks = 3;
		} else if (score <= 20000) {
			blocks = 2;
		} else {
			blocks = 1;
		}
		return blocks;
	}

	// 種類をランダムに設定
	public String randType() {
		Random rand = new Random();
		int randomValue = rand.nextInt(4);
		if (randomValue == 0) {
			return "normal";
		} else if (randomValue == 1) {
			return "ice";
		} else if (randomValue == 2) {
			return "roll";
		} else {
			return "slide";
		}
	}
}
