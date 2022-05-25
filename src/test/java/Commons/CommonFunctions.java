package Commons;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
