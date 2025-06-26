package stepdefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class StepDef 
{
	public WebDriver driver;
	public LoginPage loginPage;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		driver=new ChromeDriver();
		loginPage=new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String password) throws InterruptedException {
		Thread.sleep(2000);
		loginPage.setUsername(uname);
		loginPage.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		loginPage.clickonlogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expected) {
		String actual=driver.getTitle();
		Assert.assertEquals(expected, actual);
	}

	@When("User click on mendauser link")
	public void user_click_on_mendauser_link() throws InterruptedException {
		Thread.sleep(2000);
		loginPage.clickondrop();
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPage.clickonlogout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}
	
	@After
	public void tearDown(Scenario sc)
	{
		System.out.println("Tear down method executed");
		
		if(sc.isFailed()==true)
		{
			String filewithpath="D:\\Study Materials_Ravi\\UC Uncodmy Class_Ravi\\Automation Class\\Eclipse Projects\\Cucumber_Training02\\screenshots\\failed.png";
			TakesScreenshot scrshot=(TakesScreenshot)driver;
			File srcFile=scrshot.getScreenshotAs(OutputType.FILE);
			File destFile=new File(filewithpath);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
