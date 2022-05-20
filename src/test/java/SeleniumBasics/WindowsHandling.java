package SeleniumBasics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowsHandling {
	
	public void winhan()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		String parentwindow=driver.getWindowHandle();
		WebElement but = driver.findElement(By.id("home"));
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('home').click();");
		//js.executeScript("arguments[0].click();",but);
		but.click();
		
		Set<String> allwindow = driver.getWindowHandles();
		
		for (String childwindow : allwindow)
		{
			driver.switchTo().window(childwindow);
			
			//String chlwindow=driver.getWindowHandle();
			if(!parentwindow.equals(childwindow))
			{
				driver.manage().window().maximize();
				List<WebElement> Ebutton = driver.findElements(By.xpath
						("//h5[text()='Edit']"));
				int listsize=Ebutton.size();
				if(listsize>0)
				{
					driver.findElement(By.xpath("//h5[text()='Edit']")).click();
					
					
					driver.findElement(By.id("email")).
					sendKeys("kumar.sathish189@gmail.com");
					
					
					driver.switchTo().window(parentwindow);
					//driver.close();
					
					//driver.quit();
					
				}
				else
				{
					driver.switchTo().window(parentwindow);
				}
			}
		}
		
	}
	
	public void winhanmultiple()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
		String parentwindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> allwindow = driver.getWindowHandles();
		
		for (String childwindow : allwindow)
		{
			driver.switchTo().window(childwindow);
			
			//String chlwindow=driver.getWindowHandle();
			if(!parentwindow.equals(childwindow))
			{
				
				List<WebElement> Ebutton = driver.findElements(By.linkText(
						"Verify am I broken?"));
				int listsize=Ebutton.size();
				/*List<WebElement> childEbutton = driver.findElements(By.xpath(
						"//button[text()='Go to Home Page']"));
				int childlistsize=childEbutton.size();*/
				
				if(listsize>0)
				{
					driver.manage().window().maximize();
					driver.findElement(By.linkText("Verify am I broken?"))
					.click();
					String pagettitle=driver.getTitle();
					System.out.println(pagettitle);
					/*driver.findElement(By.xpath("//h5[text()='Edit']")).click();
					
					
					driver.findElement(By.id("email")).
					sendKeys("kumar.sathish189@gmail.com");*/
					
					//break;
					//driver.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
					
					//driver.quit();
					//driver.switchTo().window(parentwindow);
					
				}
			/*	else if(childlistsize>0)
				{
					driver.findElement(By.xpath("//button[text()='Go to Home Page']"))
					.click();
					driver.findElement(By.xpath("//h5[text()='Edit']")).click();
					
					
					driver.findElement(By.xpath("(//div[@class='row']//child::input)[2]"))
					.sendKeys("kumar.sathish189@gmail.com");
					
				
					
				}*/
				else
				{
					driver.switchTo().window(parentwindow);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowsHandling wh = new WindowsHandling();
		wh.winhanmultiple();
	}

}
