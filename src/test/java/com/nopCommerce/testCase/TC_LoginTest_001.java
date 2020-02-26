package com.nopCommerce.testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals(actPageTitle))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	
		
		
	}
	
	
}
