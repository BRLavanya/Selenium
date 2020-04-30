package Basics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LinksCount {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println("number of links are : " + driver.findElements(By.xpath("//a")).size());
		WebElement footerDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(
				"number of links in the footer section is : " + footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table//tbody/tr/td[1]/ul"));
		int size = columnDriver.findElements(By.tagName("a")).size();
		System.out.println("number of links in the footer section is : " + size);
		System.out.println("title heading is : " + driver.getTitle());
		for (int i = 1; i < size; i++) {
			WebElement link = columnDriver.findElements(By.tagName("a")).get(i);
			Actions act = new Actions(driver);
			act.keyDown(Keys.CONTROL).click(link).build().perform();
		}
		Set<String> WindowId = driver.getWindowHandles();
		Iterator<String> it = WindowId.iterator();
		String Parent = it.next();
		while (it.hasNext()) {
			String child = it.next();
			if (!Parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				System.out.println("title heading is : " + driver.getTitle());
				driver.switchTo().window(Parent);
			}
		}

		driver.quit();
	}
}
