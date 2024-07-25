package registerfuctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_07_DifferntWaysToRegister {

	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		initialize();
		nav_RegAccPage_DiffOptions();
		VerifyRegDiffOptn();
		driver.quit();
	}

	// initialize the browser
	public static void initialize() {
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void nav_RegAccPage_DiffOptions() throws InterruptedException {
		
		//Clicking in My Account + Registration + My Account + Login + Continue Button + My Account + Login + Register Btn on the Right side 
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();

		WebElement registerOption = driver.findElement(
		By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
        registerOption.click();

		driver.navigate().back();    // Navigating back , Since getting an Stale element exception.
		myAccount.click();
		
		WebElement loginBtn = driver.findElement(
		By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
		loginBtn.click();

		WebElement continueBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		continueBtn.click();

		WebElement myAccount1 = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount1.click();

		WebElement loginBtn1 = driver.findElement(
		By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
		loginBtn1.click();

		WebElement register3 = driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']"));
		register3.click();
}
	// Verifying the test case 
	public static void VerifyRegDiffOptn() {
		
		WebElement regAccHeader = driver.findElement(By.xpath("//h1[text()='Register Account']"));
		String ExpectedregAccHeader = "Register Account";
		
		String ActualregAccStrHeader = regAccHeader.getText();
		
		if (ActualregAccStrHeader.contains(ExpectedregAccHeader)) {
			System.out.println("Testcase passed::");
		}else {
			System.out.println("Test case failed ::");
		}
	}

}












