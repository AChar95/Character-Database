package com.qa.seleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateTest {
	@FindBy(id = "firstname")
	WebElement firstName;
	@FindBy(id = "surname")
	WebElement surName;
	@FindBy(id = "class")
	WebElement className;
	@FindBy(id = "gametype")
	WebElement gameType;
	@FindBy(xpath = "/html/body/div[3]/div/button[3]")
	WebElement submit;
	@FindBy(id = "deleteBut")
	WebElement deleteButton;
	@FindBy(id = "btn btn-primary")
	WebElement modalButton;

	WebDriver driver;

	public UpdateTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String checkfName() {
		return firstName.getAttribute("value");
	}

	public String checkSName() {
		return surName.getAttribute("value");
	}

	public String checkClassName() {
		return className.getAttribute("value");
	}

	public String checkGameType() {
		return gameType.getAttribute("value");
	}

	public void changeProperty(String clasName) {
		className.sendKeys(clasName);
		submit.click();

	}

	public void deleteKey() throws InterruptedException {
		deleteButton.click();
		Thread.sleep(2000);
		modalButton.click();
	}
}
