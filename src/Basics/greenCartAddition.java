package Basics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class greenCartAddition {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] itemsName = { "Beans", "Onion" };
		greenCartAddition g = new greenCartAddition();
		g.addItems(driver, itemsName);

	}

	public void addItems(WebDriver driver, String[] itemsName) {
		int count = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int j = 0; j < products.size(); j++) {
			String[] productsName = products.get(j).getText().split("-");
			String formattedName = productsName[0].trim();
			List<String> itemsNamesList = Arrays.asList(itemsName);
			if (itemsNamesList.contains(formattedName)) {
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(j).click();
				if (count == itemsName.length) {
					break;
				}

			}
		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']//child::button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//*[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//*[@class='promoBtn']")).click();
		
		WebElement promInfo=driver.findElement(By.xpath("//*[@class='promoInfo']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(promInfo));
		System.out.println(promInfo.getText());
	}

}
