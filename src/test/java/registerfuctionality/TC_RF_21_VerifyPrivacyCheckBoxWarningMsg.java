package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_21_VerifyPrivacyCheckBoxWarningMsg {

	public static void main(String[] args) {
		initializeDriver();
		navigateToRegistrationPage();
		fillMandatoryFldsInRegisPage();
		submitForm();
		verifyWarningMsg();
		quitBrowser();
		
		
	}
	final static String URL = "https://tutorialsninja.com/demo/";
	static ChromeDriver driver = new ChromeDriver();
	final static String PRIVACY_ER_MSG = "Warning: You must agree to the Privacy Policy!";

	//Initializing the Browser
	public static void initializeDriver() {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
     
	//Navigating to the registration page 
	public static void navigateToRegistrationPage() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
	}

	// Entering all the mandatory fields
	public static void fillMandatoryFldsInRegisPage() {
		WebElement fnameTextField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		fnameTextField.sendKeys("Vishnu");
		WebElement lnameTextField = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lnameTextField.sendKeys("kk");
		WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
		eMailTextField.sendKeys(generateEmail());
		WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		TelephoneTextField.sendKeys("1234567890");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordTextField.sendKeys("vish123");
		WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmPasswordTextField.sendKeys("vish123");
	}

	// Clicking on the Privacy Check box and Continue button to Submit the form
	public static void submitForm() {
        
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
	}
	// validating the Warning message ::
	public static void verifyWarningMsg() {
			WebElement ActualwarningMsg = driver
					.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
			String actualWarningMsgStr = ActualwarningMsg.getText();
			if (actualWarningMsgStr.equalsIgnoreCase(PRIVACY_ER_MSG)) {
				System.out.println("Test case passed::");
			}else {
				System.out.println("Test case Failed::");
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
