package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_17_Verify_password_Complexity {
	
	
	static String passSevenChar = "Abdef@1";      // 7 digits 
	static String passOneNumber = "Abdef@G";     // No numbers 
	static String passOneSymbol = "Abcdefg1";    //  Should Contain 1 Symbol
	static String PassLowercase ="ABCDEFG@1";    //Should contain at-least one lower case 
	static  String passUppercase = "abcdef@1";   //Should contain at-least one Upper case 
	final static String PASS_ER_MSG = "Password must be between 4 and 20 characters!";
	
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
		// Clicking on the Privacy Check box and Continue button to Submit the form
		public static void CheckPrivacyAndsubmitForm() {
	        WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
			privacyPolicyCheckbxField.click();
			if(!privacyPolicyCheckbxField.isSelected()) {
				privacyPolicyCheckbxField.click();
			}
			WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
			continuebutn.click();
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
			
		}
		// verifying the complexity of passwords .
	/*	public static void verifyPassComplexity(ChromeDriver driver,String passwordText) throws InterruptedException {
			
			WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
			passwordTextField.sendKeys(passwordText);
			WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
			confirmPasswordTextField.sendKeys(passwordText);
			CheckPrivacyAndsubmitForm();
			WebElement PassErrorMsg = driver.findElement(By.xpath("//div[contains(text(),'Password must')]"));
			if(PassErrorMsg.isDisplayed()) {
				System.out.println("Test Case passed :: "+PassErrorMsg.getText());
				 driver.findElement(By.xpath("//input[@id='input-password']")).clear();
				 driver.findElement(By.xpath("//input[@id='input-confirm']")).clear();
			}
			*/
		
		
			// verifying the complexity of passwords .
			public static void verifyPassComplexity(ChromeDriver driver,String passwordText) throws InterruptedException {
				
				WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
				passwordTextField.sendKeys(passwordText);
				WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
				confirmPasswordTextField.sendKeys(passwordText);
				CheckPrivacyAndsubmitForm();
				WebElement PassErrorMsg = driver.findElement(By.xpath("//div[contains(text(),'Password must')]"));
				if(PassErrorMsg.isDisplayed()) {
					System.out.println("Test Case passed :: "+passwordText+":: "+PassErrorMsg.getText());
					passwordTextField.clear();
					confirmPasswordTextField.clear();
				}
			
		}
	public static void main(String[] args) throws InterruptedException {
		
		initializeDriver();
		navigateToRegistrationPage();
		fillMandatoryFldsInRegisPage();
		verifyPassComplexity(driver," ");
		verifyPassComplexity(driver,passSevenChar);
		verifyPassComplexity(driver,passOneNumber);
		verifyPassComplexity(driver,passOneSymbol);
		verifyPassComplexity(driver,PassLowercase);
		verifyPassComplexity(driver,passUppercase);
		quitBrowser();
		
	}

}
//Why getting stale element exception.
// will fail because the password field  is not validating the Password complexity .