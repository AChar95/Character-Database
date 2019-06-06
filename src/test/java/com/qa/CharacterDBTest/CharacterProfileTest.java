package com.qa.CharacterDBTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.gameTypes.GameTypes;
import com.qa.profiles.CharacterProfile;

public class CharacterProfileTest {
	CharacterProfile character;
	
	@Before
	public void setUp() {
		character = new CharacterProfile();
	}

	@Test
	public void firstNametest() {
		String firstName = "Theren";
		character.setFirstName(firstName);
		String retrievedName = character.getFirstName();
		assertEquals("Error cannot retrieve name", firstName, retrievedName);
	}
	@Test
	public void surnameTest() {
		String surname = "Nilos";
		character.setSurname(surname);
		String retrievedSurname = character.getSurname();
		assertEquals("Error surname not set correctly", surname, retrievedSurname);	
	}
	@Test
	public void gameType() {
		String gameType = "Dungeons and Dragons";
		character.setGameType(gameType);
		String retrievedGame = character.getGameType();
		assertEquals("Error game type not set correctly", gameType, retrievedGame);
	}
	@Test
	public void classType() {
		String className = "Bard";
		character.setClassName(className);
		String retrievedClass = character.getClassName();
		assertEquals("Error game type not set correctly", className, retrievedClass);
	}
	@Test
	public void gameName() {
		GameTypes game = new GameTypes();
		String gameName = "Dungeons and Dragons";
		game.setGameName(gameName);
		String retrievedName = game.getGameName();
		assertEquals("Error game name not set", gameName, retrievedName);
	}
	@Test
	public void genreType() {
		GameTypes game = new GameTypes();
		String genreName = "Fantasy";
		game.setGenreName(genreName);
		String retrievedGenre = game.getGenreName();
		assertEquals("Error Game genre not set", genreName, retrievedGenre);
	}
	
	
	
	

}
