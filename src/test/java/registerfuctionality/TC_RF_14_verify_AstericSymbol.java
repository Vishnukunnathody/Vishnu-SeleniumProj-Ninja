package registerfuctionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_14_verify_AstericSymbol {

	final static String URL = "https://tutorialsninja.com/demo/";
	static ChromeDriver driver = new ChromeDriver();

	// Initializing the Browser
	public static void initializeDriver() {
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	// Navigating to the registration page
	public static void navigateToRegistrationPage() {
		WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myAccount.click();
		WebElement registerOption = driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
		registerOption.click();
	}

	// using javaScript Executer
	public static void verify_Asteric_Symbol() {
		List<WebElement> requiredFieldsCSS = driver
				.findElements(By.xpath("(//label[@class='col-sm-2 control-label'])[position()<last()]"));

		for (WebElement field : requiredFieldsCSS) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String scriptColor = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');";
			String scriptContent = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";
			String fieldText = field.getText();

			String color = (String) js.executeScript(scriptColor, field);
			String content = (String) js.executeScript(scriptContent, field);
			System.out.println("Color:: " + color + "  Asterisk:: " + content + "  Found for::" + fieldText);

			/*
			 * if ("* ".equals(content)&&"rgba(255, 0, 29, 1)".equals(color)) {
			 * System.out.println("Asterisk is Present and  Color Verified for ::"+fieldText
			 * ); }else { System.out.println("Asterisk is Not Present for ::"+fieldText); }
			 */
		}
	}

	public static void main(String[] args) {

		initializeDriver();
		navigateToRegistrationPage();
		verify_Asteric_Symbol();
		driver.quit();
	}

}
