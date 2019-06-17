package com.qa.seleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindCharTest {
	@FindBy(id = "firstname")
	WebElement inputName;

	@FindBy(id = "submitName")
	WebElement submitButton;
	@FindBy(className ="clear")
	WebElement clearButton;
	@FindBy(id="warningId")
	WebElement warning;
	WebDriver driver;

	public FindCharTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void findByName(String name) {
		inputName.sendKeys(name);
		submitButton.click();
	}
	public void enterValues(String name) {
		inputName.sendKeys(name);
	}
	public String checkValues() {
		return inputName.getAttribute("value");
	}
	public String getWarning() {
		return warning.getText();
	}
	public void clickClear() {
		clearButton.click();
	}
}
