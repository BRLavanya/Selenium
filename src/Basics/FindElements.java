package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElements {
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/ajax.html");
		List<WebElement> buttons=driver.findElements(By.xpath("//*[@name='name']"));
		System.out.println("number of radio button is :"+buttons.size());
		for(int i = 0;i<buttons.size();i++)
		{
			System.out.println(buttons.get(i).getAttribute("value"));
			
		}
		driver.close();
	}
}
