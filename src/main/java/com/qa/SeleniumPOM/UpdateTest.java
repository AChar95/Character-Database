package com.qa.SeleniumPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateTest {
	@FindBy(xpath = "//*[@id=\"firstname\"]")
	WebElement firstName;
	@FindBy(xpath = "//*[@id=\"surname\"]")
	WebElement surName;
	@FindBy(xpath = "//*[@id=\"class\"]")
	WebElement className;
	@FindBy(xpath = "//*[@id=\"gametype\"]")
	WebElement gameType;
	@FindBy(xpath="//*[@id=\"deleteBut\"]")
	WebElement deleteButton;
	@FindBy(xpath = "//*[@id=\"deleteModal\"]/div/div/div[3]/button[2]")
	WebElement modalButton;
	
	
	WebDriver driver;

	public UpdateTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String checkfName() {
		return firstName.getText();
	}

	public String checkSName() {
		return surName.getText();
	}

	public String checkClassName() {
		return className.getText();
	}

	public String checkGameType() {
		return gameType.getText();
	}

	public void changeProperty(String clasName) {
		className.sendKeys(clasName);
	}
	public void deleteKey() {
		deleteButton.click();
		
		modalButton.click();
	}
}
