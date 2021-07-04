package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.BaseClass;

public class SwagLoginPage {
	WebDriver driver;
	ExtentReports report;
    ExtentTest test;
	//=================WebElement============//
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement login;
	
	//===============Constructor===========//
	
	public  SwagLoginPage()
	{
		driver=BaseClass.driver;
		report=BaseClass.report;
		test=BaseClass.test;
		
		PageFactory.initElements(this.driver, this);
	}
	
	//======================Login Method===========================//
	public void Login(String un,String pwd)
	{
		test=report.startTest("Login page of Swaglab");
		username.sendKeys(un);
		test.log(LogStatus.PASS, "Entered username succesfully");
		
		password.sendKeys(pwd);
		test.log(LogStatus.PASS, "Entered Password succesfully");
		
		login.click();
		test.log(LogStatus.PASS, "Login button clicked succesfully");
	}

}
