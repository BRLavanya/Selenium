package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment7 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qaclickacademy.com/");
		driver.findElement(By.xpath("//a[text()='Practice']")).click();
		int Row_Count=driver.findElements(By.xpath("//table[@id='product']//tbody//tr")).size();
		System.out.println("the number of rows is: "+Row_Count);
		int Col_Count=driver.findElements(By.xpath("//table[@id='product']//tbody//tr//th")).size();
		System.out.println("the number of cols is: "+Col_Count);
		System.out.println("the details of 2nd row is ");
		List<WebElement>secondRow=driver.findElements(By.xpath("//table[@id='product']//tbody//tr[3]//td"));
		for(int i =0;i<secondRow.size();i++)
		{
			System.out.print(secondRow.get(i).getText()+"\t");
		}
		driver.close();
		
	}
}
