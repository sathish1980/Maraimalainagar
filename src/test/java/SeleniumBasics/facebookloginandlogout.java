package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookloginandlogout {
	WebDriver driver;
	
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
	
	public void fblogin()
	{
		WebElement username =	driver.findElement(By.id("email"));
		username.sendKeys("kumar.sathish189@gmail.com");
		WebElement password=	driver.findElement(By.name("pass"));
		password.sendKeys("Admin@123");
		WebElement login=	driver.findElement(By.name("login"));
		login.click();
	}
	
	public void logout()
	{
		WebElement logoutdropdown = driver.findElement(By.xpath("//div[@aria-label='Account']"));
		logoutdropdown.click();
	}
	
	public void create()
	{
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebDriverWait wb = new WebDriverWait(driver,60);
		//wb.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
		driver.findElement(By.name("firstname")).sendKeys("sathish");
		//wb.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname")));
		driver.findElement(By.name("lastname")).sendKeys("kumar");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		facebookloginandlogout  f= new facebookloginandlogout();
		f.launch();
		f.create();
	}

}
