package com.qa.characterRepo;

import java.util.List;

import com.qa.profiles.CharacterProfile;
import com.qa.profiles.Users;

public interface ProfileUserRepository {
	//C
		public Users createUser(Users user);
		//R
		public Users readUser(int id);
		public List<Users> readNameUser(String Name);
		public List<Users> readAllUsers();
		public List<CharacterProfile> readCharacters(int id);
		//U
		public Users update(int id, Users user);
		public Users updateCharacter(int id, CharacterProfile character);
		public Users removeCharacter(int id, CharacterProfile character);
		//D
		public void deleteUser(int id);
}
