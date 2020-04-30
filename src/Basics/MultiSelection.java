package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MultiSelection 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://output.jsbin.com/osebed/2");
		WebElement multi= driver.findElement(By.id("fruits"));
		Select fruits = new Select(multi);
		System.out.println("Is the drop down multi select??: "+fruits.isMultiple());
		fruits.selectByIndex(0);
		fruits.selectByValue("orange");
		fruits.selectByVisibleText("Apple");
		System.out.println("the number of selected is : "+fruits.getAllSelectedOptions().size());
		fruits.deselectByIndex(1);
		Thread.sleep(5000);
		fruits.deselectAll();
		System.out.println("the number of selected is : "+fruits.getAllSelectedOptions().size());
		
		
	}
}
