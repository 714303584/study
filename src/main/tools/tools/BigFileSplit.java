package tools;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigFileSplit {
	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream input = new FileInputStream("G:\\mcc-api1.out");
		InputStreamReader iReader = new InputStreamReader(input);
		BufferedReader reader = new BufferedReader(iReader);
		String str = null;
		int i = 1;
		int j = 0;
		try {
			FileOutputStream file = null;
			while ((str = reader.readLine()) != null) {
				 if(file == null){
					 file = new FileOutputStream("G:\\filespiliter\\"+"s"+i+".txt");
				 }
				 str = str+"\n";
				 file.write(str.getBytes());
				 System.out.println(j);
				 if(j == 1000000){
					 j = 0;
					 file.close();
					 file = null;
					 i++;
				 }
				
				j++;
				
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	

}
