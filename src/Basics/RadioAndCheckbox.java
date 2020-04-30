package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioAndCheckbox 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/radio.html");
		List<WebElement>radio=driver.findElements(By.xpath("//input[starts-with(@id,'vfb-7-')]"));
		for(int i=0;i<radio.size();i++)
		{
			if(radio.get(i).getAttribute("value").equals("Option 2"))
			{
				radio.get(i).click();
				System.out.println(radio.get(i).getAttribute("value")+" is selected: "+radio.get(i).isSelected());
			}
		}
		List<WebElement>checkbox=driver.findElements(By.xpath("//input[starts-with(@id,'vfb-6-')]"));
		for(int i=0;i<checkbox.size();i++)
		{
			if(checkbox.get(i).isSelected())
			{
				System.out.println(checkbox.get(i).getAttribute("value")+" is selected");
			}
			else
			{
				System.out.println(checkbox.get(i).getAttribute("value")+" is not selected");
				checkbox.get(i).click();
				System.out.println(checkbox.get(i).getAttribute("value")+" is selected: "+checkbox.get(i).isSelected());

			}
				
		}
		driver.close();
	}
}