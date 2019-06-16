package com.qa.SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTest {
	@FindBy(xpath = "//*[@id=\"firstname\"]")
	WebElement firstName;
	@FindBy(xpath = "//*[@id=\"surname\"]")
	WebElement surName;
	@FindBy(xpath = "//*[@id=\"class\"]")
	WebElement className;
	@FindBy(xpath = "//*[@id=\"gametype\"]")
	WebElement gameType;
	@FindBy(id = "outcome")
	WebElement success;
	

	WebDriver driver;

	public CreateTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void inputCharacter(String fName, String sName, String cName, String gName) {
		firstName.sendKeys(fName);
		surName.sendKeys(sName);
		className.sendKeys(cName);
		gameType.sendKeys(gName);
	}
	public String succesful() {
		return success.getText();
	}
}
