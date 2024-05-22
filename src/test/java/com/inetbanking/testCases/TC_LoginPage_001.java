package com.inetbanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(1000);
		lp.setUserName(username);
		Thread.sleep(2000);
		lp.setPassword(password);
		Thread.sleep(2000);
		lp.clickSubmit();
		Thread.sleep(2000);
		String str=driver.getTitle();
		if(str.equalsIgnoreCase("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
