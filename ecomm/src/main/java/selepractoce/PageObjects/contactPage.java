package selepractoce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class contactPage extends AbstractComponents {

	WebDriver driver;
	
	public contactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="recipient-email")
	public WebElement contactEmailInput;
	
	@FindBy(id="recipient-name")
	public WebElement contactNameInput;
	
	@FindBy(id="message-text")
	public WebElement contactTextArea;
	
	@FindBy(css="button[onclick='send()']")
	public WebElement contactSendMessageButton;
	
	public void contactForm(String email,String name, String comment) {
		waitForElementToBeClickable(contactEmailInput);
		contactEmailInput.sendKeys(email);
		contactNameInput.sendKeys(name);
		contactTextArea.sendKeys(comment);
		waitForElementToBeClickable(contactSendMessageButton);
		contactSendMessageButton.click();
		driver.switchTo().alert().accept();
	}
	
	public void handlingContactException() {
		try {
			waitForElementToBeClickable(contact);
			contact.click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			waitForElementToBeClickable(contact);
			contact.click();
		}
		
	}
	
	
}
