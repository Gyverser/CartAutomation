package selepractoce.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class signUpPage extends AbstractComponents{
	
	WebDriver driver;

	public signUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="sign-username")
	public WebElement usernameInput;
	
	@FindBy(id="sign-password")
	public WebElement passwordInput;
	
	@FindBy(xpath="//button[contains(text(),'Sign')]")
	public WebElement signUpSubmit;
	
	@FindBy(xpath="//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']")
	public WebElement closeSignUpButton;
	
	public void signUp(String username, String password) {
		waitForWebElementToAppear(signUp);
		signUp.click();
		waitForWebElementToAppear(usernameInput);
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		waitForElementToBeClickable(signUpSubmit);
		signUpSubmit.click();
		
	}
	
	public void handlingSignUpAlert() {
		waitForAlertToBePresent();
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();
	}
	
	public void closeSignUpModal() {
		waitForElementToBeClickable(closeSignUpButton);
		closeSignUpButton.click();
		}
	
}
