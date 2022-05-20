package SeleniumBasics;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listexample {
	
	WebDriver driver;
	WebDriverWait wait;
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		c.addArguments("--incognito");
		driver = new ChromeDriver(c);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//popup close
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'fsw_inner')]//child::input)[1]")));
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		//click the field to see the list
	}
	public void list(String comparetext,String Fieldname)
	{
		
		if (Fieldname.equalsIgnoreCase("From"))
		{
		WebElement fromfield=driver.findElement(By.xpath("(//div[contains(@class,'fsw_inner')]//child::input)[1]"));
		fromfield.click();
		}
		//div[@class='react-autosuggest__section-container']//child::ul[@class='react-autosuggest__suggestions-list']
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//ul[@role='listbox']//li[1]//div[2]")));
		List<WebElement> fromlist=driver.findElements(By.xpath
				("//div[@id='react-autowhatever-1']//ul//li"));
		int size=fromlist.size();
		for(int i=1;i<=size;i++)
		{
			//ul[@role='listbox'])[2]//li[5]//div[contains(@class,'pushRight')]
			WebElement eachvalue=driver.findElement(By.xpath
					("//div[@id='react-autowhatever-1']//ul//li["+i+"]//div[contains(@class,'pushRight')]"));
			String eachtextvalue=eachvalue.getText();
			if(eachtextvalue.equalsIgnoreCase(comparetext))
			{
				wait.until(ExpectedConditions.elementToBeClickable(eachvalue));
				//WebElement tobeclickable=driver.findElement(By.xpath("//div[@id='react-autowhatever-1']//ul//li["+i+"])"));
				eachvalue.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listexample ls = new Listexample();
		ls.launch();
		ls.list("NYC","From");
		ls.list("MAA","To");
	}

}
