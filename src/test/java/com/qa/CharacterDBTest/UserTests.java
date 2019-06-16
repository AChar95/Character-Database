package com.qa.CharacterDBTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.profiles.CharacterProfile;
import com.qa.profiles.UserProfile;
import com.qa.profiles.Users;

public class UserTests {
	UserProfile user;

	@Before
	public void setup() {
		user = new Users();
	}

	@Test
	public void testUserName() {
		String username = "Sarge";
		user.setUsername(username);
		
		assertEquals("Could not retrieve username", username, user.getUsername());
	}

	@Test
	public void testName() {
		user.setName("Terry");
		assertEquals("Could not retrieve name", "Terry", user.getName());
	}
	
}

