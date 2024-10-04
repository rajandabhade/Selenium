package org.test.selenium.TestFramework.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.test.selenium.TestFramework.TestBase;

public class TestUtils{
	
	public void clickOnElement(WebDriver driver, WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		scrollToElement(driver, element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();		
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
//		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
//		jsExec.executeScript("arguments[0].scrollIntoView(true);", element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		jsExec.executeScript("window.scrollBy(0,250)");
	}
}
