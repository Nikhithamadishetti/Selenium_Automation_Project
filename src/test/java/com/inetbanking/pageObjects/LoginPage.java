package com.inetbanking.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	   WebDriver ldriver;
       
	   //Constructor
       public LoginPage(WebDriver ldriver)
       {
        	 this.ldriver=ldriver;//using this keyword to avoid confusion btw local variables and global variables
        	 PageFactory.initElements(ldriver,this);
       }
       
//       @FindBy(name="uid")
//	   WebElement txtUsername;
       
       @FindBy(how=How.NAME ,using="uid")
        WebElement txtUsername;
       
       @FindBy(name="password")
       WebElement txtpwd;
       
       @FindBy(name="btnLogin")
       WebElement btnLogin;
       
       @FindBy(xpath="//*[text()='Log out']")
       WebElement Logout;

       public  void setUserName(String uname)
       {
    	   txtUsername.sendKeys(uname);
       }
       
       public void setPassword(String pwd)
       {
    	   txtpwd.sendKeys(pwd);
       }
       
       public void clickSubmit()
       {
    	   btnLogin.click();
       }
       
       public void Logout()
       {
    	   Logout.click();
       }
}
