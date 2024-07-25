package registerfuctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_09_ExistingAccountRegistration {

	final static String WARNING_MSG = "Warning: E-Mail Address is already registered!";
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		initialiseBrowser();
		register_Duplicate_Email();
		Verify_Duplicate_Email_ErrMsg();
		driver.close();
	}

	public static void initialiseBrowser() {
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public static void register_Duplicate_Email() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
		WebElement fnameTextField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		fnameTextField.sendKeys("Arun");
		WebElement lnameTextField = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lnameTextField.sendKeys("Motoori");
		WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
		eMailTextField.sendKeys("amotoori1@gmail.com");
		WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		TelephoneTextField.sendKeys("12345");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordTextField.sendKeys("12345");
		WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmPasswordTextField.sendKeys("12345");
		WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyCheckbxField.click();
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
	}

	public static void Verify_Duplicate_Email_ErrMsg() {
		WebElement expectedWarningMsg = driver
				.findElement(By.xpath("//*[text()='Warning: E-Mail Address is already registered!']"));
		String expectedWarningMsgstr = expectedWarningMsg.getText();
		System.out.println(expectedWarningMsg.getText());

		if (expectedWarningMsgstr.equalsIgnoreCase(WARNING_MSG)) {
			System.out.println("The Test case passed ::");
		} else {
			System.out.println("The Test not case passed");
		}

	}

}
