
package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
   @Test(dataProvider="LoginData")
   public void LoginDDT(String user,String pwd) throws InterruptedException 
   {
	   LoginPage lp=new LoginPage(driver);
	   lp.setUserName(user);
	   lp.setPassword(pwd);
	   lp.clickSubmit();
	   Thread.sleep(3000);
	   //for closing alert
	   if(isAlertPresent()==true)
	   {
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("login failed");
	   }
		else {
			Assert.assertTrue(true);
			lp.Logout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			logger.info("logger Passed");
		}
    }
   
   //userdefindedmethod for checking alert is present or not so should keep any Annotation -> can be resued so can keep it in Baseclass
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}
   
   
   @DataProvider(name="LoginData")
   String[][] getData() throws IOException
   {
	   String path=System.getProperty("user.dir")+ "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
	 //  String path1="C:\\Users\\nmadishetti\\git\\InectBanking\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
	   System.out.print(path);
	   int rownum=XLUtils.getRowCount(path,"Sheet1");
	   int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	   String loginData[][]= new String[rownum][colcount];
	   
	   
	   for(int i=1;i<=rownum;i++)
	   {
		   for(int j=0;j<colcount;j++)
		   {
			 loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
		   }
	   }
	   return loginData;
   }
}
