package registerfuctionality;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_11_InvalidPhoneNumber {
	
	static String  URL = "https://tutorialsninja.com/demo/";
	static String errMsg = "Telephone must be between 3 and 32 characters!";
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		initializeDriver();
		navigateToRegistrationPage();
		fillMandatoryFldsInRegisPage();
		verify_Telephone();
		driver.quit();
		
	}
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
			
			WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
			passwordTextField.sendKeys("vish123");
			WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
			confirmPasswordTextField.sendKeys("vish123");
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
		// Clicking on the Privacy Check box and Continue button to Submit the form
		public static void CheckPrivacyAndsubmitForm() {
			WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
			if(!privacyPolicyCheckbxField.isSelected()) {
				privacyPolicyCheckbxField.click();
			}
			WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
			continuebutn.click();
		}
		public static void verify_Telephone() {
			
			List<String> list = new ArrayList<>();
			list.addAll(Arrays.asList(new String [] {" ","11","ab"}));
			
			for(String tlist:list) {
				WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
				TelephoneTextField.sendKeys(tlist);
				CheckPrivacyAndsubmitForm();
				WebElement telErrElement = driver.findElement(By.xpath("//div[contains(text(),'Telephone must')]"));
				if (telErrElement.equals(errMsg)) {
					System.out.println("Error message displayed for ::"+tlist);
				}
				
			}
			
	//Note:: This is a Bug..					
			
			
			
		}

	}


