package selepractoce.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selepractoce.PageObjects.CartPage;
import selepractoce.PageObjects.contactPage;
import selepractoce.PageObjects.loginPage;
import selepractoce.PageObjects.signUpPage;

import org.openqa.selenium.support.FindBy;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="signin2")
	public WebElement signUp;
	
	@FindBy(id="login2")
	public WebElement login;
	
	@FindBy(xpath="//a[normalize-space()='Contact']")
	public WebElement contact;
	
	@FindBy(id="cartur")
	public WebElement cart;
	
	
	public CartPage goToCartPage() {
		waitForElementToBeClickable(cart);
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public void waitForElementToAppear(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
	}
	
	public void waitForWebElementToAppear(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public void waitForElementToBeClickable(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));
	}
	
	public void waitForAlertToBePresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
}
