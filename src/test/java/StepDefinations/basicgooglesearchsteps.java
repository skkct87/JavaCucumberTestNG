package StepDefinations;



import config.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import pageObject.googlebasicsearch;

public class basicgooglesearchsteps extends TestRunner {

	googlebasicsearch gs = new googlebasicsearch(driver);

	@Severity(SeverityLevel.NORMAL)
	@Story("Test verify base Websie title")
	@Description("Company Search via Google Search")

	@Step("I have chrome browser")
	@Given("I have chrome browser")
	public void i_have_chrome_browser() {
		System.out.println("We are using Chrome Browser");
//			Reporter.log("We are using Chrome Browser");
		driver.navigate().to(baseurl);
	}

	
	@Step("i search insert company name in search box")
	@When("i search insert company name in search box")
	public void i_search_insert_company_name_in_search_box() {
		gs.iosearch("Datagardener LTD");
//		   Reporter.log("i search insert company name in search box");
	}

	
	@Then("it will start search with keyword")
	@Step("it will start search with keyword")
	public void it_will_start_search_with_keyword() throws InterruptedException {
		gs.submit();
//		   Reporter.log("it will start search with keyword");
		Thread.sleep(5000);
	}

	
	@Then("Get the title of website")
	@Step("Get the title of website")
	public void get_the_title_of_website() {
		String title = driver.getTitle();
//		  Reporter.log("Get the title of website");
		System.out.println("Title of website is :  " + title);
	}
}
