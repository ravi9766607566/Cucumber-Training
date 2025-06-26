package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement txt_username;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_login;
	
	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement btn_mendausers;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement btn_logout;
	
	public void setUsername(String uname)
	{
		txt_username.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickondrop()
	{
		btn_mendausers.click();
	}
	
	public void clickonlogout()
	{
		btn_logout.click();
	}
	
	public void clickonlogin()
	{
		btn_login.click();
	}
}
