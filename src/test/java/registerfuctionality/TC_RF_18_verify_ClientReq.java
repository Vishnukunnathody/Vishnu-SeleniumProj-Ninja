package registerfuctionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_18_verify_ClientReq {
 static ChromeDriver driver = new ChromeDriver();
 
 
 
 static String zeroChars =" ";
 static String oneChars ="A";
 static String threeChars ="ABC";
 static String fourChars ="ABCD";
 static String twentyChars ="ABCDEFGH10ABCDEFGH20";
 static String twentyOneChars ="ABCDEFGH10ABCDEFGHI21";
 static String thirtytwoChars ="ABCDEFGH10ABCDEFGH20ABCDEFGHIJ32" ;
 static String thirtyThreeChars ="ABCDEFGH10ABCDEFGH20ABCDEFGHIJK33";
 
	public static void main(String[] args) {
		initialize();
		navigateToRegistrationPage();
		verifyFieldDimensions(driver,"firstname",34,701);
		verifyMaxMinLength( driver,"firstname",zeroChars,oneChars,thirtytwoChars,thirtyThreeChars,
				                 "First Name must be between 1 and 32 characters!");
		verifyMaxMinLength( driver,"lastname",zeroChars,oneChars,thirtytwoChars,thirtyThreeChars,
	                             "last Name must be between 1 and 32 characters!");
		verifyMaxMinLength( driver,"telephone",oneChars,threeChars,thirtytwoChars,thirtyThreeChars,
                                 "Telephone must be between 3 and 32 characters!");
		verifyMaxMinLength( driver,"password",zeroChars,threeChars,twentyChars,twentyOneChars,
                                  "Password must be between 4 and 20 characters!");
	}
	
	public static void initialize() {
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.close();
	}


	public static void navigateToRegistrationPage() {
		try {
			WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
			myAccount.click();
			WebElement registerOption = driver.findElement(
					By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/child::li/a[text()='Register']"));
			registerOption.click();
		} catch (NoSuchElementException e) {
			System.err.println("Failed to navigate to the registration page: " + e.getMessage());
		}
	}

	public static void verifyFieldDimensions(ChromeDriver driver, String fieldId, int expectedHeight,
			int expectedWidth) {
		try {
			WebElement inputField = driver.findElement(By.id("input-" + fieldId));
			Dimension dim = inputField.getSize();
			int actualHeight = dim.getHeight();
			int actualWidth = dim.getWidth();
			System.out.println("Height: " + actualHeight + ", Width: " + actualWidth);

			if (expectedHeight == actualHeight && expectedWidth == actualWidth) {
				System.out.println("Height and Width are correct :: Test case passed");
			} else {
				System.out.println("Height and Width do not match :: Test case failed");
			}
		} catch (NoSuchElementException e) {
			System.err.println("Failed to verify field dimensions: " + e.getMessage());
		}
	}

	public static void verifyMaxMinLength(ChromeDriver driver, String field, String minMinus1Value, String minValue,
			String maxValue, String maxPlus1Value, String errorMessage) {
		try {
			String locator = "input-" + field;
			WebElement inputField = driver.findElement(By.id(locator));
			boolean validationPassed = true;

			// Test min - 1 value
			inputField.sendKeys(minMinus1Value);
			inputField.submit();
			if (!isErrorMessageDisplayed(driver, errorMessage)) {
				validationPassed = false;
			}
			driver.navigate().back();
			inputField = driver.findElement(By.id(locator));
			clearField(inputField);

			// Test min value
			inputField.sendKeys(minValue);
			inputField = driver.findElement(By.id(locator));
			inputField.submit();
			if (isErrorMessageDisplayed(driver, errorMessage)) {
				validationPassed = false;
			}
			driver.navigate().back();
			inputField = driver.findElement(By.id(locator));
			clearField(inputField);

			// Test max value
			inputField.sendKeys(maxValue);
			inputField = driver.findElement(By.id(locator));
			inputField.submit();
			if (isErrorMessageDisplayed(driver, errorMessage)) {
				validationPassed = false;
			}
			driver.navigate().back();
			inputField = driver.findElement(By.id(locator));
			clearField(inputField);

			// Test max + 1 value
			inputField.sendKeys(maxPlus1Value);
			inputField = driver.findElement(By.id(locator));
			inputField.submit();
			if (!isErrorMessageDisplayed(driver, errorMessage)) {
				validationPassed = false;
			}
			driver.navigate().back();
			inputField = driver.findElement(By.id(locator));
			clearField(inputField);

			if (!validationPassed) {
				System.out.println(field + " Max-Min validation failed");
			}else {
				System.out.println(field + "::  Max-Min validation passed");
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	private static boolean isErrorMessageDisplayed(ChromeDriver driver, String errorMessage) {
		try {
			WebElement errorMsg = driver.findElement(By.xpath("//div[text()='" + errorMessage + "']"));
			return errorMsg.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private static void clearField(WebElement inputField) {
		inputField.clear();
	}
}
