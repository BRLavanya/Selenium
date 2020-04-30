package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment8 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qaclickacademy.com/");
		driver.findElement(By.xpath("//a[text()='Practice']")).click();
		String Expected_text = "India";
		WebElement option = driver.findElement(By.id("autocomplete"));
		option.sendKeys("in");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String Actual_text = (String) js.executeScript(script);
		while (!Actual_text.equalsIgnoreCase(Expected_text)) {
			option.sendKeys(Keys.DOWN);
			Actual_text = (String) js.executeScript(script);
			if(Actual_text.equalsIgnoreCase("ind"))
			{
				break;
			}
		}
	}

}
