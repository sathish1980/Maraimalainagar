package Drivers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ReportUtils.ExtentReport;
import Utils.PropertyfileRead;
import io.github.bonigarcia.wdm.WebDriverManager;





public class BrowserDriver 
{
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Logger logger = LogManager.getLogger("class");  
	PropertyfileRead p= new PropertyfileRead();
	
	public void setdriver(WebDriver driver)
	{
		this.driver.set(driver);
	}
	
	public WebDriver getdriver()
	{
		return this.driver.get();
	}
	
	@Parameters("browser")
	@BeforeTest
	public void LaunchURL(@Optional String browser)
	{
		launchBrowser(browser);
	
		String actualurl=p.propreaddata().getProperty("url");
		getdriver().get(actualurl);
		ExtentReport.reportlaunch();
	}
	
	public void launchBrowser(String browseroptions)
	{
		if(browseroptions.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\DriverFiles\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver(cp);
		 
			ChromeOptions cp = new ChromeOptions();
			cp.addArguments("--disable-notifications");
		setdriver(new ChromeDriver(cp));
		getdriver().manage().window().maximize();
		}
		else if(browseroptions.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+"\\DriverFiles\\chromedriver.exe");
			//driver = new FirefoxDriver();
			
		}
		else if(browseroptions.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", 
					System.getProperty("user.dir")+"\\DriverFiles\\msedgedriver.exe");
			EdgeOptions cp = new EdgeOptions();
			cp.addArguments("--disable-notifications");
			/*driver = new EdgeDriver(cp);
			WebDriverManager.edgedriver().setup();
			//driver = new ChromeDriver(cp);
			EdgeOptions cp = new EdgeOptions();
			cp.addArguments("--disable-notifications");*/
			
			setdriver(new EdgeDriver(cp));
			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\DriverFiles\\chromedriver.exe");
			   setdriver( new HtmlUnitDriver());
		}
	}

	@AfterTest
	public void teardown() 
	{
		if(getdriver()!=null)
		{
			getdriver().quit();
			ExtentReport.reportflush();
		
		}
	}
}
