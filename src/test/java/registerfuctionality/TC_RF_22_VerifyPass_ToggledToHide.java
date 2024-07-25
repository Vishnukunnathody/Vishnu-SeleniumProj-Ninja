package registerfuctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_22_VerifyPass_ToggledToHide {

	public static void main(String[] args) throws InterruptedException {
		initializeDriver();
		navigateToRegistrationPage();
		verifyPassAndConfirmPassToggledToHide();
		driver.quit();
		
	}
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
		// verifying the password and conform password fields.
		public static void verifyPassAndConfirmPassToggledToHide() throws InterruptedException {
			WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
			WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
			
			String Expectedpasstext = passwordTextField.getAttribute("type");
			String ExpectedConfirmPassText =confirmPasswordTextField.getAttribute("type");
			
			
			if ("password".equals(Expectedpasstext)&&"password".equals(ExpectedConfirmPassText)) {
				System.out.println("Test case passed : : password and Confirm password field Toggled to Hide.");
			}else {
				System.out.println("Test case Failed : : password and Confirm password field not Toggled to Hide.");
			}
			
		}


	}


