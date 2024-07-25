package registerfuctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_20_Verify_PrivacyPolicyNotCheckedByDefault {

	public static void main(String[] args) {
		initializeDriver();
		navigateToRegistrationPage();
		verifyPrivacyPolicyWarnMsg();
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
	
	public static void verifyPrivacyPolicyWarnMsg() {
		WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
	    if(!privacyPolicyCheckbxField.isSelected()) {
	    	System.out.println("Test case passed::");
	    }else {
	    	System.out.println("Test case Failed::");
	    }
		
		
		
	}

}
