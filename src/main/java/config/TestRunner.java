package config;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;





@CucumberOptions(
		publish = true,
        features = "src\\test\\java\\Features\\",
        glue = {"StepDefinations"},
        plugin = {
                "pretty"
               , "html:target/cucumber-reports.html"
               , "json:target/cucumber-reports/CucumberTestReport.json"
              ,  "rerun:target/cucumber-reports/rerun.txt"
              }
		//       , tags = "@Ignore"
       , monochrome = true
        		)

public class TestRunner extends AbstractTestNGCucumberTests {
//	private TestNGCucumberRunner testNGCucumberRunner;
	public static WebDriver driver;
	public String baseurl = "https://www.google.com";
	String projectpath = System.getProperty("user.dir");

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
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
//        testNGCucumberRunner.finish();
    	driver.close();
    	driver.quit();
    }
    

}
