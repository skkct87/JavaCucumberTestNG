package Listener;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import config.TestRunner;
import io.qameta.allure.Allure;


public class ListenerTest extends TestRunner implements ITestListener {
	


	@Override
	public void onFinish(ITestContext Result) {
		Reporter.log("Test Process Finished ");
		System.out.println("Test Process Finished ");
	}

	@Override
	public void onStart(ITestContext Result) {
		Reporter.log("Test Process Starting ");
		System.out.println("Test Process Starting ");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	@Override
	public void onTestFailure(ITestResult Result) {
		Reporter.log("Test Case Failed");
		System.out.println("Test Case Failed");
		Allure.addAttachment("Failed Screenshot",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//		getScreenshot();

	}

	@Override
	public void onTestSkipped(ITestResult Result) {
				}

	@Override
	public void onTestStart(ITestResult Result) {
		Reporter.log(Result.getName() + " Test Case Excution Started");
			System.out.println("Test Case Excution Started");
		

	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		Reporter.log("Test Passed");
		System.out.println("Test Passed");

	}
}
