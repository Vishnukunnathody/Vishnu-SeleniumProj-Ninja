package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_RF_12_RegisteringWithKeyBoardKeys {

	static String URL = "https://tutorialsninja.com/demo/";
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {
		initializeDriver();
		navigateToRegistrationPage();
		fillMandatoryFldsInRegisPage();
		validateAccCreationWithMandateFlds();
		quitBrowser();
		
	}

	// initialize the Browser
	public static void initializeDriver() {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	// Click on the register Page
	public static void navigateToRegistrationPage() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
	}

	// Enter the mandatory fields with Key board keys
	public static void fillMandatoryFldsInRegisPage() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement loginPageLink = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		loginPageLink.click();
		action.sendKeys("Vish").sendKeys(Keys.TAB);
		action.sendKeys("KK").sendKeys(Keys.TAB);
		action.sendKeys(generateEmail()).sendKeys(Keys.TAB);
		action.sendKeys("12345678").sendKeys(Keys.TAB);
		action.sendKeys("vish123").sendKeys(Keys.TAB);
		action.sendKeys("vish123").sendKeys(Keys.TAB);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.SPACE);
		action.sendKeys(Keys.TAB).sendKeys(Keys.SPACE);
		Thread.sleep(11000);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
		.perform();
		
        
	}
	// Validation
		public static void validateAccCreationWithMandateFlds() {
			String accountCreatedMsg = "Your Account Has Been Created!";
			WebElement accountCreatedMsgElement = driver
					.findElement(By.xpath("//div/h1[text()='Your Account Has Been Created!']"));

			if (accountCreatedMsg.equalsIgnoreCase(accountCreatedMsgElement.getText())) {
				System.out.println("Test case passed ::");
			} else {
				System.out.println("Test case Not passed ::");
			}
		}

	// Closing the Browser
	public static void quitBrowser() {
		driver.quit();
	}

	// Creating dynamic email
	public static String generateEmail() {
		Date date = new Date();
		return "vish" + date.toString().replace(" ", "_").replace(":", "_") + "@mailinator.com";
	}



}
