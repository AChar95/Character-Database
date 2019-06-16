package com.qa.SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindCharTest {
	@FindBy(xpath = "//*[@id=\"firstname\"]")
	WebElement inputName;

	@FindBy(xpath = "/html/body/div[1]/div[6]/button")
	WebElement submitButton;
	
	WebDriver driver;

	public FindCharTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void findByName(String name) {
		inputName.sendKeys(name);
		submitButton.click();
	}
}
