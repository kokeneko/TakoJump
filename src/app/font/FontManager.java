package app.font;

import javafx.scene.text.Font;

public class FontManager {

	public Font getFont(double size) {
		// フォントは美咲ゴシック第２を使用
		// 25はサイズ、適当
		Font font = Font.loadFont(getClass().getResource("misaki_gothic_2nd.ttf").toString(), size);
		return font;
	}

}
