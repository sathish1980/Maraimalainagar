package Testngconcepts;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Annatotate {
	
	public static ExtentReports report;
	public static ExtentTest test;
	String reportpath="C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumMaraimalainagar\\Reports\\";
	
	public void reportlaunch()
	{
		report= new ExtentReports(reportpath+"extentreport.html",true);
		test=report.startTest("Automation report");
		
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("After Suite");
		test.log(LogStatus.FAIL, "After suite executed sucessfully");
		reportflush();
	}

	@BeforeTest
	public void beforetest()
	{
		reportlaunch();
		System.out.println("Before Test");
		test.log(LogStatus.PASS, "Before Test executed sucessfully");
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("After test");
		test.log(LogStatus.PASS, "After Test executed sucessfully");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before class");
		test.log(LogStatus.PASS, "Before Class executed sucessfully");
	}
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After Class");
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After method");
	}
	
	@Test(priority=1,alwaysRun=true,groups="sanity")
	public void Testcase1()
	{
		int[] a = {1,2,3};
		try
		{
		System.out.println("Testcase1");
		int d=a[4];
		test.log(LogStatus.PASS, "Testcase executed sucessfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, e);
			
		}
	}
	@Test(priority=2,alwaysRun=true,groups="sanity")
	public void Testcase3()
	{
		System.out.println("Testcase3");
		test.log(LogStatus.PASS, "Testcase executed sucessfully");
	}

	@Test(priority=0,alwaysRun=false,groups="SIT")
	public void Testcase2()
	{
		System.out.println("Testcase2");
		test.log(LogStatus.PASS, "Testcase executed sucessfully");
	}
	
	public void reportflush()
	{
		report.flush();
	}
	
}
