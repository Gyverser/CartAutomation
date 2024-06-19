package selepractoce.ecomm;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selepractoce.PageObjects.CartPage;
import selepractoce.PageObjects.ConfirmationModal;
import selepractoce.PageObjects.PlaceOrderModal;
import selepractoce.PageObjects.ProductCatalogue;
import selepractoce.PageObjects.contactPage;
import selepractoce.PageObjects.loginPage;
import selepractoce.PageObjects.signUpPage;

public class PomTest2 extends BaseTest {

	String productName = "Nexus 6";
	
	@Test
	public void e2eTest() throws InterruptedException {

		// signup
		signUpPage.signUp("dzi","dzi");
		signUpPage.handlingSignUpAlert();
		signUpPage.closeSignUpModal();
		
		// login
		loginPage.loginUser("dzi", "dzi");

		// contact
		contactPage.handlingContactException();
		contactPage.contactForm("dzi@gmail.com", "dzi", "Page Object Model with Page Factory.");
		
		//adding to cart
		List<WebElement> products = ProductCatalogue.getProductList();
		ProductCatalogue.addProductsToCart(productName);
		CartPage cartPage = ProductCatalogue.goToCartPage();
		
		//cart
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		PlaceOrderModal placeOrderModal = cartPage.goToPlaceOrderForm();
		ConfirmationModal confirmationModal = placeOrderModal.placeOrderForm("dzi", "Spain", "Madrid", 1112131456, "January", 1997);
		String checkoutMessage = confirmationModal.getConfirmationMessage();
		Assert.assertTrue(checkoutMessage.equalsIgnoreCase("Thank you for your purchase!"));
		confirmationModal.confirmationButtonClick();
		
	}

}