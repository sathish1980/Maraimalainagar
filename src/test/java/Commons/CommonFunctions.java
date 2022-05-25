package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//Testcase_1_"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
	
	public void textBox(WebElement inputbox,String textToBeEnter)
	{
		inputbox.clear();
		inputbox.sendKeys(textToBeEnter);
	}

	public void Buttonclick(WebElement inputbox)
	{
		if(inputbox.isEnabled())
		{
		inputbox.click();
		}
	}
	
	public void Waitelementtobeclickable(WebDriver driver,WebElement elementtobeClickable)
	{
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(60));
		wb.until(ExpectedConditions.elementToBeClickable(elementtobeClickable));
		
	}
	public void Waitelementtobevisible(WebDriver driver,By elementtobeClickable)
	{
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(60));
		wb.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementtobeClickable));
		
	}

}
