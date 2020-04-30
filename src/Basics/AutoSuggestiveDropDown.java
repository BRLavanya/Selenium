package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestiveDropDown {
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(5000);
		WebElement source= driver.findElement(By.xpath("//*[@placeholder='From']"));
		source.sendKeys("ben",Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
		driver.findElement(By.id("toCity")).click();
		Thread.sleep(5000);
		WebElement dest= driver.findElement(By.xpath("//*[@placeholder='To']"));
		dest.sendKeys("del",Keys.ARROW_DOWN);
		dest.sendKeys(Keys.ENTER);
		
	}
	
}
