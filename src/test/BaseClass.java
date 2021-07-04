package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	XSSFSheet sheet;
	XSSFWorkbook wb;
	@BeforeTest
	public void setup() throws IOException
	{
		System.getProperty("webdriver.driver.chromedriver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		report=new ExtentReports("Report.html");
		FileInputStream file=new FileInputStream("exceldata.xlsx");
		wb=new XSSFWorkbook(file);
		sheet=wb.getSheet("data");
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		report.flush();
	}


}
