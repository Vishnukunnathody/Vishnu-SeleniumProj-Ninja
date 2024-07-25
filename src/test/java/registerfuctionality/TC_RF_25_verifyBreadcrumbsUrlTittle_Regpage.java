package registerfuctionality;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_RF_25_verifyBreadcrumbsUrlTittle_Regpage {

	public static void main(String[] args) {
		initialiseBrowswer();
		clickRegisterOption();
		Verify_breadCrumsTitleAndUrl();
		driver.close();
	}

	static ChromeDriver driver = new ChromeDriver();
	static String regPageUrl = "https://tutorialsninja.com/demo/index.php?route=account/register";
	static String pageTittle = "Register Account";

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

	public static void Verify_breadCrumsTitleAndUrl() {
		// Verifying the Text of the Bread crumbs
		Set<String> brdset = new HashSet<>();
		brdset.addAll(Arrays.asList(
				new String[] { "Currency", "123456789", "My Account", "Wish List (0)", "Shopping Cart", "Checkout" }));
		List<WebElement> breadCrumbs = driver.findElements(By.xpath("//span[@class='hidden-xs hidden-sm hidden-md']"));
		for (WebElement brdElmts : breadCrumbs) {
			String brdTxtStr = brdElmts.getText();
			if (brdElmts.isDisplayed() && brdset.contains(brdTxtStr) && isElementClickable(driver, brdElmts, 3)) {
				System.out.println("Element is Displayed ,Matched or Clickable For :: " + brdTxtStr);
			} else {
				System.out.println("Element is NOT  Displayed ,Matched or Clickable For :: " + brdTxtStr);
			}

		}
		if(driver.getCurrentUrl().equals(regPageUrl)&&driver.getTitle().equals(pageTittle)) {
			System.out.println("The page URL and Page title is correct ::");
		}else {
			System.out.println("The page URL and Page title is not correct ::");
			
		}

	}

	// User defined method to Check the element is clickable.If the Element is
	// clickable returns true or else false
	public static boolean isElementClickable(ChromeDriver driver, WebElement Element, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			return true;
		} catch (Exception e) {
			return false;

		}
	}

}
