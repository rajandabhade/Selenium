package org.test.selenium.TestFramework;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	public void init() {		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rajan\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://www.tendable.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
	
	public void tearDown() {
		driver.close();
	}
	
	}
