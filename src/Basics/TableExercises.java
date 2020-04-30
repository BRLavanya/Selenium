package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableExercises {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\BRLAVAN\\\\Desktop\\\\Data_backup\\\\DL\\\\Personal\\\\Selenium\\\\Jars\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/27378/ms-vs-psz-27th-match-pakistan-super-league-2020");
		List<WebElement> Runs_count=driver.findElements(By.xpath("//span[contains(text(),'Multan Sultans Innings')]//parent::div//following-sibling::div[contains(@class,'cb-col cb-col-100 cb-scrd-itms')]//div[contains(@class,'cb-col cb-col-8 text-right text-bold')]"));
		int totalruns=0;
		System.out.println("runs are :");
		for(int i =0;i<Runs_count.size();i++)
		{
			String totalrun=Runs_count.get(i).getText();
			totalruns=Integer.parseInt(totalrun)+totalruns;
			System.out.println(totalrun);
		}
		String Extras= driver.findElement(By.xpath("//span[contains(text(),'Multan Sultans Innings')]//parent::div//following-sibling::div[contains(@class,'cb-col cb-col-100 cb-scrd-itms')]//div[contains(@class,'cb-col cb-col-60') and (text()='Extras')]//following-sibling::div[contains(@class,'cb-col cb-col-8 text-bold cb-text-black text-right')]")).getText();
		totalruns=Integer.parseInt(Extras)+totalruns;
		System.out.println("totalruns is " +totalruns);
		String total=driver.findElement(By.xpath("//span[contains(text(),'Multan Sultans Innings')]//parent::div//following-sibling::div[contains(@class,'cb-col cb-col-100 cb-scrd-itms')]//div[contains(@class,'cb-col cb-col-60') and (text()='Total')]//following-sibling::div[contains(@class,'cb-col cb-col-8 text-bold text-black text-right')]")).getText();
		int Actual_run=Integer.parseInt(total);
		if(totalruns==Actual_run)
		{
			System.out.println("Count matches");
		}
		else
		{
			System.out.println("Count does not matches");
		}
		driver.close();
	}
}
