package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndTesting_SpiceJet {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.findElement(By.xpath("//a[@class='spicejet_logo']")).getAttribute("title"));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();	
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		if(driver.findElement(By.xpath("//span[@id='spclearDate']")).getAttribute("style").contains("none"))
		{	
				System.out.println("its a single trip");
				Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.xpath("//span[@id='spclearDate']")).getAttribute("style").contains("block"))
		{	
				System.out.println("its a round trip");
				Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("divpaxinfo")).click();
		Select adult= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("4");
		
		Select child= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		child.selectByIndex(2);
		
		Select infant= new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		infant.selectByVisibleText("1");
		
		Select currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		currency.selectByIndex(1);
		
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		System.out.println("the page heading is: "+driver.getTitle());
		
		Thread.sleep(5000);
		
		driver.close();
		
	}
}