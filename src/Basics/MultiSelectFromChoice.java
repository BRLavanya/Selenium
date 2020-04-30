package Basics;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultiSelectFromChoice
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://output.jsbin.com/osebed/2");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the option to select");
		String fruit= sc.next();
		List<WebElement>opt=driver.findElements(By.xpath("//*[@id='fruits']//*"));
		for(int i=0;i<opt.size();i++)
		{
			if(opt.get(i).getText().equals(fruit))
			{
				opt.get(i).click();
			}
		}
		Thread.sleep(5000);
		
	}
}
