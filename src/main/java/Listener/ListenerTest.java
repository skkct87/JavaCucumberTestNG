package Listener;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import config.TestRunner;
import io.qameta.allure.Allure;


public class ListenerTest extends TestRunner implements ITestListener {

	private static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();

	}

	@Override
	public void onFinish(ITestContext Result) {
		System.out.println("Test Process Finished ");
	}

	@Override
	public void onStart(ITestContext Result) {

		System.out.println("Test Process Starting ");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	@Override
	public void onTestFailure(ITestResult Result) {
		System.out.println("TestFailure method " + getTestMethodName(Result) + " failed");
		Allure.addAttachment("Failed Screenshot",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//		getScreenshot();

	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		{
			System.out.println("The name of the testcase Skipped is :" + getTestMethodName(Result));
		}

	}

	@Override
	public void onTestStart(ITestResult Result) {
		{
			System.out.println(Result.getName() + " test case started");
		}

	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The testcase passed is :" + getTestMethodName(Result));

	}
}
