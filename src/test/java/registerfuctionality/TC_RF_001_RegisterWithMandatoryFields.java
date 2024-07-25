package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_001_RegisterWithMandatoryFields {

	final static String URL = "https://tutorialsninja.com/demo/";
	static ChromeDriver driver = new ChromeDriver();
	

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
	public static void CheckPrivacyAndsubmitForm() {
        WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyCheckbxField.click();
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
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
	
	
        public static void main(String[] args) {
        	
		initializeDriver();
		navigateToRegistrationPage();
		fillMandatoryFldsInRegisPage();
		CheckPrivacyAndsubmitForm();
		validateAccCreationWithMandateFlds();
		quitBrowser();
        	}
	}











