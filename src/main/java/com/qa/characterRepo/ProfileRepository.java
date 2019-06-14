package com.qa.characterRepo;

import java.util.List;

import com.qa.profiles.CharacterProfile;
import com.qa.profiles.Users;

public interface ProfileRepository {
	
	//C
	public CharacterProfile createChar(CharacterProfile character);
	//R
	public CharacterProfile readChar(int id);
	public List<CharacterProfile> readName(String firstName);
	public List<CharacterProfile> readAll();
	//U
	public CharacterProfile update(int id, CharacterProfile character);
	//D
	public void deleteChar(int id);

}
