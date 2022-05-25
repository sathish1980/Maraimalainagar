package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriver 
{
	public static WebDriver driver;
	
	public void launchBrowser(String browseroptions)
	{
		if(browseroptions.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\DriverFiles\\chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		}
		else if(browseroptions.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+"\\DriverFiles\\chromedriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browseroptions.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", 
					System.getProperty("user.dir")+"\\DriverFiles\\msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
	}

}
