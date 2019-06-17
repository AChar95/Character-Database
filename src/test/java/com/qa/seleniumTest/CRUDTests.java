package com.qa.seleniumTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.SeleniumPOM.FindCharTest;
import com.qa.SeleniumPOM.HomeTest;
import com.qa.SeleniumPOM.LandingTest;

public class CRUDTests {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Charles/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void checkChacter() throws InterruptedException {
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
		findChar.enterValues("Theren");
		assertEquals("Can't find character name", "Theren", findChar.checkValues());
	}

	@After
	public void tearDown() {
		driver.close();
	}
}
