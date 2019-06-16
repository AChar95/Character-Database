package com.qa.seleniumTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRUDTests {
	WebDriver driver;
	
@Before
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:/Users/Charles/Desktop/chromedriver.exe");
	driver = new ChromeDriver();
}
@Test
public void registerUser() {
	
}
@After
public void tearDown() {
	driver.close();
}
}
