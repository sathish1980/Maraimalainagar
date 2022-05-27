package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.CommonFunctions;

public class Facebooklogout extends CommonFunctions
{
	@FindBy(xpath="//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']")
	WebElement logdropicon;
	@FindBy(xpath="//span[text()='Log Out']")
	WebElement logoutbutton;

	WebDriver driver;
	
	public Facebooklogout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void logouticon() 
	{
		Waitelementtobeclickable(driver,logdropicon);
		//WebElement logoutbutton=driver.findElement(By.xpath("//div[@role='navigation']//div[@aria-label='Your profile']//*[name()='svg']"));
		Buttonclick(logdropicon);	
	}
	
	public void logoutfromList() 
	{
		Waitelementtobevisible(driver,By.xpath("//span[text()='Log Out']"));
		//WebElement logoutbuttondropdown=driver.findElement(By.xpath("//span[text()='Log Out']"));
		Buttonclick(logoutbutton);	
	}
}
