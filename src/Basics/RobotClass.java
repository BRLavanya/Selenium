package Basics;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RobotClass {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BRLAVAN\\Desktop\\Data_backup\\DL\\Personal\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		Robot r = new Robot();
		//driver.findElement(By.name("q")).sendKeys("hello");
		WebElement gmail=driver.findElement(By.xpath("//a[text()='Gmail']"));
		org.openqa.selenium.Point point = gmail.getLocation();
        System.out.println("Element's Position from left side is: "+point.getX()+" pixels.");
        System.out.println("Element's Position from top is: "+point.getY()+" pixels.");
        r.mouseMove(point.getX(), point.getY());
		r.mousePress(InputEvent.BUTTON3_DOWN_MASK);

	}
}
