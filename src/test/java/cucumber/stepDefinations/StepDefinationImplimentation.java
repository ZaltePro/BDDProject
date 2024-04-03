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
import pageObject.RegisterPage;


public class StepDefinationImplimentation {

		WebDriver driver;
		
		
	
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
	        
	    	driver.findElement(RegisterPage.register_Firstname).sendKeys(firstName);
	    	driver.findElement(RegisterPage.register_email).sendKeys(email);
	    	driver.findElement(RegisterPage.register_signUpBtn).click();
	    	
	    	name_verify = firstName;
	    	email_verify = email;
	    	
	    }

	    @When("I want to enter Account information: {string} , {string}, {string}")
	    public void i_want_to_enter_account_information(String title, String password, String dateOfBirth) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    	Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterPage.Register_Heading)).getText().toString(), "ENTER ACCOUNT INFORMATION");
	    	
	    	//Select the Title
	    	if(title.equals("Mr")) {
	    		
	    		driver.findElement(RegisterPage.Register_Title_Mr).click();
	    	} else if (title.equals("Mrs")) {
	    		driver.findElement(RegisterPage.Register_Title_Mrs).click();
	    	}else {
	    		System.out.println("Please select the title");
	    	}
	    	
	    	//Verify name and email
	    	Assert.assertEquals(driver.findElement(By.id("name")).getAttribute("value").trim(), name_verify);
	    	
	    	Assert.assertEquals(driver.findElement(By.id("email")).getAttribute("value").trim(), email_verify);
	    	
	    	
	    	//Enter password
	    	driver.findElement(RegisterPage.Register_Enter_Password).sendKeys(password);
	    	
	    	String[] datepicker = dateOfBirth.split("/");
	    	
	    	//Select day
	    	Select day = new Select(driver.findElement(By.xpath("//select[@id='days']")));
	    	day.selectByVisibleText(datepicker[0]);
	  
	    	
	    	//Select month
	    	Select monthSelect = new Select(driver.findElement(By.xpath("//select[@id='months']")));
    		
    		monthSelect.selectByValue(datepicker[1]);
	    	
	    	//Select year
    		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@id='years']")));
    		
    		yearSelect.selectByValue(datepicker[2]);

	    }

	    @And("I want to enter Addresss information: {string} , {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	    public void i_want_to_enter_addresss_information(String FirstName, String Lastname, String CompanyName, String address1, String address2, String Country, String State, String City, String zipcode, String mobileNumber) {

	    	driver.findElement(RegisterPage.Register_addressInformation_FirstName).sendKeys(FirstName);
	    	driver.findElement(RegisterPage.Register_addressInformation_LastName).sendKeys(Lastname);
	    	driver.findElement(RegisterPage.Register_addressInformation_Company).sendKeys(CompanyName);
	    	driver.findElement(RegisterPage.Register_addressInformation_Address1).sendKeys(address1);
	    	driver.findElement(RegisterPage.Register_addressInformation_Address2).sendKeys(address2);
	    	
	    	Select county = new Select(driver.findElement(By.id("country")));	    	
	    	
	    	county.selectByValue(Country);
	    	
	    	driver.findElement(RegisterPage.Register_addressInformation_State).sendKeys(State);
	    	driver.findElement(RegisterPage.Register_addressInformation_City).sendKeys(City);
	    	driver.findElement(RegisterPage.Register_addressInformation_Zipcode).sendKeys(zipcode);
	    	driver.findElement(RegisterPage.Register_addressInformation_MobileNumber).sendKeys(mobileNumber);
	    	
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(RegisterPage.Register_addressInformation_CreateAccountBtn));
	    	
	    	driver.findElement(RegisterPage.Register_addressInformation_CreateAccountBtn).click();
	    	
	    	
	    }

	    @Then("I want to verify the account is created")
	    public void i_want_to_verify_the_account_is_created() {
	//        System.out.println("Verify account creation");
	    	
	    	Assert.assertEquals(driver.findElement(RegisterPage.Register_AccountCreatedPage_Title).getText(), "ACCOUNT CREATED!");
	    	
	    	driver.findElement(RegisterPage.Register_AccountCreatedPage_ContinueBtn).click();
	    	
	    	System.out.println("Close now");
	    }

}
