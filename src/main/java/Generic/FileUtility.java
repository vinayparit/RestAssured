package Generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String value = pObj.getProperty(key);
		return value;
	}
	
	public String writeDataToPropertyFile(String Key,String val) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String value=(String) pObj.setProperty(Key, val);
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		return value;
	}
}
