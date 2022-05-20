package SeleniumBasics;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerificationandValidation 
{

	public void verfi()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		//Verification command:
		
		String title=driver.getTitle();
		System.out.println("the title of the web page is  : "+ title);
		String url=driver.getCurrentUrl();
		System.out.println("the URL of the web page is  : "+ url);
		
		String hrefatt=driver.findElement(By.name("firstname")).getAttribute("class");
		System.out.println("the class of the web page is  : "+ hrefatt);
		
		String textvalue=driver.findElement(By.name("websubmit")).getText();
		System.out.println("the textvalue of the web page is  : "+ textvalue);
		
		String currentwindowname=driver.getWindowHandle();
		System.out.println("the windowname of the web page is  : "+ currentwindowname);
		
		Set<String> cmultiwindowname=driver.getWindowHandles();
		System.out.println("the Multi windowname of the web page is  : "+ cmultiwindowname);
		
		//Validation
		Boolean gender=driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).isSelected();
		System.out.println("the first gender selection of the web page is  : "+ gender);
		if(gender==false)
		{
		
		driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).click();
		}
		else
		{
			System.out.println("Already selected");
		}
		
		Boolean gender2=driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).isSelected();
		System.out.println("the Second gender selection of the web page is  : "+ gender2);
		
		Boolean enabled=driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).isEnabled();
		System.out.println("the enabled selection of the web page is  : "+ enabled);
		
		Boolean display=driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).isDisplayed();
		System.out.println("the display selection of the web page is  : "+ display);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationandValidation v= new VerificationandValidation();
		v.verfi();
	}

}
