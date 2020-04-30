package Basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles 
{
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		String MainWindow=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String>it=s1.iterator();
		while(it.hasNext())
		{
			String Childwindow=it.next();
			if(!MainWindow.equalsIgnoreCase(Childwindow))
			{
				driver.switchTo().window(Childwindow);
				driver.findElement(By.name("emailid")).sendKeys("test@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				Thread.sleep(500);
				System.out.println(driver.findElement(By.xpath("//h2")).getText());
				driver.close();
			}	
		}
		driver.switchTo().window(MainWindow);
		System.out.println(driver.findElement(By.xpath("//h2")).getText());
		driver.close();

		}
}
