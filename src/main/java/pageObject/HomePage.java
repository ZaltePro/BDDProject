package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText = "Delete Account")
	WebElement click_DeleteAccountBtn;
	
	@FindBy(xpath = "//h2/b")
	WebElement get_AccountDeleteTitle;
	
	@FindBy(linkText = "Continue")
	WebElement clickCtnButton;
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement signupBtn;
	
	
	public void clickDeleteAccountButton() {
		click_DeleteAccountBtn.click();
	}
	
	public String get_AccountDeleteTitleText() {
		
		String text = get_AccountDeleteTitle.getText().trim().toLowerCase();
		
		return text;
	}
	
	public void clickContinue() {
		clickCtnButton.click();
	}
	
	public Boolean varifySignUpButton()
	{
		Boolean btn =  signupBtn.isDisplayed();
		return btn;
	}
	
	
}
