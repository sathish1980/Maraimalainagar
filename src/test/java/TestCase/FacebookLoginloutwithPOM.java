package TestCase;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Commons.CommonFunctions;
import Datadriven.datadrivenimplementation;
import Drivers.BrowserDriver;
import Pages.Facebooklogin;
import Pages.Facebooklogout;
import ReportUtils.ExtentReport;
import Utils.PropertyfileRead;

public class FacebookLoginloutwithPOM extends BrowserDriver
{
	PropertyfileRead p= new PropertyfileRead();
	CommonFunctions c= new CommonFunctions();
	private String scrnpath;
	/////////######### Page object model ##########
	///////////////////////////////////////////////
	///////////////////////////////////////////////
	

	@Test(priority=0,dataProvider="facebooklogin",dataProviderClass=datadrivenimplementation.class)
	public void loginwithPageobjectModel(String uname,String pwd)
	{
		Facebooklogin f= new Facebooklogin(getdriver());
		f.username(uname);
		//driver.findElement(By.id("email")).sendKeys(uname);
		ExtentReport.Extentinfo("User name entered: "+uname);
		f.password(pwd);
		//driver.findElement(By.id("pass")).sendKeys(pwd);
		ExtentReport.Extentinfo("password entered: "+pwd);
		f.loginbutton();
		//driver.findElement(By.name("login")).click();
		ExtentReport.Extentinfo("login clicked");
		String actualTitle=f.getTitle();
		scrnpath=CommonFunctions.takescreenshot(getdriver());
		c.Waitelementtobeclickable(getdriver(),getdriver().findElement(By.xpath("//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']")));
		Assert.assertTrue(actualTitle.contains("Facebook"));
		Facebooklogout fl= new Facebooklogout(getdriver());
		fl.logouticon();
		ExtentReport.Extentinfo("logout icon clicked");
		fl.logoutfromList();
		ExtentReport.Extentinfo("logout completed sucessfully");
		String actualTitleafterlogout=fl.getTitle();
		Assert.assertTrue(actualTitleafterlogout.contains("Facebook"));
		
	}
	@BeforeMethod
	public void Reportstart(Method method)
	{
		ExtentReport.Extentstarttest(method.getName());
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
	
}
