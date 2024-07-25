package registerfuctionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_23_verifyAllLinks {

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
	public static void verifyAlllinks() {
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for(WebElement link:links ) {
			System.out.println(link.getText());
			//link.click();
			//driver.navigate().back();
		}
		
	}
	public static void main(String[] args) {
		initializeDriver();
		navigateToRegistrationPage();
		verifyAlllinks();
		driver.quit();
	}

}
