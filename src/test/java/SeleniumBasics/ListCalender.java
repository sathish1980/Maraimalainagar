package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ListCalender {
	
	public void fromlist(int date)
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--disable-notifications");
		c.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(c);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'fsw_inner')]//child::input)[1]")));
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//click the field to see the list
		//driver.findElement(By.xpath("//li[@data-cy='account']")).click();
		//WebDriverWait wait = new WebDriverWait(driver,60);
		int inputdate =date;
		String elementidentified = "not done";
		//driver.findElement(By.xpath("//div[@class='fsw ']//label[@for='departure']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath
				("//label[@for='departure']//parent::div")));
		
		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		//waitelementtobeclickable(driver,By.xpath("//label[@for='departure']//parent::div"));
		WebElement tofield=driver.findElement(By.xpath
				("//label[@for='departure']//parent::div"));
		tofield.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
				("(//div[@class='DayPicker-Month'])[1]//div[@class='DayPicker-Week']")));
		
		List<WebElement> Totalweeks = driver.findElements(By.xpath
				("(//div[@class='DayPicker-Month'])[1]//div[@class='DayPicker-Week']"));
		int totalweeks =Totalweeks.size();
				for(int i=1;i<=totalweeks;i++)
				{
					List<WebElement> Totaldays =driver.findElements(By.xpath(""
							+ "(//div[@class='DayPicker-Month'])[1]//child::div"
							+ "[@class='DayPicker-Week']["+i+"]//child::div[contains"
									+ "(@class,'DayPicker-Day')]"));
					int Totaldaysize =Totaldays.size();
					for (int j=1;j<Totaldaysize;j++)
					{
					String classattribute=	driver.findElement(By.xpath("(//div"
							+ "[@class='DayPicker-Month'])[1]//child::div"
							+ "[@class='DayPicker-Week']["+i+"]//child::div[contains"
									+ "(@class,'DayPicker-Day')]["+j+"]")).getAttribute
							("class");
						if (classattribute.contains("disabled"))
						{
							
						}
						else
						{
							String actaultext=driver.findElement(By.xpath(
									"(//div[@class='DayPicker-Month'])[1]//child::div"
									+ "[@class='DayPicker-Week']["+i+"]//child::div"
											+ "[contains(@class,'DayPicker-Day')]["+j+"]"
													+ "//p")).getText();
							if(Integer.parseInt(actaultext)==inputdate)
							{
								driver.findElement(By.xpath("(//div[@class="
										+ "'DayPicker-Month'])[1]//child::div"
										+ "[@class='DayPicker-Week']["+i+"]//child::div"
												+ "[contains(@class,'DayPicker-Day')]"
												+ "["+j+"]")).click();
								elementidentified= "done";
								break;
							}
							
						}
					}
					if(elementidentified=="done")
					{
						break;
					}
				}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListCalender l = new ListCalender();
		l.fromlist(19);
	}

}
