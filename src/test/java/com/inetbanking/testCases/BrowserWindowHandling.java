package com.inetbanking.testCases;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {

	public static void main(String args[]) throws InterruptedException
	{
	
		WebDriver driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        
        
//        String parentWindow=driver.getWindowHandle();
//        System.out.println("parentWindow ID:" +parentWindow);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Thread.sleep(2000);
        
       
        Set<String> windowIDs=driver.getWindowHandles();
        
        ////First Method-> Using iterator method 
//        Iterator<String> it=windowIDs.iterator();
//        String parentWindow=it.next();
//        String childWindow=it.next();
//        
//        
//        System.out.println("parentWindow ID:" +parentWindow);
//        System.out.println("childWindow ID:" +childWindow);
        
        ///// Second Method-> using List collection
        
        List<String> windowIDsList=new ArrayList<String>(windowIDs);  //--> converting set to list to give index values to ID's
      
//        String parentWindow=windowIDsList.get(0);
//        String childWindow=windowIDsList.get(1);
//        
//        System.out.println("parentWindow ID:" +parentWindow);
//        System.out.println("childWindow ID:" +childWindow);
//       
  //      ==========================================================================================
//        ///How to switch btn windows
//        
//        driver.switchTo().window(parentWindow);
//        System.out.println("parentWindow Title:" +driver.getTitle());
//        
//        driver.switchTo().window(childWindow);
//        System.out.println("childWindow Title:" +driver.getTitle());
        
        
        //code optimaiztion i want to use windowID's and switch to that particular window and get that window title
        
        //forEach loop
//        for(String singlewindow:windowIDs) 
//        {
//        	String title=driver.switchTo().window(singlewindow).getTitle();
//        	System.out.println(title);
//        }
//        
        // suppose u have 5 windows open u want to close particualr windows so based on title of window i close that particular window
        
        for(String singlewindow:windowIDs) 
        {
        	String title=driver.switchTo().window(singlewindow).getTitle();
        	if(title.equalsIgnoreCase("OrangeHRM") )
        			//|| title.equalsIgnoreCase("Human Resources Management Software | OrangeHRM"))
        	{
        		driver.close();
        	}
        }
       // driver.quit();
	}
}
