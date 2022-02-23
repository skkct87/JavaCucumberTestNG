package config;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import com.google.common.collect.ImmutableMap;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
//		dryRun = true,
		publish = true, features = "src\\test\\java\\Features\\", glue = { "StepDefinations" }, plugin = { "pretty"
//        		 , "html:target/cucumber-reports.html"
//               ,"usage:target/cucumber-usage.json"
//               , "json:Reports/CucumberTestReport.json"
//              ,  "rerun:Reports/rerun.txt"
		}
		// , tags = "@Ignore"
		, monochrome = true)



public class TestRunner extends AbstractTestNGCucumberTests {
//	private TestNGCucumberRunner testNGCucumberRunner;
	public static WebDriver driver;
	public String baseurl = "https://www.google.com";
	String projectpath = System.getProperty("user.dir");
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	String filename =new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	
	
	
	
//	public Properties initialize_Properties() {
//		prop = new Properties();
//		try {
//			FileInputStream ip = new FileInputStream("/Users/NaveenKhunteta/Documents/workspace/JanPOMSeries/"
//					+ "src/main/java/com/qa/hubspot/config/config.properties");
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return prop;
//	}
	
	 @BeforeSuite
	    void setAllureEnvironment() {
	        allureEnvironmentWriter(
	                ImmutableMap.<String, String>builder()
	                        .put("Browser", "Chrome")
	                        .put("Browser.Version", "70.0.3538.77")
	                        .put("URL", "http://google.com")
	                        .build(),
	                        projectpath +  "/target/allure-results/");
	    }

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws InterruptedException {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.setProperty("webdriver.chrome.driver", projectpath + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	


//    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
//   public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
//       testNGCucumberRunner.runScenario(pickle.getPickle());
//    }

//   @DataProvider
//    public Object[][] getFeatures()
//   {
//       if(testNGCucumberRunner == null){
//            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//        }
//      return testNGCucumberRunner.provideScenarios();}
// 
//	
	

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
//        testNGCucumberRunner.finish();

		driver.close();
		driver.quit();
	}

	
	public String getScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = projectpath + "\\Screenshots\\" + filename + "_" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}


	

}
