package selepractoce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class loginPage extends AbstractComponents {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginusername")
	public WebElement usernameInputLogin;
	
	@FindBy(id="loginpassword")
	public WebElement passwordInputLogin;
	
	@FindBy(css="button[onclick='logIn()']")
	public WebElement loginButton;
	
	public void loginUser(String username, String password) {
		waitForElementToBeClickable(login);
		login.click();
		waitForWebElementToAppear(usernameInputLogin);
		usernameInputLogin.sendKeys(username);
		passwordInputLogin.sendKeys(password);
		waitForElementToBeClickable(loginButton);
		loginButton.click();
		
	}
	
	
	
}
