package Testngconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Commons.CommonFunctions;

public class FirstTestNg extends Annatotate
{

	WebDriver driver;
	@Test
	public void launch()
	{
		try
		{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		String scrnpath=CommonFunctions.takescreenshot(driver);
		test.log(LogStatus.PASS, "After suite executed sucessfully",test.addScreenCapture(scrnpath));
		
		}
		catch(Exception e)
		{
			String scrnpath=CommonFunctions.takescreenshot(driver);
			test.log(LogStatus.FAIL,e.toString(),test.addScreenCapture(scrnpath));
			
			
		}
	}
	
	@Test
	public void validcredentials()
	{
		ExtentTest test1=report.startTest(FirstTestNg.class.getName());
		driver.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("kumar.sathish189@gmail.com");
		String scrnpath=CommonFunctions.takescreenshot(driver);
		test1.log(LogStatus.PASS, "After suite executed sucessfully",test.addScreenCapture(scrnpath));
		
	}
}
