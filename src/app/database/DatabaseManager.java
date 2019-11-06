package app.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
	private BufferedReader bufferedReader;

	public DatabaseManager() {
		try {
			// ファイルのパスを指定する
			File file = new File("./src/app/database/data.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			bufferedReader = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Integer> readData() {
		List<Integer> dataList = new ArrayList<Integer>();
		String tmpData;

		try {
			// ランキングは10位まで表示
			for (int i = 0; i < 10; i++) {
				if ((tmpData = bufferedReader.readLine()) == null) {
					break;
				}
				dataList.add(Integer.parseInt(tmpData));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		return dataList;
	}

}
