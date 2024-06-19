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

public class AppTest {

	WebDriver driver = new ChromeDriver();
	String url = "https://www.demoblaze.com/";
	Wait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	String productName = "Nexus 6";
	
	
	@Test
	public void e2eTest() throws InterruptedException {

		driver.get(url);
		driver.manage().window().maximize();
		
		// signup
		WebElement signUp = driver.findElement(By.id("signin2"));
		wait.until(ExpectedConditions.elementToBeClickable(signUp));
		signUp.click();
		String username = "dzi";
		WebElement usernameInput = driver.findElement(By.id("sign-username"));
		wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
		usernameInput.sendKeys(username);
		String password = "dzi";
		WebElement passwordInput = driver.findElement(By.id("sign-password"));
		passwordInput.sendKeys(password);
		WebElement signUpSubmit = driver.findElement(By.xpath("//button[contains(text(),'Sign')]"));
		wait.until(ExpectedConditions.elementToBeClickable(signUpSubmit));
		signUpSubmit.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		Assert.assertEquals("This user already exist.", alertMessage);
		alert.accept();
		WebElement closeSignUpFormButton = driver
				.findElement(By.xpath("//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']"));
		wait.until(ExpectedConditions.elementToBeClickable(closeSignUpFormButton));
		closeSignUpFormButton.click();

		// login
		WebElement login = driver.findElement(By.id("login2"));
		login.click();
		WebElement usernameInputLogin = driver.findElement(By.id("loginusername"));
		wait.until(ExpectedConditions.elementToBeClickable(usernameInputLogin));
		usernameInputLogin.sendKeys(username);
		WebElement passwordInputLogin = driver.findElement(By.id("loginpassword"));
		passwordInputLogin.sendKeys(password);
		WebElement loginButton = driver.findElement(By.cssSelector("button[onclick='logIn()']"));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();

		// contact
		try {
			WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
			wait.until(ExpectedConditions.elementToBeClickable(contact));
			contact.click();
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement contact = driver.findElement(By.xpath("//a[normalize-space()='Contact']"));
			wait.until(ExpectedConditions.elementToBeClickable(contact));
			contact.click();
		}

		String email = "dzidzi@gmail.com";
		WebElement contactEmailInput = driver.findElement(By.id("recipient-email"));
		wait.until(ExpectedConditions.elementToBeClickable(contactEmailInput));
		contactEmailInput.sendKeys(email);
		String name = "dziar";
		WebElement contactNameInput = driver.findElement(By.id("recipient-name"));
		contactNameInput.sendKeys(name);
		WebElement contactTextArea = driver.findElement(By.id("message-text"));
		String comment = "This is a random comment";
		contactTextArea.sendKeys(comment);
		WebElement contactSendMessage = driver.findElement(By.cssSelector("button[onclick='send()']"));
		contactSendMessage.click();
		driver.switchTo().alert().accept();
		
		//adding to cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mb-4")));
		List<WebElement> products = driver.findElements(By.className("mb-4"));
		WebElement prod = products.stream().filter(product -> product.findElement(By.className("card-title")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		prod.findElement(By.className("hrefch")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
		WebElement validateName = driver.findElement(By.className("name"));
		Assert.assertEquals(validateName.getText(), productName);
		WebElement addToCartButton = driver.findElement(By.cssSelector("a[onclick='addToCart(3)']"));
		addToCartButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertCart = driver.switchTo().alert();
		alertCart.getText();
		Assert.assertEquals("Product added.", alertCart.getText());
		alertCart.accept();
		WebElement cart = driver.findElement(By.id("cartur"));
		cart.click();
		
		//cart
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td")));
		List<WebElement> cartProducts = driver.findElements(By.xpath("//td"));
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		WebElement placeOrder = driver.findElement(By.cssSelector("button[data-target='#orderModal']"));
		placeOrder.click();
		
		//place order form authentication
		wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		WebElement placeOrderName = driver.findElement(By.id("name"));
		placeOrderName.sendKeys("dzi");
		WebElement placeOrderCountry = driver.findElement(By.id("country"));
		placeOrderCountry.sendKeys("Spain");
		WebElement placeOrderCity = driver.findElement(By.id("city"));
		placeOrderCity.sendKeys("Madrid");
		WebElement placeOrderCard = driver.findElement(By.id("card"));
		placeOrderCard.sendKeys("1112131415161718");
		WebElement placeOrderMonth = driver.findElement(By.id("month"));
		placeOrderMonth.sendKeys("March");
		WebElement placeOrderYear = driver.findElement(By.id("year"));
		placeOrderYear.sendKeys("1997");
		WebElement purchaseButton = driver.findElement(By.cssSelector("button[onclick='purchaseOrder()']"));
		purchaseButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='OK']")));
		WebElement confirmButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
		confirmButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button'][normalize-space()='Close'][3]")));
		WebElement closeButton = driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Close'][3]"));
		closeButton.click();
		
	}

}