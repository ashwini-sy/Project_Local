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

public class ProductItemPage {
	WebDriver driver;
	ExtentReports report;
    ExtentTest test;
	
	//===============Constructor===========//
	
	public  ProductItemPage()
	{
		driver=BaseClass.driver;
		report=BaseClass.report;
		test=BaseClass.test;
		
		PageFactory.initElements(this.driver, this);
	}
	
	public void Prodcutselect(String product)
	
	{
       test=report.startTest("Page of product listed");
        WebElement cartitem=driver.findElement(By.xpath("//*[text()='"+product+"']/following::button[1]"));
        cartitem.click();
        test.log(LogStatus.PASS, "Added the  item to cart successfully");
	}
}
