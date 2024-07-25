package registerfuctionality;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_06_VerifyNoForNewsLetter {
	static ChromeDriver driver = new ChromeDriver();
	public static void main(String[] args) {
		initialize();
		RegisterFields();
		Close();
		
	}
	// initialize the browsers
	public static void initialize() {
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	// Enters all the fields with "No" for newsletter
	public static void RegisterFields() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
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
		
		clickNoNewsLtrOption();
		
		WebElement privacyPolicyCheckbxField = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyPolicyCheckbxField.click();
		WebElement continuebutn = driver.findElement(By.xpath("//input[@value='Continue']"));
		continuebutn.click();
        WebElement continuebtn2 = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
		continuebtn2.click();
		
	}
	// generate emails 
	public static String generateEmail() {
		Date date = new Date();
		return "vish"+date.toString().replace(" ", "_").replace(":", "_")+"@mailinator.com";
       }
	//Close the browsers
	public static void Close() {
		driver.close();
	}
	//clicks no to the news letter and do the verification
	public static void clickNoNewsLtrOption() {
		WebElement NewsletryesOption = driver.findElement(By.xpath("//label[normalize-space()='No']//input[@name='newsletter']"));
		NewsletryesOption.click();
		if (NewsletryesOption.isSelected()) {
			System.out.println("Test case passed::");
		}else {
			System.out.println("Test case Failed::");
		}
		
	}
	}

//


	

	


