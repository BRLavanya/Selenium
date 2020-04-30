package Basics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleWindow {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signin");
		driver.findElement(By.xpath("//*[text()='Privacy']")).click();
		System.out.println(driver.getTitle());
		Set<String>childWindows=driver.getWindowHandles();
		String ParentWindow=driver.getWindowHandle();
		Iterator<String>it=childWindows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		System.out.println("child: "+driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.println("Parent: "+driver.getTitle());
		driver.quit();
//		while(it.hasNext())
//		{
//			String child=it.next();
//			if(!ParentWindow.equalsIgnoreCase(child))
//			{
//				System.out.println(it.next()+" "+ParentWindow);
//				driver.switchTo().window(child);
//				System.out.println(driver.getTitle());
//
//			}
//		}
	}
}
