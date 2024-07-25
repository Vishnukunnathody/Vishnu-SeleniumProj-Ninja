package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_19_Verify_TrimForRegisterPage {

	final static String URL_GUERILLA_MAIL = "https://www.guerrillamail.com/inbox";
		final static String URL = "https://tutorialsninja.com/demo/";
		static ChromeDriver driver = new ChromeDriver();
		static String email;
	
		

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
			fnameTextField.sendKeys(" Vishnu ".trim());
			WebElement lnameTextField = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			lnameTextField.sendKeys(" kk ".trim());
			WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
			eMailTextField.sendKeys(email.trim());
			WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
			TelephoneTextField.sendKeys(" 1234567890 ".trim());
			WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
			passwordTextField.sendKeys(" vish123 ".trim());
			WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
			confirmPasswordTextField.sendKeys(" vish123 ".trim());
			
		}
		
		// Validation for the trim
		public static void validateTrim(ChromeDriver driver ,String nameAttr,String ExpectedResult) {
			WebElement field = driver.findElement(By.id("input-"+nameAttr));
			 String actualResult =field.getAttribute("value");
			 
			 if (actualResult.equals(ExpectedResult)) {
				 System.out.println("Trimmed ::"+ExpectedResult);
			 }else {
				 System.out.println("Not Trimmed ::"+ExpectedResult);
			 }
			 
		}
		// opening the Guerrilla browser .
		public static void openGuerillaBrowser() {
			driver.manage().window().maximize();
			driver.get(URL_GUERILLA_MAIL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
		// getting a unique email
		public static String getEmail() {
			openGuerillaBrowser();
			driver.findElement(By.id("use-alias")).click();
			email = driver.findElement(By.xpath("//span[@id='email-widget']")).getText();
			return email;
		}

		// Closing the Browser
		public static void quitBrowser() {
			driver.quit();
		}
		
		
	        public static void main(String[] args) {
	        getEmail();	
			initializeDriver();
			navigateToRegistrationPage();
			fillMandatoryFldsInRegisPage();
			
			validateTrim(driver, "firstname", "Vishnu");
			validateTrim(driver, "lastname", "kk");
			validateTrim(driver, "email", email);
			validateTrim(driver, "telephone", "1234567890");
			validateTrim(driver, "password", "vish123");
			validateTrim(driver, "confirm", "vish123");
			
			quitBrowser();
			}
		}
	

	


