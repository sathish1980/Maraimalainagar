package SeleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class uploadanddownload
{

	public void upload()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cleartax.in/paytax/UploadForm16");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	    driver.findElement(By.xpath("(//div[@class='hidden-xs']//div)[1]")).click();
	    ////form[@id='uploadForm']//div[contains(@class,'dropzone')]
	    //String path="";
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("D:\\Besant\\BDD framework.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    try {
			Robot rb = new Robot();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    } catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void donwload()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/download.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Download Excel")).click();
	}
	
	public void downloadinspecificloc()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
	Map<String, Object> ad = new HashMap<String, Object>();
	//ad.put("download.default_directory",  System.getProperty("user.dir")+ File.separator + "OutputFile" + File.separator + "downloadFiles");
	ad.put("download.default_directory",  "D:\\Besant\\DownloadFiles\\");
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", ad);
	options.addArguments("start-maximized");
	options.addArguments("--disable-Notifications");
	options.addArguments("--incognito");
	WebDriver driver = new ChromeDriver(options);
	driver.get("http://www.leafground.com/pages/download.html");
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.linkText("Download Excel")).click();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		uploadanddownload up = new uploadanddownload();
		up.donwload();
	}

}
