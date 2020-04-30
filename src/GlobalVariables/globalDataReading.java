package GlobalVariables;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class globalDataReading {
	@Test
	public void readData() throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\BRLAVAN\\Desktop\\DL\\Personal\\Selenium_Learning\\src\\GlobalVariables\\data.properties");
		prop.load(fis);
		System.out.println("username is "+prop.getProperty("username"));
	}

}
