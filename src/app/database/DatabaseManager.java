package app.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseManager {
	private BufferedReader bufferedReader;
	private FileWriter fileWriter;
	private File file;
	private List<Integer> dataList = new ArrayList<Integer>();

	public DatabaseManager() {
		String tmpData;

		try {
			// ファイルのパスを指定する
			File dir = new File("src/app/database");
		    dir.mkdirs();
			file = new File(dir, "data.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			// ランキングは10位まで表示
			for (int i = 0; i < 10; i++) {
				if ((tmpData = bufferedReader.readLine()) == null) {
					break;
				}
				dataList.add(Integer.parseInt(tmpData));
			}
			bufferedReader.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> getData() {
		return dataList;
	}

	public void writeData(int score) {
		String writeText = "";

		dataList.add(score);
		Collections.sort(dataList, Collections.reverseOrder());

		// ランキングは10位まで
		while (dataList.size() > 10) {
			dataList.remove(10);
		}

		try {
			fileWriter = new FileWriter(file);
			for (Integer integer : dataList) {
				writeText += integer + "\n";
			}
			fileWriter.write(writeText);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
