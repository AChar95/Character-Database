package com.qa.characterRepo;

import java.util.List;

import com.qa.profiles.Users;

public interface ProfileUserRepository {
	//C
		public Users createUser(Users user);
		//R
		public Users readUser(int id);
		public List<Users> readNameUser(String Name);
		public List<Users> readAllUsers();
		//U
		public Users update(int id, Users user);
		//D
		public void deleteUser(int id);
}
