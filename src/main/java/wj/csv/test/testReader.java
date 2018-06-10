package wj.csv.test;

import java.util.List;

import org.junit.Test;

import wj.csv.CsvReader;
import wj.csv.pojo.User;

public class testReader {

	@Test
	public void testR() throws Exception {
		String filePath = "C:\\Users\\Administrator\\Desktop\\testCSV.csv";
		List<User> users = CsvReader.readCsv(filePath);
		System.out.println(users.toString());
	}
}
