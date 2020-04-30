package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locator_regular 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
		driver.findElement(By.cssSelector("a[title*='Already']")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("hello");
		driver.findElement(By.name("passwd")).sendKeys("bye");
		driver.findElement(By.xpath("//input[contains(@title,'Sign') and @name='proceed']")).click();
		System.out.println(driver.findElement(By.cssSelector("div.div_login_error")).getText());
		driver.close();
	}
}
