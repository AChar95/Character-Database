package com.qa.characterDBTest;

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

	@Test
	public void testSets() {
		CharacterProfile character = new CharacterProfile();
		character.setFirstName("Theren");
		character.setSurname("Voal");
		character.setGameType("D&D");
		character.setClassName("Warrior");
		user.setupChar();
		user.addCharacter(character);
		assertEquals("Can't add character to set", true, user.getCharacter(character));
	}

	@Test
	public void testRemoveSets() {
		CharacterProfile character = new CharacterProfile();
		character.setFirstName("Theren");
		character.setSurname("Voal");
		character.setGameType("D&D");
		character.setClassName("Warrior");
		user.setupChar();
		user.addCharacter(character);
		user.removeCharacter(character);
		assertEquals("Can't add character to set", false, user.getCharacter(character));
	}

	@Test
	public void setIdTest() {
		user.setId(42);
		assertEquals("Can't set id", 42, user.getId());
	}
}
