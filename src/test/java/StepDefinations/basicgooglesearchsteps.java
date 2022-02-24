package StepDefinations;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;


import config.TestRunner;
import io.cucumber.java.en.*;
import io.qameta.allure.*;
import pageObject.googlebasicsearch;

@Listeners(Listener.ListenerTest.class)



public class basicgooglesearchsteps extends TestRunner {

	googlebasicsearch gs = new googlebasicsearch(driver);
	
	@Severity(SeverityLevel.NORMAL)
	@Story("Test verify base Websie title")
	@Description("Company Search via Google Search")
	@Step("I have chrome browser")
	@Given("I have chrome browser")	
	public void i_have_chrome_browser() {
				System.out.println("We are using Chrome Browser");
		driver.navigate().to(baseurl);	
		try {
		Assert.assertEquals(  "https://www.google.com/" ,driver.getCurrentUrl());}
		catch (Exception e ){
			System.out.println("URL not Matched" );
			e.printStackTrace();
		}
//		driver.navigate().to("www.tech.com");
//		Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
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
		try {
		Assert.assertEquals( "Datagardener LTD" ,  gs.searchbox());}
		catch (Exception e ){
			System.out.println("Keyword not Matched" );
			e.printStackTrace();
		}
		gs.submit();
		Thread.sleep(5000);
	}
	
	
	@Then("Get the title of website")
	@Step("Get the title of website")
	public void get_the_title_of_website() {
		String title = driver.getTitle();
//		  Reporter.log("Get the title of website");
		System.out.println("Title of website is :  " + title);
		try {
		Assert.assertEquals( "Datagardener LTD - Google Searc" , title);}
		catch (Exception e ){
			System.out.println("Title not Matched" );
			e.printStackTrace();
		}
	}
}
