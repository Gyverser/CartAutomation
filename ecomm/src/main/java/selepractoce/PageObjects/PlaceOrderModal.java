package selepractoce.PageObjects;

import java.math.BigInteger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class PlaceOrderModal extends AbstractComponents {
	
	WebDriver driver;
	
	public PlaceOrderModal(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	public WebElement placeOrderName;
	
	@FindBy(id="country")
	public WebElement placeOrderCountry;
	
	@FindBy(id="city")
	public WebElement placeOrderCity;
	
	@FindBy(id="card")
	public WebElement placeOrderCard;
	
	@FindBy(id="month")
	public WebElement placeOrderMonth;
	
	@FindBy(id="year")
	public WebElement placeOrderYear;
	
	@FindBy(css="button[onclick='purchaseOrder()']")
	public WebElement purchaseOrderButton;
	
	public ConfirmationModal placeOrderForm(String name, String country, String city, long card, String month, int year) {
		waitForElementToBeClickable(placeOrderName);
		placeOrderName.sendKeys(name);
		placeOrderCountry.sendKeys(country);
		placeOrderCity.sendKeys(city);
		placeOrderCard.sendKeys(String.valueOf(card));
		placeOrderMonth.sendKeys(month);
		placeOrderYear.sendKeys(String.valueOf(year));
		purchaseOrderButton.click();
		ConfirmationModal confirmationModal = new ConfirmationModal(driver);
		return confirmationModal;
	}
}
