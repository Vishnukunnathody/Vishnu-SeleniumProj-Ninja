package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_003_RegisteringWithAllFields {
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		initialiseBrowser();
		registerWithAllFields();
		closeBrowser();
	}

	public static void initialiseBrowser() {
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public static void registerWithAllFields() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
		WebElement fnameTextField = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		fnameTextField.sendKeys("Vishnu");
		WebElement lnameTextField = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		lnameTextField.sendKeys("kk");
		WebElement eMailTextField = driver.findElement(By.xpath("//input[@name='email']"));
		eMailTextField.sendKeys(generateEmail());
		System.out.println(generateEmail());
		WebElement TelephoneTextField = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		TelephoneTextField.sendKeys("1234567890");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='input-password']"));
		passwordTextField.sendKeys("vish123");
		WebElement confirmPasswordTextField = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		confirmPasswordTextField.sendKeys("vish123");
		WebElement NewsletryesOption = driver.findElement(By.xpath("//label[normalize-space()='Yes']"));
		NewsletryesOption.click();
		WebElement NewsletrNoOption = driver.findElement(By.xpath("//label[normalize-space()='No']"));
		NewsletrNoOption.click();
		WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyCheckbxField.click();
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
		WebElement continuebtn2 = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
		continuebtn2.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static String generateEmail() {
		Date date = new Date();
		return "vish" + date.toString().replace(" ", "_").replace(":", "_") + "@mailinator.com";

	}

}
