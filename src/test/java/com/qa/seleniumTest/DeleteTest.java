package com.qa.seleniumTest;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.SeleniumPOM.FindCharTest;
import com.qa.SeleniumPOM.LandingTest;
import com.qa.SeleniumPOM.UpdateTest;

public class DeleteTest {
	WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Charles/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void deleteCharacter() throws InterruptedException {
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
		update.deleteKey();
		driver.navigate().to("http://localhost:8080/Character-Database-1.0/search.html");
		Thread.sleep(1000);
		findChar.findByName("Theren");
		assertEquals("Didn't delete", "You have not inserted a correct name", findChar.getWarning());
	}
}
