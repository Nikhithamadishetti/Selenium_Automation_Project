package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
   WebDriver ldriver;
       
	   //Constructor
       public HomePage(WebDriver ldriver)
       {
        	 this.ldriver=ldriver;//using this keyword to avoid confusion btw local variables and global variables
        	 PageFactory.initElements(ldriver,this);
       }
       
//       @FindBy(how=How.XPATH,using="//a[@href='addcustomerpage.php']")
//       WebElement ClickonCustomerTab;
//       
       @FindBy(xpath="//a[@href='addcustomerpage.php']")
       WebElement ClickonCustomerTab;
       
       @FindBy(how=How.NAME,using="name")
       WebElement CustomerName;
       
       @FindBy(how=How.XPATH, using="//*[contains(@class,'layout')]//tr//td//input[2]")
       WebElement Gender;
       
       @FindBy(how=How.ID_OR_NAME, using="dob")
       WebElement txtdob;
       
       @FindBy(how=How.NAME, using="addr")
       WebElement Address;
       
       @FindBy(how=How.NAME,using="city")
       WebElement City;
       
       @FindBy(how=How.NAME, using="state")
       WebElement State;
       
       @FindBy(how=How.NAME,using="pinno")
       WebElement pinno;
       
       @FindBy(how=How.NAME,using="telephoneno")
       WebElement MobileNo;
       
       @FindBy(how=How.NAME,using="emailid")
       WebElement EmailID;
       
       @FindBy(how=How.NAME,using="password")
       WebElement password;
       
       @FindBy(how=How.NAME, using="sub")
       WebElement Submit;
       
       //For all above elements need to write Action methods
       
       public void ClickAddNewCustomer()
       {
    	   ClickonCustomerTab.click();
       }
       
       public void custname(String cname) 
       {
    	   CustomerName.sendKeys(cname);
       }
    	
       public void Gender() {
//    	 String str=Gender.getText();
//    	 if(gender.equals(str))
//    	 {
//     	 System.out.println(str);
    	 Gender.click();
    	// }
       }
       
       public void dob(String mm,String dd,String yy) {
    	   txtdob.sendKeys(mm);
    	   txtdob.sendKeys(dd);
    	   txtdob.sendKeys(yy);
       }
       
       public void Address(String caddress)
       {
    	   Address.sendKeys(caddress);
       }
       
       public void city(String ccity)
       {
    	   City.sendKeys(ccity);
       }
       
       public void cstate(String cstate)
       {
    	   State.sendKeys(cstate);
       }
       
       public void cpin(String cuspin) {
    	   pinno.sendKeys(String.valueOf(cuspin));
       }
       
       public void mobno(String cmob) {
    	   MobileNo.sendKeys(cmob);
       }
       
       public void cmail(String cmail) {
    	   EmailID.sendKeys(cmail);
       }
    	   
       public void cpwd(String cuspwd){
       password.sendKeys(cuspwd); 
       }
       
       public void clickSubmit() {
       Submit.click();
       }
}
