package app.font;

import java.io.File;

import javafx.scene.text.Font;

public class FontManager {

	public Font getFont() {
		// フォントは美咲ゴシック第２を使用
		// 25はサイズ、適当
		Font font = Font.loadFont(new File("./src/app/font/misaki_gothic_2nd.ttf").toURI().toString(), 25);
		return font;
	}

}
