package org.test.selenium.TestFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.selenium.TestFramework.TestBase;

public class HomePage extends TestBase {
	
	@FindBy (xpath = "//nav[@id=\"main-navigation-new\"]//li/a[text()=\"Our Story \"]")
	public	WebElement OurStory;
	
	@FindBy (xpath = "//nav[@id='main-navigation-new']//li/a[text()='Our Solution ']")
	public WebElement OurSolution;
	
	@FindBy (xpath = "//nav[@id='main-navigation-new']//li/a[text()='Our Story ']")
	public WebElement WhyTendable;
	
	@FindBy (xpath = "//a[text()='Request A Demo']")
	public WebElement RequestDemoButton;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
