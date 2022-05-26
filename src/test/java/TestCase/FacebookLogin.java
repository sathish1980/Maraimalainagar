package TestCase;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Commons.CommonFunctions;
import Datadriven.datadrivenimplementation;
import Drivers.BrowserDriver;
import ReportUtils.ExtentReport;
import Utils.ExcelRead;
import Utils.PropertyfileRead;

public class FacebookLogin extends BrowserDriver
{
	PropertyfileRead p= new PropertyfileRead();
	CommonFunctions c= new CommonFunctions();
	private String scrnpath;
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
	@BeforeClass
	public void Extentreportlaunch()
	{
		ExtentReport.reportlaunch();
		//ExtentReport.Extentstarttest("Testcase");
	}
	@BeforeMethod
	public void Reportstart(Method method)
	{
		ExtentReport.Extentstarttest(method.getName());
	}
	
	@Test(priority=0,dataProvider="facebooklogin",dataProviderClass=datadrivenimplementation.class)
	public void login(String uname,String pwd)
	{
		
		driver.findElement(By.id("email")).sendKeys(uname);
		ExtentReport.Extentinfo("User name entered: "+uname);
		driver.findElement(By.id("pass")).sendKeys(pwd);
		ExtentReport.Extentinfo("password entered: "+pwd);
		driver.findElement(By.name("login")).click();
		ExtentReport.Extentinfo("login clicked");
		String actualTitle=driver.getTitle();
		scrnpath=CommonFunctions.takescreenshot(driver);
		c.Waitelementtobeclickable(driver,driver.findElement(By.xpath("//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']")));
		Assert.assertTrue(actualTitle.contains("Facebook"));
		logout();
	}
	
	@Test(priority=2)
	public void loginwithinvalidemailid()
	{
		
		driver.findElement(By.id("email")).sendKeys("kumar.sathish189@gmailcom");
		ExtentReport.Extentinfo("User name entered");
		driver.findElement(By.id("pass")).sendKeys("Admin@123");
		ExtentReport.Extentinfo("User name entered");
		driver.findElement(By.name("login")).click();
		ExtentReport.Extentinfo("login clicked");
		String actualTitle=driver.getTitle();
		scrnpath=CommonFunctions.takescreenshot(driver);
		//c.Waitelementtobeclickable(driver,driver.findElement(By.xpath("//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']")));
		Assert.assertTrue(actualTitle.contains("Facebook - login or sign up"));
		//logout();
	}
	
	public void logout()
	{
		c.Waitelementtobeclickable(driver,driver.findElement(By.xpath("//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']")));
		WebElement logoutbutton=driver.findElement(By.xpath("//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']"));
		c.Buttonclick(logoutbutton);
		c.Waitelementtobevisible(driver,By.xpath("//span[text()='Log Out']"));
		WebElement logoutbuttondropdown=driver.findElement(By.xpath("//span[text()='Log Out']"));
		c.Buttonclick(logoutbuttondropdown);
	}
	
	@Test(priority=1)
	public void loginwithnocrenyials()
	{
		
		driver.findElement(By.id("email")).sendKeys("");
		ExtentReport.Extentinfo("User name entered");
		driver.findElement(By.id("pass")).sendKeys("");
		ExtentReport.Extentinfo("password entered");
		driver.findElement(By.name("login")).click();
		ExtentReport.Extentinfo("login clicked");

		scrnpath=CommonFunctions.takescreenshot(driver);
		c.Waitelementtobeclickable(driver,driver.findElement(By.name("login")));
		String actualTitle=driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Log in to Facebook"));
	}
	
	@AfterMethod
	public void reportupdate(ITestResult result)
	{
		System.out.println("Status of execution is:"+result.getStatus());
	      try{
	         if(result.getStatus() == ITestResult.SUCCESS){
	        	 ExtentReport.Extentpass(scrnpath);
	        	 }
	         else if(result.getStatus() == ITestResult.FAILURE){
	            // Do something here
	        	 ExtentReport.Extentfail(scrnpath);
	        	 }
	         else if(result.getStatus() == ITestResult.SKIP ){
	        	 ExtentReport.Extentskip();
	        	 }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	}
	
	@AfterSuite
	public void teardown() 
	{
		if(driver!=null)
		{
		driver.quit();
		ExtentReport.reportflush();
		}
	}
}
