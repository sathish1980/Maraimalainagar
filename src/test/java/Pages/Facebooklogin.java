package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.CommonFunctions;

public class Facebooklogin extends CommonFunctions
{
	@FindBy(id="email")
	WebElement usernm;
	@FindBy(id="pass")
	WebElement pswrd;
	@FindBy(name="login")
	WebElement loginbutn;
	WebDriver driver;
	public Facebooklogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void username(String un)
	{
		//WebElement uname=driver.findElement(By.id("email"));
		textBox(usernm,un);
	}
	
	public void password(String pw)
	{
		//WebElement passwrd=driver.findElement(By.id("pass"));
		textBox(pswrd,pw);
	}
	
	public void loginbutton()
	{
		//WebElement passwrd=driver.findElement(By.name("login"));
		Buttonclick(loginbutn);
	}
}
