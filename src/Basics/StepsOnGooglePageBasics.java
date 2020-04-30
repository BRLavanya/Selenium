package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StepsOnGooglePageBasics {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https:\\www.google.com");
		driver.manage().window().maximize();
		System.out.println("maxmizimze the browser ");
		String title= driver.getTitle();
		if(title.equals("Google"))
		{
			System.out.println("title matches and it is: "+title);
		}
		else
		{
			System.out.println("title does not match");
		}
		System.out.println("the current url is : "+driver.getCurrentUrl());
		System.out.println("navigating to yoahoo");
		driver.navigate().to("http:\\yahoo.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.get("https:\\www.google.com");
		driver.findElement(By.xpath("//div[@class='SDkEP']//div[@class='a4bIc']//input")).sendKeys("google");
		Thread.sleep(5000);
		driver.close();
	}
}
