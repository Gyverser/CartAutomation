package selepractoce.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td")
	public List<WebElement> cartProducts;
	
	@FindBy(css="button[data-target='#orderModal']")
	public WebElement placeOrder;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public PlaceOrderModal goToPlaceOrderForm() {
		placeOrder.click();
		PlaceOrderModal placeOrderModal = new PlaceOrderModal(driver);
		return placeOrderModal;
	}
	
}
