package com.nopCommerce.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;
import com.nopCommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals(actPageTitle))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/nopCommerce/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
		 
	}
	

}
