package org.test.selenium.TestFramework;

import org.test.selenium.TestFramework.Pages.ContactUsPage;
import org.test.selenium.TestFramework.Pages.HomePage;
import org.test.selenium.TestFramework.Utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Tendable extends TestBase{
	
	public SoftAssert softAssert;
	HomePage homePageObjects;
	ContactUsPage contactUsPage;
	TestUtils testUtils;
	
	@BeforeMethod
	public void beforeClass() {
		softAssert = new SoftAssert();
		homePageObjects = new HomePage();
		contactUsPage = new ContactUsPage();
		testUtils = new TestUtils();
	}
	
	@BeforeTest	
	public void beforeTest() {		
		init();	
	}
	
	@Test
	public void verifyHomePageMenuIcons() {	
		softAssert.assertEquals(homePageObjects.OurStory.isDisplayed(), true);
		softAssert.assertEquals(homePageObjects.OurSolution.isDisplayed(), true);
		softAssert.assertEquals(homePageObjects.WhyTendable.isDisplayed(), true);		
		softAssert.assertAll();
	}
	
	@Test	
	public void verifyRequestDemoButton() throws InterruptedException {
		softAssert.assertEquals(homePageObjects.RequestDemoButton.isDisplayed(), true);

		testUtils.clickOnElement(driver,homePageObjects.OurStory);
		softAssert.assertEquals(homePageObjects.RequestDemoButton.isDisplayed(), true);
		
		testUtils.clickOnElement(driver,homePageObjects.OurSolution);
		softAssert.assertEquals(homePageObjects.RequestDemoButton.isDisplayed(), true);
		
		testUtils.clickOnElement(driver,homePageObjects.WhyTendable);
		softAssert.assertEquals(homePageObjects.RequestDemoButton.isDisplayed(), true);
		
		softAssert.assertAll();
	}
	
	@Test
	public void verifyContactUsPage() throws InterruptedException {		
		testUtils.clickOnElement(driver, contactUsPage.ContactUsButton);
		
		testUtils.clickOnElement(driver,contactUsPage.MarketingContactButton);
		
		contactUsPage.fullNameTextBox.sendKeys("Rajan");
		contactUsPage.organizationNameTextbox.sendKeys("testOrg");
		contactUsPage.phoneNumberTextbox.sendKeys("463736");
		contactUsPage.emailTextbox.sendKeys("test@abc.com");
		
		testUtils.clickOnElement(driver,contactUsPage.IagrreCheckbox);
		testUtils.clickOnElement(driver,contactUsPage.SubmitButton);
		
		Assert.assertEquals(contactUsPage.ErrorMessage.isDisplayed(), true);
	}
	
	@AfterTest	
	public void afterTest() {
		tearDown();
	}	
}
