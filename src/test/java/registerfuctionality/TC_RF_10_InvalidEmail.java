package registerfuctionality;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_10_InvalidEmail {

	static String EmailErrMsg1 = "E-Mail Address does not appear to be valid!";
	static String EmailErrMsg2 = "Please include an '@' in the email address.";
	static String EmailErrMsg3 = "Please enter a part following '@'.";

	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) {

		initialiseBrowswer();
		clickRegisterOption();
		fillRegFormNoEmail();
		verify_Email_ErrMsg_infToolTip();
		verify_Email_ErrMsg();
		driver.quit();

	}

	// Initializing the browser 
	public static void initialiseBrowswer() {
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
// Click on the registration page 
	public static void clickRegisterOption() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
	}

	// Filling the form with  no Email
	public static void fillRegFormNoEmail() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
		WebElement fnameTextField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		fnameTextField.sendKeys("Arun");
		WebElement lnameTextField = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lnameTextField.sendKeys("Motoori");
		WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		TelephoneTextField.sendKeys("1234567890");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordTextField.sendKeys("12345");
		WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmPasswordTextField.sendKeys("12345");

	}
// Clicking on the Privacy and Continue 
	public static void ClickPrivacyAndContinue() {
		WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyCheckbxField.click();
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();

	}
// Verifying the Tool tip Error msg 
	public static void verify_Email_ErrMsg_infToolTip() {
		String[] values = { "amotoori", "amotoori@", };

		for (String val : values) {
			WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
			eMailTextField.sendKeys(val);
			ClickPrivacyAndContinue();
			String ErrMsg = eMailTextField.getAttribute("validationMessage");

			if (ErrMsg.equals(EmailErrMsg2 + " 'amotoori' is missing an '@'.")) {
				System.out.println("Test passed::");
			} else if (ErrMsg.equals(EmailErrMsg3 + " 'amotoori@' is incomplete.")) {
				System.out.println("Test passed::");
			} else {
				System.out.println("Test case Failed ::");
				System.out.println("Actual Error Message is >> " + ErrMsg);
			}
			eMailTextField.clear();
		}

	}
// Veryfing the Error Msg -Page level
	public static void verify_Email_ErrMsg() {

		List<String> erlist = new ArrayList<>();
		erlist.add(" ");
		erlist.add("amotoori@gmail");

		for (String erList : erlist) {
			WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
			eMailTextField.sendKeys(erList);
			ClickPrivacyAndContinue();
			WebElement ErrMsgText = driver
					.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']"));
			String ErrMSgStr = ErrMsgText.getText();

			if (ErrMSgStr.equals(EmailErrMsg1)) {
				System.out.println("Test case Passed ::");
			} else {
				System.out.println("Test case Failed  ::");
				System.out.println(EmailErrMsg1 + "Expected");
				System.out.println(ErrMSgStr + "Actual");

				eMailTextField.clear();

			}
		}
	}
}
