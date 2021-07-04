package test;

import org.apache.poi.ss.usermodel.Header;
import org.testng.annotations.Test;

import page.ProductItemPage;
import page.SwagLoginPage;
import page.VerifyCartItem;

public class ProductTest extends BaseClass{
	
	@Test
	public void logintestcase()
	{
		SwagLoginPage login=new SwagLoginPage();
		ProductItemPage cartitem=new ProductItemPage();
		VerifyCartItem veifyitem=new VerifyCartItem();
		
		Header shhethead=sheet.getHeader();
		String h1=shhethead.getCenter();
		System.out.println(h1);
		
		String un=sheet.getRow(1).getCell(0).getStringCellValue();
		String pwd=sheet.getRow(1).getCell(1).getStringCellValue();
		String product=sheet.getRow(1).getCell(2).getStringCellValue();
		login.Login(un, pwd);
		cartitem.Prodcutselect(product);
		veifyitem.CartItemCheck(product);
		
	}

}
