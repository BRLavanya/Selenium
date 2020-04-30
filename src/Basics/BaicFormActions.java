package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaicFormActions
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/login.html");
		System.out.println("page heading is : "+driver.getTitle());
		driver.findElement(By.id("email")).sendKeys("hello");
		driver.findElement(By.id("passwd")).sendKeys("test");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("test");
		driver.findElement(By.xpath("//input[@class='hidden']/following-sibling::button/child::span/child::i[starts-with(@class,'icon-lock')]")).click();
		System.out.println("page heading is : "+driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//h3")).getText());
	}
}
