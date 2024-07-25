package registerfuctionality;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_13_VerifyPlaceHolders {

	final static String URL = "https://tutorialsninja.com/demo/";
	static ChromeDriver driver = new ChromeDriver();
	static int noOfPlaceHolder ;
	

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
	
	// Using hash map to verify the place holders , and doing a verification
	public static void verify_Place_Holder() {
		List<WebElement> Placeholders = driver.findElements(By.xpath("//input[@class='form-control']"));
		 Map <String,String> hmap = new HashMap<>();
		 hmap.put("FN", "First Name");
			hmap.put("LN", "Last Name");
			hmap.put("Mail", "E-Mail");
			hmap.put("T-ph", "Telephone");
			hmap.put("Pass", "Password");
			hmap.put("PassConfrm", "Password Confirm");
		 
		 for(WebElement Placeholder:Placeholders ) {
			 String placeHolderText = Placeholder.getAttribute("placeholder");
			 if (hmap.containsValue(placeHolderText)&&hmap.equals(placeHolderText)) {
				 System.out.println("Test case passed::"+"The place Holder is Present for --> "+placeHolderText);
			 }else {
				 System.out.println("test case failed::"+"The place Holder is Not Present for--> "+ placeHolderText);
				 }
			 noOfPlaceHolder++;
		}
		 if (noOfPlaceHolder==hmap.size()) {
			 System.out.println("Total No of place holders is::"+noOfPlaceHolder);
			System.out.println("Note :: All Place Holders are available.");
		 }else {
			 System.out.println("Note :: Place Holders Missing.");
		 }
		 
	}

	public static void main(String[] args) {
		initializeDriver();
		navigateToRegistrationPage();
		verify_Place_Holder();
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
}
