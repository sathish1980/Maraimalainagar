package SeleniumBasics;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {
	WebDriver driver;
	
	public void singleselectdropdown()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		//create account button click
		driver.findElement(By.xpath("(//div[@class='_6ltg']//child::a)")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement
				(By.xpath("(//div[@class='_6ltg']//child::a)"))));
		wait.until(ExpectedConditions.presenceOfElementLocated((By.name("firstname"))));
		
		driver.findElement(By.name("firstname")).sendKeys("9159211184");
		
		WebElement dyadrop= driver.findElement(By.xpath("//select[@id='day']"));
		Select dayd=new Select(dyadrop);
		dayd.selectByIndex(10);
		WebElement mondrop= driver.findElement(By.xpath("//select[@id='month']"));
		Select mon=new Select(mondrop);
		mon.selectByValue("7");
		WebElement yrdrop= driver.findElement(By.xpath("//select[@id='year']"));
		Select yr=new Select(yrdrop);
		yr.selectByVisibleText("2010");
	}
	
	public void singledropinleaf()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		WebElement firstdorpdown= driver.findElement(By.id("dropdown1"));
		Select s= new Select(firstdorpdown);
		s.selectByIndex(2);
		WebElement seconddorpdown= driver.findElement(By.name("dropdown2"));
		Select s1= new Select(seconddorpdown);
		s1.selectByValue("3");
		WebElement Thirddorpdown= driver.findElement(By.name("dropdown3"));
		Select s2= new Select(Thirddorpdown);
		s2.selectByVisibleText("Loadrunner");
	}

	public void dropdownmultiselect()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		WebElement multislect=driver.findElement(By.xpath(""
				+ "(//div[@class='example']//child::select)[6]"));
		Select s=new Select(multislect);
		Boolean value=s.isMultiple();
		System.out.println(value);
		if(value==true)
		{
			//Select s1=new Select(driver.findElement(By.xpath("(//div[@class='example']//child::select)[6]")));
			//List<WebElement> l = s1.getOptions();
			s.selectByIndex(1);
			s.selectByValue("2");
			s.selectByValue("3");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//s.deselectByIndex(1);
			s.deselectAll();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dropdown d= new Dropdown();
		//d.singleselectdropdown();
		d.dropdownmultiselect();
	}

}
