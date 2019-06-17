package com.qa.seleniumTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.categories.CategoryTwo;
import com.qa.seleniumPOM.FindCharTest;
import com.qa.seleniumPOM.HomeTest;
import com.qa.seleniumPOM.LandingTest;
import com.qa.seleniumPOM.UpdateTest;

@Category(CategoryTwo.class)
public class UpdateAndReadTest {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Charles/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void checkCharacter() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {
		}
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.enterValues("Theren");
		assertEquals("Can't find character name", "Theren", findChar.checkValues());
	}

	@Test
	public void updateChar() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		HomeTest home = new HomeTest(driver);
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		assertEquals("Not On update Page", "http://localhost:8080/Character-Database-1.0/update.html",
				driver.getCurrentUrl());
	}

	@Test
	public void readfirstName() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		UpdateTest update = new UpdateTest(driver);
		assertEquals("No name found", "Theren", update.checkfName());
	}
	@Test
	public void readsurName() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		UpdateTest update = new UpdateTest(driver);
		assertEquals("No name found", "Vale", update.checkSName());
	}
	@Test
	public void readClassName() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		UpdateTest update = new UpdateTest(driver);
		assertEquals("No name found", "Bard", update.checkClassName());
	}
	@Test
	public void readGameName() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		UpdateTest update = new UpdateTest(driver);
		update.checkfName();
		assertEquals("No name found", "D&D", update.checkGameType());
	}
	@Test
	public void updateClass() throws InterruptedException {
		driver.get("localhost:8080/Character-Database-1.0");
		LandingTest landing = new LandingTest(driver);
		try {
			landing.enterUsername("DarthVader");
		} catch (NoSuchElementException e) {

		}
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		FindCharTest findChar = new FindCharTest(driver);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		UpdateTest update = new UpdateTest(driver);
		update.changeProperty("Warrior");
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		findChar.findByName("Theren");
		Thread.sleep(5000);
		assertEquals("No name found", "Warrior", update.checkClassName());
		
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
