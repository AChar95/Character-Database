package com.qa.seleniumTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.categories.CategoryOne;
import com.qa.seleniumPOM.CreatePage;
import com.qa.seleniumPOM.HomeTest;
import com.qa.seleniumPOM.LandingTest;
import com.qa.seleniumPOM.RegisterTest;

@Category(CategoryOne.class)
public class CreateTests {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Charles/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void registerUser() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("Kilo");

		} catch (NoSuchElementException e) {

		}
		RegisterTest register = new RegisterTest(driver);
		try {
			register.submitName("Terry");

		} catch (NoSuchElementException e) {

		}
		HomeTest home = new HomeTest(driver);
		Thread.sleep(1000);
		assertEquals("User Check failed", "Welcome Terry", home.checkUser());
	}

	@Test
	public void loginOnKnownUser() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(1000);
		assertEquals("Could not login", "http://localhost:8080/Character-Database-1.0/Home.html",
				driver.getCurrentUrl());
	}

	@Test
	public void testHomeButton() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {
		}
		HomeTest home = new HomeTest(driver);
		try {
			home.checkImageLink();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(1000);
		assertEquals("Check logo link", "http://localhost:8080/Character-Database-1.0/Home.html",
				driver.getCurrentUrl());
	}

	@Test
	public void testgoToCharPage() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {
		}
		HomeTest home = new HomeTest(driver);
		home.createCharacter(driver);
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/create.html");
		assertEquals("Not found characters page", "http://localhost:8080/Character-Database-1.0/create.html",
				driver.getCurrentUrl());
	}

	@Test
	public void testCreateCharacter() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		HomeTest home = new HomeTest(driver);
		home.createCharacter(driver);
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/create.html");
		CreatePage create = new CreatePage(driver);
		Thread.sleep(500);
		create.inputCharacter("Theren", "Vale", "Bard", "D&D");
		Thread.sleep(500);
		assertEquals("Couldn't create character", "You have successfully created your character", create.succesful());
	}

	@After
	public void tearDown() {
		driver.close();
	}
}