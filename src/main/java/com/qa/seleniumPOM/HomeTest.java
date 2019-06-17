package com.qa.seleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeTest {
	@FindBy(css = "#navbarSupportedContent > ul:nth-child(1) > li:nth-child(3) > a")
	WebElement create;

	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[1]/li[4]/a")
	WebElement find;
	@FindBy(xpath = "/html/body/nav/a/img")
	WebElement logo;

	@FindBy(xpath = "//*[@id=\"welcome\"]")
	WebElement user;
	
	Actions action;
	WebDriver driver;

	public HomeTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createCharacter(WebDriver driver) throws InterruptedException {
		action = new Actions(driver);
		action.moveToElement(create);
		Thread.sleep(500);
		action.click();
	}
	public void findCharacter() {
		find.click();
	}
	public String checkUser() {
		return user.getText();
	}
	public void checkImageLink() {
		logo.click();
	}
}