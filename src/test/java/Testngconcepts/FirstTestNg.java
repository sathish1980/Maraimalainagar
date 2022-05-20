package Testngconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTestNg 
{

	WebDriver driver;
	@Test
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
		cp.addArguments("--disable-notifications");
		driver = new ChromeDriver(cp);
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
	}
}
