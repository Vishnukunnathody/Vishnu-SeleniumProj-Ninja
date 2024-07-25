package registerfuctionality;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_004_ErrorMessagevalidation {

	static WebDriver driver = new ChromeDriver();
	final static String FN_ER_MSG = "First Name must be between 1 and 32 characters!";
	final static String LN_ER_MSG = "Last Name must be between 1 and 32 characters!";
	final static String EMail_ER_MSG = "E-Mail Address does not appear to be valid!";
	final static String TELE_ER_MSG = "Telephone must be between 3 and 32 characters!";
	final static String PASS_ER_MSG = "Password must be between 4 and 20 characters!";
	final static String PRIVACY_ER_MSG = "Warning: You must agree to the Privacy Policy!";
	
	public static void main(String[] args) {
		initialize();
		register();
		clickContinue();
		verifyErrorMsg();
		closeBrowser();
	}

	public static void initialize() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public static void register() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
	}

	public static void clickContinue() {
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
	}

	public static void verifyErrorMsg() {
		// Declaring all the Expected error messages in to a list .
		List<String> ExpectedErmsg = Arrays.asList(FN_ER_MSG, LN_ER_MSG, EMail_ER_MSG, TELE_ER_MSG, PASS_ER_MSG);

		// Retrieving all the actual error messages from the web page .
		List<WebElement> actualErMsg = driver.findElements(By.xpath("(//div[@class='text-danger'])"));
		int noOferrormsgs = actualErMsg.size();
		System.out.println("No of Error messages : " + noOferrormsgs);

		// validating the error messages .
		for (WebElement ActualerrorMsg : actualErMsg) {
			String ActualErrMsgStr = ActualerrorMsg.getText();
			if (ExpectedErmsg.contains(ActualErrMsgStr)) {
				System.out.println("Match found: " + ActualErrMsgStr);
			} else {
				System.out.println("No match found for :" + ActualErrMsgStr);
			}
		}
		// validating the Warning message ::
		WebElement ActualwarningMsg = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		int noOfwarningMsg = 1;
		String actualWarningMsgStr = ActualwarningMsg.getText();
		if (actualWarningMsgStr.equalsIgnoreCase(PRIVACY_ER_MSG)) {
			System.out.println("Match found:" + actualWarningMsgStr);
		}
	
// if number of the warning message and error message == number of constants the Test case pass or-else fails .
	if(!(ExpectedErmsg.size()==noOferrormsgs+noOfwarningMsg)) {
		System.out.println("Test case passed::");
	}else {
		System.out.println("Test case failed::");
		}
	}

	public static void closeBrowser() {
		driver.close();
	}
}
