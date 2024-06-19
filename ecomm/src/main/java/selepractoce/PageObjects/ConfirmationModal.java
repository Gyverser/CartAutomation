package selepractoce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class ConfirmationModal extends AbstractComponents {
	
	WebDriver driver;
	
	public ConfirmationModal(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[normalize-space()='Thank you for your purchase!']")
	public WebElement confirmationMessage;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	public WebElement confirmationButton;
	
	public String getConfirmationMessage() {
		waitForWebElementToAppear(confirmationMessage);
		return confirmationMessage.getText();
	}
	
	public void confirmationButtonClick() {
		waitForElementToBeClickable(confirmationButton);
		confirmationButton.click();
	}
	
}
