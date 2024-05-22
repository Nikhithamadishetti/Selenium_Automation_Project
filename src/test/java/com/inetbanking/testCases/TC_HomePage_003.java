package com.inetbanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_HomePage_003 extends BaseClass{
	
	@Test
	public void Homepage() throws InterruptedException, IOException {
		logger.info("Login Successfull");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(5000);
		
		logger.info("Addding Customer Details");
		HomePage cusdetails=new HomePage(driver);
		cusdetails.ClickAddNewCustomer();

		Thread.sleep(5000);
		cusdetails.custname("abcdef");
		cusdetails.Gender();
		cusdetails.dob("30", "08", "2000");
		cusdetails.Address("xyz");
		cusdetails.city("klm");
		cusdetails.cstate("mno");
		cusdetails.cpin("1234567");
		cusdetails.mobno("9652301355");
		String email=randomMail()+"@gmail.com";
		cusdetails.cmail(email);
		cusdetails.cpwd("nikikrish");
		Thread.sleep(10000);
		cusdetails.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean header=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(header==true) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"Homepage");
			Assert.assertTrue(false);
		}
	}
	
}
