package com.qa.SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterTest {
	@FindBy(id = "name")
	WebElement name;

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id = "submit")
	WebElement submitButton;

	WebDriver driver;

	public RegisterTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void submitName(String inputName) {
		name.sendKeys(inputName);
		submitButton.click();

	}
	public String checkName() {
		return username.getText();
	}
}
