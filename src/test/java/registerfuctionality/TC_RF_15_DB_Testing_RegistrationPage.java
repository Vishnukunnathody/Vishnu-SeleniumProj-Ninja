package registerfuctionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_15_DB_Testing_RegistrationPage {
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
	// Creating dynamic email
		public static String generateEmail() {
			Date date = new Date();
			return "vish" + date.toString().replace(" ", "_").replace(":", "_") + "@mailinator.com";
		}
		
	public static void ConnectDB() throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename","user","pass");
		if (connection.isClosed()) {
			System.out.println("Not connected to the DataBase ::");
		}else {
			System.out.println("Successfully connected to the DataBase ::");
		}
		
		
	}
		
	public static void main(String[] args) {
		initializeDriver() ;
		navigateToRegistrationPage();
		fillMandatoryFldsInRegisPage();
		CheckPrivacyAndsubmitForm();
		
	}

}
