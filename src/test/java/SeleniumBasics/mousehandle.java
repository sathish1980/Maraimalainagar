package SeleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mousehandle {

	public void ebaymouseactions()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[text()='Electronics'])[1]"))));
		WebElement elec=driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")) ;
		Actions ac= new Actions(driver);
		ac.moveToElement(elec).perform();
		ac.moveToElement(driver.findElement(By.linkText("Cameras and photos"))).click().build().perform();
	}
	
	public void testleaf()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement elec=driver.findElement(By.xpath("//a[text()='TestLeaf Courses']")) ;
		Actions ac= new Actions(driver);
		ac.moveToElement(elec).clickAndHold().release().moveToElement(driver.findElement(By.xpath("//a[text()='RPA']"))).click().build().perform();
	
	}
	
	public void testleafdraganddrop()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement elec=driver.findElement(By.id("draggable")) ;
		Actions ac= new Actions(driver);
		//ac.moveToElement(elec).clickAndHold().moveToElement(driver.findElement(By.id("droppable"))).click().build().perform();
		ac.moveToElement(elec).dragAndDrop(elec, driver.findElement(By.id("droppable"))).build().perform();
	}
	
	public void facbookassig()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		WebElement usrnamr=driver.findElement(By.id("email"));
		Actions ac= new Actions(driver);
		ac.moveToElement(usrnamr).sendKeys("sathish").doubleClick().contextClick().build().perform();
	}
	
	public void keyboardusingrobot()
	{
		try {
			Robot rs= new Robot();
			rs.keyPress(KeyEvent.VK_DOWN);
			rs.keyRelease(KeyEvent.VK_DOWN);
			rs.keyPress(KeyEvent.VK_DOWN);
			rs.keyRelease(KeyEvent.VK_DOWN);
			rs.keyPress(KeyEvent.VK_DOWN);
			rs.keyRelease(KeyEvent.VK_DOWN);
			rs.keyPress(KeyEvent.VK_ENTER);
			rs.keyRelease(KeyEvent.VK_ENTER);
			rs.keyPress(KeyEvent.VK_TAB);
			rs.keyRelease(KeyEvent.VK_TAB);
			rs.keyPress(KeyEvent.VK_CONTROL);
			rs.keyPress(KeyEvent.VK_V);
			rs.keyRelease(KeyEvent.VK_CONTROL);
			rs.keyRelease(KeyEvent.VK_V);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mousehandle mc= new mousehandle();
		mc.facbookassig();
		mc.keyboardusingrobot();
		//mc.ebaymouseactions();
		//mc.keyboardusingrobot();
		//mc.facbookassig();
		//mc.keyboardusingrobot();
		//mc.facbookassig();
		}

}
