package Listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter{
        
	public void onTestStart(ITestResult tr)
	{
		System.out.println("TestStarted");
	}
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("TestPassed");
	}
	public void onTestFailure(ITestResult tr) {
		System.out.println("TestFailed");
	}
	public void onTestSkipped(ITestResult tr) {
		System.out.println("TestSkipped");
	}
}
