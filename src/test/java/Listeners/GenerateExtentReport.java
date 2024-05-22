package Listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport implements IReporter{
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onTestStart(ITestContext testContext) throws IOException  {
		
		System.out.println("entering into GenerateExtentReport");
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println(timeStamp);
		String repName="Test-Report-"+timeStamp+".html";
		System.out.println(repName);
		
		htmlReporter=new ExtentSparkReporter("C:\\Users\\nmadishetti\\git\\InectBanking\\test-output"+repName);
		htmlReporter.loadXMLConfig("C:\\Users\\nmadishetti\\git\\InectBanking\\extent-config.xml");
	
	
	  	extent = new ExtentReports();
	  	extent.attachReporter(htmlReporter);
	  	
	  	extent.setSystemInfo("Host name","localhost");
	  	extent.setSystemInfo("Environment","QA");
	  	extent.setSystemInfo("Username","Nikhitha");
	
	  	htmlReporter.config().setDocumentTitle("InetBanking Test Project");
	  	htmlReporter.config().setReportName("Functional Test Report");
	  	//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	  	htmlReporter.config().setTheme(Theme.DARK);
	  	
	  	
	}
	  	public void onTestSuccess(ITestResult tr) 
	  	{
	  		logger=extent.createTest(tr.getName());
	  		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	  	}

	  	public void onTestFailure(ITestResult tr) throws IOException {
	  		logger=extent.createTest(tr.getName());
	  		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	  		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	  		File f=new File(screenshotPath);
	  		if(f.exists())
	  		{
	  			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	  		}
	  	}
	  	
	  	public void onTestSkipped(ITestResult tr)
	  	{
	  		logger=extent.createTest(tr.getName());
	  		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));	
	  	}
	  	
	  	@AfterTest
	  	public void endreport(ITestContext testContext) {
	  		extent.flush();
	  	}
}
