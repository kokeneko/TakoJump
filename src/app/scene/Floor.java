package app.scene;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Floor {

	private String type; // ブロックの種類
	private double speed = 1.5;// スライドブロックの速さ

	public static final String FLOOR_NORMAL = "nomal";
	public static final String FLOOR_ICE = "ice";
	public static final String FLOOR_ROLL = "roll";
	public static final String FLOOR_SLIDE = "slide";

	private final String FLOOR_NORMAL_PATH = "./images/floorNormal.png";
	private final String FLOOR_ICE_PATH = "./images/floorIce.png";
	private final String FLOOR_ROLL_PATH = "./images/floorRoll.png";
	private final String FLOOR_SLIDE_PATH = "./images/floorSlide.png";

	// 画像をtype毎に代入する
	private Image assignImage(String type) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put(FLOOR_NORMAL, FLOOR_NORMAL_PATH);
		hashmap.put(FLOOR_ICE, FLOOR_ICE_PATH);
		hashmap.put(FLOOR_ROLL, FLOOR_ROLL_PATH);
		hashmap.put(FLOOR_SLIDE, FLOOR_SLIDE_PATH);

		try {
			this.type = getClass().getResource(hashmap.get(type)).toURI().toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return new Image(this.type);
	}

	// 床を座標(x, y)にblocks 分生成する
	public Group generate(String type, double x, double y, int blocks) {
		Group group = new Group();
		Image image = assignImage(type);
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
		group.setId(type);
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
		switch (rand.nextInt(4)) {
		case 0:
			return FLOOR_NORMAL;
		case 1:
			return FLOOR_ICE;
		case 2:
			return FLOOR_ROLL;
		case 3:
			return FLOOR_SLIDE;
		default:
			break;
		}

		return FLOOR_NORMAL;
	}

	public void checkFloor(ImageView takoImage, Group floor, boolean LRFlag, int LRKeyPressTime) {
		// System.out.print(floor.getId());
		switch (floor.getId()) {
		case FLOOR_ICE:
			iceFloor(takoImage, LRFlag, LRKeyPressTime);
			break;
		case FLOOR_ROLL:
			rollFloor(takoImage);
			break;
		default:
			break;
		}
	}

	private void rollFloor(ImageView takoImage) {
		if (takoImage.getLayoutX() <= 0) {
			takoImage.setLayoutX(takoImage.getLayoutX() + 400);
		}
		if (takoImage.getLayoutX() >= 400) {
			takoImage.setLayoutX(takoImage.getLayoutX() - 400);
		}
		takoImage.setLayoutX(takoImage.getLayoutX() - 3);
	}

	private void iceFloor(ImageView takoImage, boolean LRFlag, int LRKeyPressTime) {
		if (LRFlag) {
			takoImage.setLayoutX(takoImage.getLayoutX() + LRKeyPressTime);
		} else {
			takoImage.setLayoutX(takoImage.getLayoutX() - LRKeyPressTime);
		}
	}

	public void slideFloor(ImageView takoImage, Group floor) {
		// System.out.print(floor.getLayoutX());
		if (floor.getId().equals(FLOOR_NORMAL)) {
			floor.setLayoutX(floor.getLayoutX() - speed);
			takoImage.setLayoutX(takoImage.getLayoutX() - speed);
			if (floor.getLayoutX() < 0 || 300 < floor.getLayoutX()) {
				speed *= -1;
			}
		}
	}

}
