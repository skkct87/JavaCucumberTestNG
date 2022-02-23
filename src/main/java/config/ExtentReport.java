package config;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	ExtentReports extent;
	ExtentTest logger;
	String projectpath = System.getProperty("user.dir");

	@BeforeTest
	public void startTest() {
		extent = new ExtentReports(projectpath + "/Reports/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "java_cucumber_testNG");
		extent.addSystemInfo("Environment", "Test Server");
		extent.addSystemInfo("User Name", "Sunil Kumar");

		extent.loadConfig(new File(projectpath + "\\src\\test\\resources\\extent-config.xml"));
	}

	@Test
	public void passTest() {
		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test Case is  Passed");

	}

	@Test
	public void failTest() {
		logger = extent.startTest("failTest");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "Test Case (failTest) is  Passed");

	}

	@Test
	public void skipTest() {
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing");

	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}

		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.close();
	}
}
