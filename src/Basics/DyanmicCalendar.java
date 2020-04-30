package Basics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DyanmicCalendar {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//div//*[@id='travel_date']")).click();
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']//*[@class='datepicker-switch']")).getText().contains("July")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']")).click();
		}
		
		int count=driver.findElements(By.className("day")).size();
		for(int i=0;i<count;i++)
		{
			String text= driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("16"))
			{
				System.out.println(driver.findElements(By.className("day")).get(i).getText());
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	 }
}
