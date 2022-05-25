package ReportUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport 
{
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath="C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumMaraimalainagar\\Reports\\";
	
	public static void reportlaunch()
	{
		report= new ExtentReports(reportpath+"extentreport.html",true);
		
		
	}
	
	public static void Extentstarttest(String Testname)
	{
		test=report.startTest(Testname);
	}
	
	public static void Extentpass(String scrnpath)
	{
		test.log(LogStatus.PASS, "All the steps are executed",test.addScreenCapture(scrnpath));
	}
	
	public static void Extentinfo(String info)
	{
		test.log(LogStatus.INFO, info);
	}
	
	public static void Extentfail(String scrnpath)
	{
		test.log(LogStatus.FAIL, "Test case are failed",test.addScreenCapture(scrnpath));
	}
	
	public static void Extentskip()
	{
		test.log(LogStatus.SKIP, "Test case are skipped");
	}
	
	public static void reportflush()
	{
		report.flush();
	}
}
