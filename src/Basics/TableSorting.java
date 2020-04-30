package Basics;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TableSorting {
	public static void main(String[] args) throws IOException, Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.merge(ch);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[@href='#/offers']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@id='sortableTable']//thead//tr//th//span")).click();
		driver.findElement(By.xpath("//table[@id='sortableTable']//thead//tr//th//span")).click();
		List<WebElement> firstColList= driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		int size = firstColList.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(firstColList.get(i).getText());
		}
//		List<String> originalList = new ArrayList<String>(size);
//		List<String> copiedList = new ArrayList<String>(size);
//		 for (int i = 0; i < size;i++) 
//	      {
//			 originalList.add(list.get(i).getText());
//			 System.out.println(list.get(i).getText());
//	      }   
//		 
//		 copiedList.addAll(originalList);
//		 Collections.sort(copiedList);
//		 Assert.assertTrue(originalList.equals(copiedList));
		driver.quit();
	}
}
