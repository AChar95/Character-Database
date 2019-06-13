package com.qa.profiles;

import java.util.Set;

public interface UserProfile {

	public String getUsername();

	public void setUsername(String username);

	public String getName();

	public void setName(String name);

	public Set<CharacterProfile> getCharacter();

	public Set<CharacterProfile> setCharacter(Set<CharacterProfile> character);

	public int getId();

}