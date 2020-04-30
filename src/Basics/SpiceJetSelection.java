package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJetSelection {
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
		Select sct = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		sct.selectByIndex(2);
//		driver.findElement(By.id("divpaxinfo")).click();
//		Select passenger= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
//		passenger.selectByValue("5");
		WebElement Armed=driver.findElement(By.id("ctl00_mainContent_IndArm"));
		Assert.assertFalse(Armed.isSelected());
		//System.out.println("chckbox is selected: "+Armed.isSelected());
		Armed.click();
		Assert.assertTrue(Armed.isSelected());
		//System.out.println("chckbox is selected: "+Armed.isSelected());
		System.out.println("the number of checkbox is: " + driver.findElements(By.xpath("//div[@id='discount-checkbox']//div")).size());
		driver.close();
	}

}
