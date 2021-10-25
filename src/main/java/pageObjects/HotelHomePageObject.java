package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HotelHomePageObject extends Base{
	
	public HotelHomePageObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Sign in')]")
	private WebElement signIn;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath = "//h1[contains(text(),'Authentication')]")
	private WebElement authentication;
	
	
	public void clickSignIn() {
		signIn.click();
		
	}
	
	public boolean isEmailPresent() {
		if(email.isDisplayed())
			return true;
		else 
			return false;	
	}
	public boolean isAuthenticationDisplayed() {
		if(authentication.isDisplayed())
			return true;
		else 
			return false;	
		
	}
}
