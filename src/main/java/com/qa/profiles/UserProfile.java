package com.qa.profiles;

import java.util.Set;

public interface UserProfile {

	public String getUsername();

	public void setUsername(String username);

	public String getName();

	public void setName(String name);

	public Set<CharacterProfile> setupChar();

	public boolean getCharacter(CharacterProfile character);

	public Set<CharacterProfile> removeCharacter(CharacterProfile character);

	public Set<CharacterProfile> addCharacter(CharacterProfile character);

	public int getId();

	public void setId(int id);

}