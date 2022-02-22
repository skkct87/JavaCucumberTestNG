package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableMap;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;







@CucumberOptions(
//		dryRun = true,
		publish = true,
        features = "src\\test\\java\\Features\\",
        glue = {"StepDefinations"},
        plugin = {"pretty"
//                "pretty:target/cucumber-pretty.txt" 
//               , "html:target/cucumber-reports.html"
//               ,"usage:target/cucumber-usage.json"
//               , "json:Reports/CucumberTestReport.json"
//              ,  "rerun:Reports/rerun.txt"
              }
		//       , tags = "@Ignore"
       , monochrome = true
        		)

public class TestRunner extends AbstractTestNGCucumberTests {
//	private TestNGCucumberRunner testNGCucumberRunner;
	public static WebDriver driver;
	public String baseurl = "https://www.google.com";
	String projectpath = System.getProperty("user.dir");
	
	
	 
	 @BeforeSuite
	    void setAllureEnvironment() {
	        allureEnvironmentWriter(
	                ImmutableMap.<String, String>builder()
	                        .put("Browser", "Chrome")
	                        .put("Browser.Version", "98.0.4758.102")
	                        .put("URL", "http://www.google.com")
	                        .build(), System.getProperty("user.dir")
	                        + "/allure-results/");
	    }




	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws InterruptedException {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        System.setProperty("webdriver.chrome.driver", projectpath +"\\driver\\chromedriver.exe");
  	  driver = new ChromeDriver();
  	  driver.manage().window().maximize();	  
  	  Thread.sleep(1000);
    }
    
//    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
//    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runScenario(pickle.getPickle());
//    }

//    @DataProvider
//    public Object[][] getFeatures()
//    {
//        if(testNGCucumberRunner == null){
//            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//        }
//        return testNGCucumberRunner.provideScenarios();
//    }
    
//    @AfterStep 
//    public void reporterlog() {
//    	Reporter.log(Step.class.getName());
//    }
    
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
//        testNGCucumberRunner.finish();
    	driver.close();
    	driver.quit();
    }
    
//    @AfterClass(alwaysRun = true)
//    public void af(Scenario scenario) throws InterruptedException, IOException, IllegalMonitorStateException
//    {	
//        if(scenario.isFailed())
//        {	
//            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        }
//    }
    

}
