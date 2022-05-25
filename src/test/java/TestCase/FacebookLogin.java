package TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Drivers.BrowserDriver;
import Utils.PropertyfileRead;

public class FacebookLogin extends BrowserDriver
{
	PropertyfileRead p= new PropertyfileRead();
	@BeforeSuite
	public void browserintiate() 
	{
		
		String actualBrowser=p.propreaddata().getProperty("browser");
		launchBrowser(actualBrowser);	
	}
	
	@BeforeTest
	public void LaunchURL()
	{
		driver.manage().window().maximize();
		String actualurl=p.propreaddata().getProperty("url");
		driver.get(actualurl);
	}
	
	@Test(priority=0)
	public void login()
	{
		driver.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Admin@123");
		driver.findElement(By.name("login")).click();
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "Facebook");
		
	}
	
	@AfterSuite
	public void teardown() 
	{
		if(driver!=null)
		{
		driver.quit();
		}
	}

}
