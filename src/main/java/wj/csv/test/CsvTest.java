package wj.csv.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wj.csv.CsvReader;
import wj.csv.mapper.UserMapper;
import wj.csv.pojo.User;


/**
 * @author Administrator
 *　CSVファイルからデータを正確に読み込んで、DBへ格納することができるかどうかのテスト
 */
public class CsvTest {
	
	private ApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		//テストのセットアップメソッドにspringの設定ファイルを使用して、springを起動させる
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void insertUser() {
		//設定ファイルからユーザーマッパーを作成し、readCsvメソッドを呼び起こす。CSVファイルからデータをDBへ格納する
		UserMapper mapper = (UserMapper) context.getBean("userMapper");
		try {
			String filePath = "C:\\Users\\Administrator\\Desktop\\testCSV.csv";
			List<User> users = CsvReader.readCsv(filePath);
			for (User user: users) {
				mapper.insertUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
