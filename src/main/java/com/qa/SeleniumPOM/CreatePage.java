package com.qa.SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePage {
	@FindBy(id = "firstname")
	WebElement firstName;
	@FindBy(id = "surname")
	WebElement surName;
	@FindBy(id = "class")
	WebElement className;
	@FindBy(id = "gametype")
	WebElement gameType;
	@FindBy(className ="submit")
	WebElement button;
	@FindBy(id = "outcome")
	WebElement success;

	WebDriver driver;

	public CreatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void inputCharacter(String fName, String sName, String cName, String gName) {
		firstName.sendKeys(fName);
		surName.sendKeys(sName);
		className.sendKeys(cName);
		gameType.sendKeys(gName);
		button.click();
		
	}

	public String succesful() {
		return success.getText();
	}
}
