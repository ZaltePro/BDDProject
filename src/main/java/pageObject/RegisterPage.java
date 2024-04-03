package pageObject;

import org.openqa.selenium.By;

public class RegisterPage {

	//signup first step
	public static By register_Firstname = By.name("name");
	
	public static By register_email = By.xpath("//form[@action='/signup']//input[@name='email']");
	
	public static By register_signUpBtn = By.xpath("//form[@action='/signup']//button[@type='submit']");
	
	//signup second page
	public static By Register_Heading = By.xpath("//div[@class='login-form']/h2/b");
	
	public static By Register_Title_Mr = By.id("uniform-id_gender1");
	
	public static By Register_Title_Mrs = By.id("uniform-id_gender2");
	
	public static By Register_GetName = By.id("name");
	
	public static By Register_GetEmail = By.id("email");
	
	public static By Register_Enter_Password = By.id("password");
	
	//date picker
	public static By Register_DatePicker_Day = By.xpath("//select[@id='days']");
	
	public static By Register_addressInformation_FirstName = By.id("first_name");
	
	public static By Register_addressInformation_LastName = By.id("last_name");
	
	public static By Register_addressInformation_Company = By.id("company");
	
	public static By Register_addressInformation_Address1 = By.id("address1");
	
	public static By Register_addressInformation_Address2 = By.id("address2");
	
	public static By Register_addressInformation_CountryDropDown = By.id("country");
	
	public static By Register_addressInformation_State = By.id("state");
	
	public static By Register_addressInformation_City = By.id("city");
	
	public static By Register_addressInformation_Zipcode = By.id("zipcode");
	
	public static By Register_addressInformation_MobileNumber = By.id("mobile_number");
	
	public static By Register_addressInformation_CreateAccountBtn = By.xpath("//button[@data-qa='create-account']");
	
	
	//Create account page locators
	public static By Register_AccountCreatedPage_Title = By.xpath("//h2[@class='title text-center']");
	
	public static By Register_AccountCreatedPage_ContinueBtn = By.linkText("Continue");
	
	
	
	
	
}
