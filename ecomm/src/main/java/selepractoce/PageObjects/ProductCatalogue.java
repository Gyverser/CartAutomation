package selepractoce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selepractoce.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="mb-4")
	List<WebElement> products;
	
	@FindBy(css="a[onclick='addToCart(3)']")
	WebElement addToCartButton;
	
	By productsBy = By.className("mb-4");
	By goToAddToCartPage = By.className("hrefch");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductsByName(String productName) {
		WebElement prod = products.stream().filter(product -> product.findElement(By.className("card-title")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public signUpPage addProductsToCart(String productName) {
		WebElement prod = getProductsByName(productName);
		prod.findElement(goToAddToCartPage).click();
		waitForElementToBeClickable(addToCartButton);
		addToCartButton.click();
		waitForAlertToBePresent();
		driver.switchTo().alert().accept();
		signUpPage signUpPage = new signUpPage(driver);
		return signUpPage;
	}
	
	public void goTo() {
		driver.get("https://www.demoblaze.com/");
	}
}
