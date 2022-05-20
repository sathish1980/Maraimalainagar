package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {

	public void frames()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.findElement(By.id("Click")).click();
		//Frame can be identified by three ways
		//1. By id
		//2 By name
		//3. By index
		
		//driver.switchTo().frame(0);
		
		List<WebElement> frames= driver.findElements(By.tagName("iframe"));
		int size= frames.size();
		
		for(int i=0;i<size;i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> actualwebelement=driver.findElements(By.id("Click"));
			if(actualwebelement.size()>0)
			{
				driver.findElement(By.id("Click")).click();
				
				break;
			}
			
		}
		driver.switchTo().defaultContent();
		
	}
	
	public void frame2withid()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/frame.html");
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.findElement(By.id("Click")).click();
		//Frame can be identified by three ways
		//1. By id
		//2 By name
		//3. By index
		
		//driver.switchTo().frame(0);
		List<WebElement> frames= driver.findElements(By.tagName("iframe"));
		int size= frames.size();
		
		for(int i=0;i<size;i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> innerframe= driver.findElements(By.tagName("iframe"));
			int innerframesize = innerframe.size();
			if (innerframesize>0)
			{
				for(int j=0;j<size;j++)
				{
					driver.switchTo().frame(j);
					List<WebElement> actualwebelement=driver.findElements(By.id("Click1"));
					if(actualwebelement.size()>0)
					{
						driver.findElement(By.id("Click1")).click();
						
						driver.switchTo().defaultContent();
						break;
					}
				}

			}
			driver.switchTo().defaultContent();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frames fs = new Frames();
		fs.frame2withid();
	}

}
