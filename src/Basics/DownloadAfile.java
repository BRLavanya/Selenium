package Basics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadAfile
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/yahoo.html");
		WebElement download= driver.findElement(By.id("messenger-download"));
		String sourceLocation=download.getAttribute("href");
		
		//syntax for download
		String Wget_command="cmd /c Wget -p C:\\tmp "+sourceLocation;
		try
		{
			Process exec= Runtime.getRuntime().exec(Wget_command);
			int exitval=exec.waitFor();
			System.out.println("exit value is: "+exitval);
		}
		catch (IOException|InterruptedException e) 
		{
			System.out.println(e.toString());	
		}
	}
}
