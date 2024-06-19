package selepractoce.ecomm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import selepractoce.PageObjects.loginPage;
import selepractoce.PageObjects.signUpPage;
import selepractoce.PageObjects.contactPage;
import selepractoce.PageObjects.PlaceOrderModal;
import selepractoce.PageObjects.ProductCatalogue;

public class BaseTest {

	protected WebDriver driver;
	public ProductCatalogue ProductCatalogue;
	public signUpPage signUpPage;
	public loginPage loginPage;
	public contactPage contactPage;
	public PlaceOrderModal placeOrderModal;
	
	
	
	
	@BeforeMethod(alwaysRun=true)
	public selepractoce.PageObjects.ProductCatalogue launchApplication() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		ProductCatalogue = new ProductCatalogue(driver);
		signUpPage = new signUpPage(driver);
		loginPage = new loginPage(driver);
		contactPage = new contactPage(driver);
		placeOrderModal = new PlaceOrderModal(driver);
		ProductCatalogue.goTo();
		return ProductCatalogue;
	}
	
	
	
	
}