package wj.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import wj.csv.pojo.User;

public class CsvReader {
	
	/**
	 * 指定したCSVファイルからユーザーデータを読み込む、DBへ格納する．
	 * @param filePath　CSVファイルのファイルパス
	 * @return　List<User>　CSVファイルから読み取ったデータをユーザークラスに保存し、ユーザーリストを作り、
	 * 						ユーザーデータを一気にＤＢへ格納する
	 * @throws Exception　
	 */
	public static List<User> readCsv(String filePath) throws Exception {
		File file = new File(filePath);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
		
		//CSVファイルの2行目からデータをDBへ格納する．ファイルの1行目が必要の時、このコードを削除してください
		bReader.readLine();
		
		String line = null;
		List<User> userList = new ArrayList<User>();
	
		//一行ずつデータを読み込んで、ユーザーリストに保存
		while ((line = bReader.readLine()) != null) {
			if (line.trim() != "") {
				String items[] = line.trim().split(",");
				User user = new User();
				user.setId(Integer.parseInt(items[0]));
				user.setUsername(items[1]);
				user.setPassword(items[2]);
				user.setEmail(items[3]);
				userList.add(user);
			}
		}
		bReader.close();
		return userList;
	}
}
