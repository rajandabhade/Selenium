package org.test.selenium.TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tendable extends TestBase{
	
	public SoftAssert softAssert; 
	
	public void beforeClass() {
		softAssert = new SoftAssert();
	}
	
	@BeforeTest	
	public void beforeTest() {		
		init();	
	}
	
	@Test
	public void homePageTests(){	
		WebElement OurStory = driver.findElement(By.xpath("//nav[@id=\"main-navigation-new\"]//li/a[text()=\"Our Story \"]"));
		WebElement OurSolution = driver.findElement(By.xpath("//nav[@id=\"main-navigation-new\"]//li/a[text()=\"Our Solution \"]"));
		WebElement WhyTendable = driver.findElement(By.xpath("//nav[@id=\"main-navigation-new\"]//li/a[text()=\"Why Tendable? \"]"));
		
		softAssert.assertEquals(OurStory.isDisplayed(), true);
		softAssert.assertEquals(OurSolution.isDisplayed(), true);
		softAssert.assertEquals(WhyTendable.isDisplayed(), true);		
		softAssert.assertAll();
	}
	
	@Test	
	public void verifyRequestDemoButton() {
		WebElement RequestDemoButton = driver.findElement(By.xpath("//a[text()=\"Request A Demo\"]"));		
		softAssert.assertEquals(RequestDemoButton.isDisplayed(), true);
//		
//		WebElement OurStory = driver.findElement(By.xpath("//nav[@id=\"main-navigation-new\"]//li/a[text()=\"Our Story \"]"));
//		OurStory.click();
//		softAssert.assertEquals(RequestDemoButton.isDisplayed(), true);
//		
//		WebElement WhyTendable = driver.findElement(By.xpath("//nav[@id=\"main-navigation-new\"]//li/a[text()=\"Why Tendable? \"]"));
//		WhyTendable.click();
//		softAssert.assertEquals(RequestDemoButton.isDisplayed(), true);
	}
	
	@Test
	public void verifyContactUsPage() throws InterruptedException {
		
		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement ContactUsButton = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		ContactUsButton.click();
		
		WebElement MarketingContactButton = driver.findElement(By.xpath("//div[contains(text(),'Marketing')]/parent::div//button[text()='Contact']"));		
		jsExec.executeScript("window.scrollBy(0,300)");
		wait.until(ExpectedConditions.elementToBeClickable(MarketingContactButton));
		Thread.sleep(3000);
		MarketingContactButton.click();
		
		WebElement fullNameTextBox = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@name='fullName']"));
		WebElement organizationNameTextbox = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@name='organisationName']"));
		WebElement 	phoneNumberTextbox = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@name='cellPhone']"));
		WebElement emailTextbox = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@name='email']"));
		WebElement IagrreCheckbox = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@name='consentAgreed']"));
		WebElement SubmitButton = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//button[@name='form_page_submit']"));
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(fullNameTextBox));
		fullNameTextBox.sendKeys("Rajan");
		organizationNameTextbox.sendKeys("testOrg");
		phoneNumberTextbox.sendKeys("463736");
		emailTextbox.sendKeys("test@abc.com");		
		
		jsExec.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(IagrreCheckbox));
		IagrreCheckbox.click();
		SubmitButton.click();
		
		WebElement ErrorMessage = driver.findElement(By.xpath("//p[text()='Sorry, there was an error submitting the form. Please try again.']"));
		Assert.assertEquals(ErrorMessage.isDisplayed(), true);
	}
	
	@AfterTest	
	public void afterTest() {
		tearDown();
	}	
}
