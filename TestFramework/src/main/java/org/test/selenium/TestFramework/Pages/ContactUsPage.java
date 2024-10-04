package org.test.selenium.TestFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.selenium.TestFramework.TestBase;

public class ContactUsPage extends TestBase {
	
	@FindBy (xpath = "//a[text()='Contact Us']")
	public	WebElement ContactUsButton;
	
	@FindBy (xpath = "//div[contains(text(),'Marketing')]/parent::div//button[text()='Contact']")
	public WebElement MarketingContactButton;
	
	@FindBy (xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@name='fullName']")
	public WebElement fullNameTextBox;
	
	@FindBy (xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@name='organisationName']")
	public WebElement organizationNameTextbox;
	
	@FindBy (xpath = "//a[text()='Request A Demo']")
	public WebElement RequestDemoButton;
	
	@FindBy (xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@name='cellPhone']")
	public WebElement phoneNumberTextbox;

	@FindBy (xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@name='email']")
	public WebElement emailTextbox;
	
	@FindBy (xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@name='consentAgreed']")
	public WebElement IagrreCheckbox;
	
	@FindBy (xpath = "//form[@id='contactMarketingPipedrive-163701']//button[@name='form_page_submit']")
	public WebElement SubmitButton;
	
	@FindBy (xpath = "//p[text()='Sorry, there was an error submitting the form. Please try again.']")
	public WebElement ErrorMessage;
	
//	@FindBy (xpath = "//a[text()='Request A Demo']")
//	public WebElement RequestDemoButton;
//	@FindBy (xpath = "//a[text()='Request A Demo']")
//	public WebElement RequestDemoButton;
//	@FindBy (xpath = "//a[text()='Request A Demo']")
//	public WebElement RequestDemoButton;
//	@FindBy (xpath = "//a[text()='Request A Demo']")
//	public WebElement RequestDemoButton;
//	@FindBy (xpath = "//a[text()='Request A Demo']")
//	public WebElement RequestDemoButton;
	

	// Initializing the Page Objects:
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
}
