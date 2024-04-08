package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	public WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//signup first step
	public static By register_Firstname = By.name("name");//done
	@FindBy(name = "name")
	WebElement firstName;
	
	public void enterFirstNameOnFirstPage(String enter_Firstname) {
		firstName.sendKeys(enter_Firstname);
	}
	
	
	public static By register_email = By.xpath("//form[@action='/signup']//input[@name='email']");//done
	@FindBy(xpath = "//form[@action='/signup']//input[@name='email']")
	WebElement email;
	
	public void enterEmailOnFirstPage(String enter_Email) {
		email.sendKeys(enter_Email);
	}
	
	
	public static By register_signUpBtn = By.xpath("//form[@action='/signup']//button[@type='submit']");//done
	@FindBy(xpath = "//form[@action='/signup']//button[@type='submit']")
	WebElement signUpBtn;
	
	public void clickSignButton() {
		signUpBtn.click();
	}
	
	//signup second page
	public static By Register_Heading = By.xpath("//div[@class='login-form']/h2/b");//done
	@FindBy(xpath = "//div[@class='login-form']/h2/b")
	WebElement Heading;
	
	public String getHeadingText() {
		String val = Heading.getText().trim().toString();
		return val;
	}
	
	public static By Register_Title_Mr = By.id("uniform-id_gender1");//done
	@FindBy(id = "uniform-id_gender1")
	WebElement select_MR;
	
	public void selectMrTitle() {
		select_MR.click();
	}
	
	public static By Register_Title_Mrs = By.id("uniform-id_gender2");//done
	@FindBy(id = "uniform-id_gender2")
	WebElement select_MRS;
	
	public void selectMrsTitle() {
		select_MRS.click();
	}
	
	public static By Register_GetName = By.id("name");//done
	@FindBy(id = "name")
	WebElement register_getName;
	
	public String getName() {
		String getname = register_getName.getAttribute("value").trim();
		return getname;
	}
	
	public static By Register_GetEmail = By.id("email");//done
	@FindBy(id = "email")
	WebElement register_GetEmail;
	
	public String getEmail() {
		String getemail = register_GetEmail.getAttribute("value").trim();
		return getemail;
	}
	
	public static By Register_Enter_Password = By.id("password");//done
	@FindBy(id = "password")
	WebElement enter_passWord;
	
	public void enterPassword(String password) {
		enter_passWord.sendKeys(password);
	}
	
	//date picker
	public static By Register_DatePicker_Day = By.xpath("//select[@id='days']");//done
	@FindBy(xpath = "//select[@id='days']")
	WebElement datePicker_Day;
	
	@FindBy(xpath = "//select[@id='months']")
	WebElement datePicker_Months;
	
	@FindBy(xpath = "//select[@id='years']")
	WebElement datePicker_Years;
	
	public void selectDDMMYYY(String dateOfBirth) {
		
		String[] datepicker = dateOfBirth.split("/");
		
		Select day = new Select(datePicker_Day); day.selectByVisibleText(datepicker[0]);
		
		Select monthSelect = new Select(datePicker_Months); monthSelect.selectByValue(datepicker[1]);
		
		Select yearSelect = new Select(datePicker_Years); yearSelect.selectByValue(datepicker[2]);
	}
	
	
	
	public static By Register_addressInformation_FirstName = By.id("first_name");
	@FindBy(id = "first_name")
	WebElement addressInformation_FirstName;
	
	public void enter_addressInformation_FirstName(String firstname) {
		addressInformation_FirstName.sendKeys(firstname);
	}
	
	
	public static By Register_addressInformation_LastName = By.id("last_name");
	@FindBy(id = "last_name")
	WebElement addressInformation_LastName;
	
	public void enter_addressInformation_LastName(String lastname) {
		addressInformation_LastName.sendKeys(lastname);
	}
	
	public static By Register_addressInformation_Company = By.id("company");
	@FindBy(id = "company")
	WebElement addressInformation_Company;
	
	public void enter_addressInformation_Company(String companyName) {
		addressInformation_Company.sendKeys(companyName);
	}
	
	public static By Register_addressInformation_Address1 = By.id("address1");
	@FindBy(id = "address1")
	WebElement addressInformation_Address1;
	
	public void enter_addressInformation_Address1(String Address1) {
		addressInformation_Address1.sendKeys(Address1);
	}
	
	public static By Register_addressInformation_Address2 = By.id("address2");
	@FindBy(id = "address2")
	WebElement addressInformation_Address2;
	
	public void enter_addressInformation_Address2(String Address2) {
		addressInformation_Address2.sendKeys(Address2);
	}
	
	public static By Register_addressInformation_CountryDropDown = By.id("country");
	@FindBy(id = "country")
	WebElement addressInformation_CountryDropDown;
	
	public void selectCountryInDropDown(String Country) {
		
		Select county = new Select(addressInformation_CountryDropDown);
		
		county.selectByValue(Country);
	}
	
	
	public static By Register_addressInformation_State = By.id("state");
	@FindBy(id = "state")
	WebElement addressInformation_State;
	
	public void enter_addressInformation_State(String state) {
		addressInformation_State.sendKeys(state);
	}
	
	public static By Register_addressInformation_City = By.id("city");
	@FindBy(id = "city")
	WebElement addressInformation_City;
	
	public void enter_addressInformation_City(String City) {
		addressInformation_City.sendKeys(City);
	}
	
	public static By Register_addressInformation_Zipcode = By.id("zipcode");
	@FindBy(id = "zipcode")
	WebElement addressInformation_Zipcode;
	
	public void enter_addressInformation_Zipcode(String zipcode) {
		addressInformation_Zipcode.sendKeys(zipcode);
	}
	
	public static By Register_addressInformation_MobileNumber = By.id("mobile_number");
	@FindBy(id = "mobile_number")
	WebElement addressInformation_MobileNumber;
	
	public void enter_addressInformation_MobileNumber(String MobileNumber) {
		addressInformation_MobileNumber.sendKeys(MobileNumber);
	}
	
	public static By Register_addressInformation_CreateAccountBtn = By.xpath("//button[@data-qa='create-account']");
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement addressInformation_CreateAccountBtn;
	
	public void click_CreateAccountBtn() {
		addressInformation_CreateAccountBtn.click();
	}
	
	//Create account page locators
	public static By Register_AccountCreatedPage_Title = By.xpath("//h2[@class='title text-center']");
	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement AccountCreatedPage_Title;
	
	public String get_AccountCreatedPage_Title() {
		String gettaxt = AccountCreatedPage_Title.getText().trim().toString();
		return gettaxt;
	}
	
	public static By Register_AccountCreatedPage_ContinueBtn = By.linkText("Continue");
	@FindBy(linkText = "Continue")
	WebElement AccountCreatedPage_ContinueBtn;
	
	public void click_AccountCreatedPage_ContinueBtn() {
		AccountCreatedPage_ContinueBtn.click();
	}
	
	
	
	
}
