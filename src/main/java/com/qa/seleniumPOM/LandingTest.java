package com.qa.seleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingTest {
	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "submit")
	WebElement submitButton;

	WebDriver driver;

	public LandingTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String usersname) {
		username.sendKeys(usersname);
		submitButton.click();
	}
}
