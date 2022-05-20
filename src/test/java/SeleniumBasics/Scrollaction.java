package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollaction {

	public void scroll()
	{
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,750)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-750)", "");
		
	//	js.executeScript("window.scrollBy(0,750)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//vertical scroll right
		js.executeScript("window.scrollBy(750,0)", "");
		try {
				Thread.sleep(2000);
			} 
		catch (InterruptedException e)
		{
					// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//vertical scroll left
		js.executeScript("window.scrollBy(-750,0)", "");
		
		// scrollintospecificelement
		WebElement Element = driver.findElement(By.xpath
		("//h5[text()='Window']//parent::a"));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
	
        
        //scroll at the bottom
      //  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        
        try {
			Thread.sleep(2000);
		} 
	catch (InterruptedException e)
	{
				// TODO Auto-generated catch block
		e.printStackTrace();
	}
      //scroll at the top
      // js.executeScript("window.scrollTo(0,-0)");
        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scrollaction sc= new Scrollaction();
		sc.scroll();
	}

}
