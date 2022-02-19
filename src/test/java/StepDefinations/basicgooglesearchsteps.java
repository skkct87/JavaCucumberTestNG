package StepDefinations;



import config.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.googlebasicsearch;


public class basicgooglesearchsteps extends TestRunner {
	

	googlebasicsearch gs =new googlebasicsearch(driver);
	
	 @Given("I have chrome browser")
	  public void i_have_chrome_browser() { 			
			System.out.println("We are using Chrome Browser");
			driver.navigate().to(baseurl);
	  }

	  @When("i search insert company name in search box")
	  public void i_search_insert_company_name_in_search_box() {
		   gs.iosearch("Datagardener LTD");
	     	  }

	  @Then("it will start search with keyword")
	  public void it_will_start_search_with_keyword() throws InterruptedException {
		   gs.submit();
		   Thread.sleep(5000);
	        }

	  @Then("Get the title of website")
	  public void get_the_title_of_website() {
		  String title = driver.getTitle();
			System.out.println("Title of website is :  " +title);
	     	  }
}
