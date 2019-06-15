package com.qa.CharacterDBTest;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.characterRepo.ProfileUserRepository;
import com.qa.profiles.Users;

public class UserRepoTest {
	static Users user;
	@Inject
	ProfileUserRepository ProfileUser;

	@BeforeClass
	public static void preClassSetUp() throws Exception {
		user = new Users();
		user.setName("Terry");
		user.setUsername("Terminator");
	}

	@Before
	@Transactional(value = TxType.REQUIRED)
	public void setup() {
		ProfileUser.createUser(user);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Users foundUser = ProfileUser.readUser(user.getId());
		assertEquals(user, foundUser);
	}

}
