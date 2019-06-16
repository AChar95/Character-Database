package com.qa.SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeTest {
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[1]/li[3]/a")
	WebElement create;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[1]/li[4]/a")
	WebElement find;

	@FindBy(xpath = "//*[@id=\"user\"]")
	WebElement user;

	WebDriver driver;

	public HomeTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createCharacter() {
		create.click();
	}
	public void findCharacter() {
		find.click();
	}
	public String checkUser() {
		return user.getText();
	}
}