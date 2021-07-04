package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.BaseClass;

public class VerifyCartItem {
	WebDriver driver;
	ExtentReports report;
    ExtentTest test;
    //==============WebElement==========//
    @FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement item;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	WebElement itemname;
	
	
	//===============Constructor===========//
	
	public  VerifyCartItem()
	{
		driver=BaseClass.driver;
		report=BaseClass.report;
		test=BaseClass.test;
		
		PageFactory.initElements(this.driver, this);
	}
	
	public void CartItemCheck(String product)
	
	{
       test=report.startTest("Verifying added cart item");
       item.click();
       test.log(LogStatus.PASS, "Clicked on shopping cart link successfully");
       String ActualItem=itemname.getText();
       if(product.equalsIgnoreCase(ActualItem))
       {
    	   test.log(LogStatus.PASS, "Added cart item matches with actual item");
       }
       else
       test.log(LogStatus.FAIL, "cart item doesnot matches with actual item");
	}
}
