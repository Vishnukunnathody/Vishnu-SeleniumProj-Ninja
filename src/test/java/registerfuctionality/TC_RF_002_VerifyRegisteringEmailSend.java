package registerfuctionality;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_002_VerifyRegisteringEmailSend {

	final static String URL_GUERILLA_MAIL = "https://www.guerrillamail.com/inbox";
	final static String URL_TUTORIALNINJA = "https://tutorialsninja.com/demo/";
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {

		String email = getEmail();
		register();
		fillRegisterForm(email);
		privacyAndSubmit();
		verifyEmail();
		quitBrowser();
	}

// opening the Guerrilla browser .
	public static void openGuerillaBrowser() {
		driver.manage().window().maximize();
		driver.get(URL_GUERILLA_MAIL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

// opening the Ninja tutorial in a new tab
	public static void openTutorialNinjaBrowser() {
		driver.manage().window().maximize();
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.TAB);
		newWindow.get(URL_TUTORIALNINJA);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

// getting a unique email
	public static String getEmail() {
		// String parentWindowId = driver.getWindowHandle();
		openGuerillaBrowser();
		driver.findElement(By.id("use-alias")).click();
		String email = driver.findElement(By.xpath("//span[@id='email-widget']")).getText();
		return email;
	}

// clicking on the register button
	public static void register() {
		openTutorialNinjaBrowser();
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
	}

// filling the registration form.
	public static void fillRegisterForm(String email) {
		WebElement fnameTextField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		fnameTextField.sendKeys("Vishnu");
		WebElement lnameTextField = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lnameTextField.sendKeys("kk");
		WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
		eMailTextField.sendKeys(email);
		WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		TelephoneTextField.sendKeys("1234567890");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordTextField.sendKeys("vish123");
		WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmPasswordTextField.sendKeys("vish123");

	}

// clicking the privacy and Submitting the form
	public static void privacyAndSubmit() {
		WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyCheckbxField.click();
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
	}

// Quit the browser
	public static void quitBrowser() {
		driver.quit();
	}

//validating the email 
	public static void verifyEmail() {
		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {
			driver.switchTo().window(windowId);
			if (driver.getTitle().contains("Guerrilla Mail - Disposable Temporary E-Mail Address")) {
				// System.out.println(driver.getTitle());
				driver.navigate().refresh();
				String html = driver.getPageSource();
				// System.out.println(html);

				if (html.contains("Qafox.com")) {
					System.out.println(":: Test case passed");
				} else {
					System.out.println("::Test case not passed ");
				}
			}
		}

	}

}
