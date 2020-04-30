package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset//label//input[@id='checkBoxOption2']")).click();
		String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		Select sct= new Select(driver.findElement(By.id("dropdown-class-example")));
		sct.selectByVisibleText(opt);
		driver.findElement(By.id("name")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		Alert act=driver.switchTo().alert();
		String Alert_text=act.getText();
		act.accept();
		if(Alert_text.contains(opt))
		{
			System.out.println("the option selected is present in the alert text");
		}
		else
		{
			System.out.println("the option selected is not present in the alert text");
		}
		driver.close();
	}
}