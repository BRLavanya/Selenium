package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Assignment1 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement bmw= driver.findElement(By.id("checkBoxOption1"));
		bmw.click();
		Assert.assertTrue(bmw.isSelected(), "Checkbox is selected");
		bmw.click();
		Assert.assertFalse(bmw.isSelected(), "Checkbox is un-selected");
		System.out.println("number of checkboxes present in the page is: "+driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		driver.close();
	}
}
