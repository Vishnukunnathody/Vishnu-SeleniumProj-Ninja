package registerfuctionality;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_RF_27_verifyAppInAllEnvironment {

	static WebDriver driver = null;
	static int noOfEnv = 0;

	public static void main(String[] args) {
		runInAllEnv();
		driver.quit();
	}

	// Navigating to the registration page
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

	// Closing the Browser
	public static void quitBrowser() {
		driver.quit();
	}

	// Creating dynamic email
	public static String generateEmail() {
		Date date = new Date();
		return "vish" + date.toString().replace(" ", "_").replace(":", "_") + "@mailinator.com";
	}

	public static void Verify_All_Env() {
		String driverName = driver.getClass().getSimpleName();
		if (driverName.equals("ChromeDriver")) {
			System.out.println("Running On ChromeDriver::");
		} else if (driverName.equals("EdgeDriver")) {
			System.out.println("Running On EdgeDriver::");
		} else if (driverName.equals("FirefoxDriver")) {
			System.out.println("Running On FirefoxDriver::");
		}

	}

// Running the Script in all the env and checking whether it is Running in all the Environment .
	public static void runInAllEnv() {
		List<String> envList = new ArrayList<>();
		envList.addAll(Arrays.asList(new String[] { "Chrome", "Edge", "Firefox" }));
		noOfEnv = envList.size();
		for (String env : envList) {
			if (env.equals("Chrome")) {
				driver = new ChromeDriver();
			} else if (env.equals("Edge")) {
				driver = new EdgeDriver();
			} else if (env.equals("Firefox")) {
				driver = new FirefoxDriver();
			}
			noOfEnv--;
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			Verify_All_Env();
			navigateToRegistrationPage();
			fillMandatoryFldsInRegisPage();
			CheckPrivacyAndsubmitForm();
			quitBrowser();
		}
		if (noOfEnv == 0) {
			System.out.println("Test case passed::");
		} else {
			System.out.println("Test case Failed ::");
		}

	}
}
