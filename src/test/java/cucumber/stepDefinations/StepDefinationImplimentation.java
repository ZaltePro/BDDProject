package cucumber.stepDefinations;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.HomePage;
import pageObject.RegisterPage;
import resource.Utility;


public class StepDefinationImplimentation {

		WebDriver driver;
		
		RegisterPage registerPageObj;
		
		HomePage homepageObj;
		
	
		@Given("i want to open the Ecomerce site")
	    public void i_want_to_open_the_Ecomerce_site() {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://automationexercise.com/login");
	    }

		String name_verify;
		String email_verify;
	    @Given("I enter {string} and {string}")
	    public void i_enter_FirstName_and_Email(String firstName, String email) {
	        
	    	registerPageObj = new RegisterPage(driver);
	    	
	    	registerPageObj.enterFirstNameOnFirstPage(firstName);
	    	
	    	registerPageObj.enterEmailOnFirstPage(email);
	    	
	    	registerPageObj.clickSignButton();
	    	
	    	name_verify = firstName;
	    	email_verify = email;
	    	
	    }

	    @When("I want to enter Account information: {string} , {string}, {string}")
	    public void i_want_to_enter_account_information(String title, String password, String dateOfBirth) {
	    	
	    	registerPageObj = new RegisterPage(driver);
	    	
	    	Utility.visibilityOfElementLocated(driver , RegisterPage.Register_Heading);

	    	Assert.assertEquals(registerPageObj.getHeadingText(), "ENTER ACCOUNT INFORMATION");
	    	
	    	//Select the Title
	    	if(title.equals("Mr"))
	    	{
	    		registerPageObj.selectMrTitle();
	    	} 
	    	else if (title.equals("Mrs")) 
	    	{
	    		registerPageObj.selectMrsTitle();
	    	}
	    	else 
	    	{
	    		System.out.println("Please select the title");
	    	}
	    	
	    	//Verify name and email
	    	Assert.assertEquals(registerPageObj.getName(), name_verify);
	    	
	   
	    	Assert.assertEquals(registerPageObj.getEmail(), email_verify);
	    	
	    	//Enter password
	    	registerPageObj.enterPassword(password);
	    	
	    	registerPageObj.selectDDMMYYY(dateOfBirth);

	    }

	    @And("I want to enter Addresss information: {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	    public void i_want_to_enter_addresss_information(String FirstName, String Lastname, String CompanyName, String address1, String address2, String Country, String State, String City, String zipcode, String mobileNumber) {
	    	
	    	registerPageObj = new RegisterPage(driver);
	    	
	    	registerPageObj.enter_addressInformation_FirstName(FirstName);
	    	
	    	registerPageObj.enter_addressInformation_LastName(Lastname);
	    	
	    	registerPageObj.enter_addressInformation_Company(CompanyName);
	    	
	    	registerPageObj.enter_addressInformation_Address1(address1);
	    	
	    	registerPageObj.enter_addressInformation_Address2(address2);

	    	
	    	registerPageObj.selectCountryInDropDown(Country);
	    	
	    	registerPageObj.enter_addressInformation_State(State);
	    	
	    	registerPageObj.enter_addressInformation_City(City);
	    	
	    	registerPageObj.enter_addressInformation_Zipcode(zipcode);
	    	
	    	registerPageObj.enter_addressInformation_MobileNumber(mobileNumber);
	    	
	    	Utility.ScrollToElement(driver , driver.findElement(RegisterPage.Register_addressInformation_CreateAccountBtn));
	    	registerPageObj.click_CreateAccountBtn();
	    	
	    }

	    @Then("I want to verify the account is created")
	    public void i_want_to_verify_the_account_is_created() {
	    	
	    	registerPageObj = new RegisterPage(driver);
	    	
	    	Assert.assertEquals(registerPageObj.get_AccountCreatedPage_Title(), "ACCOUNT CREATED!");

	    	registerPageObj.click_AccountCreatedPage_ContinueBtn();

	    }
	    
	    
	    
	    @Given("Click the Delete account button on header bar")
	    public void click_the_delete_account_button_on_header_bar() {
	    	
	    	homepageObj = new HomePage(driver);
	    	
	    	homepageObj.clickDeleteAccountButton();
	    
	    	
	    }
	    @When("Varify the information messsage")
	    public void varify_the_information_messsage() {
	    	
	    	homepageObj = new HomePage(driver);
	    	
	    	Assert.assertEquals(homepageObj.get_AccountDeleteTitleText(), "Account Deleted!");

	    }
	    @When("Click the Okay button")
	    public void click_the_okay_button() {
	    	
	    	homepageObj = new HomePage(driver);
	    	
	    	homepageObj.clickContinue();

	    }
	    @Then("Check the deshboard")
	    public void check_the_deshboard() {
	    	
	    	Assert.assertEquals(homepageObj.varifySignUpButton(), true);
	    }
	    
	    
	    

}
