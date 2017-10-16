

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;

public class ImportCsv {

	public static void main(String[] args) {
		 String filePath="D:\\\\down\\\\rating.csv";
		downFile(filePath);
		DelQuest delQuest=new DelQuest();
		delQuest.main();
		readCsvUsingLoad(filePath);
		//delFile(filePath);
	}
		public static void downFile(String filePath){
		String url = "http://ttw.ru/ttw-rs/data/rating.csv";
			try {
				downloadUsingStream(url,filePath);
			} catch (IOException e) {
				e.printStackTrace();
}}

	private static void downloadUsingStream(String urlStr, String file) throws IOException{
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count=0;
		while((count = bis.read(buffer,0,1024)) != -1)
		{
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}
		private static void readCsvUsingLoad(String filePath)
		{
				try (Connection connection = DBConnection.getConnection())
				{
					Statement stmt = connection.createStatement();
						String truncQuery = "TRUNCATE `test_csv`.`csvttw`";
						stmt.execute(truncQuery);
						String loadQuery = "LOAD DATA LOCAL INFILE '" + filePath + "' INTO TABLE csvttw character set cp1251 FIELDS TERMINATED BY ';'"
										+ " LINES TERMINATED BY '\n' (number,player,town,cups,games,rating,delta,date) ";
					stmt.execute(loadQuery);
				}
				catch (Exception e)
				{
						e.printStackTrace();
				}
		}

		public static void delFile(String filePath){
			File file = new File(filePath);
			if(file.delete()){
				System.out.println(filePath + "файл удален");
			}else System.out.println(filePath + " не обнаружено");
		}

	public static void changeFile(String filePath, String filePath1){
		File file = new File(filePath);
		File file1 = new File(filePath1);
		delFile(filePath);
		if(file1.renameTo(file)){
			System.out.println(filePath + "файл переименован");
		}else System.out.println(filePath + " не обнаружено");

	}

}
