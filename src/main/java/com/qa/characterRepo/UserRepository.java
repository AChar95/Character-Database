package com.qa.characterRepo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.profiles.CharacterProfile;
import com.qa.profiles.Users;

@Transactional(value = TxType.SUPPORTS)
public class UserRepository implements ProfileUserRepository {

	@PersistenceContext(unitName = "myPu")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public Users createUser(Users user) {
		em.persist(user);
		return user;
	}

	public Users readUser(int id) {
		Users user = em.find(Users.class, id);
		return user;
	}

	public List<Users> readNameUser(String name) {
		TypedQuery<Users> tQ = em.createQuery("Select user from Users user WHERE username='" + name + "'", Users.class);
		System.out.println(tQ.toString());
		List<Users> userList = tQ.getResultList();
		return userList;
	}

	public List<Users> readAllUsers() {
		TypedQuery<Users> tQ = em.createQuery("Select user from Users user", Users.class);
		List<Users> userList = tQ.getResultList();
		return userList;
	}
	public List<CharacterProfile> readCharacters(int id) {
		TypedQuery<CharacterProfile> tQ = em.createQuery("Select charac from CharacterProfile Charac WHERE user_id=" + id, CharacterProfile.class);
		List<CharacterProfile> userCharList = tQ.getResultList();
		return userCharList;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Users update(int id, Users newUser) {
		Users user = readUser(id);
		user.setUsername(newUser.getUsername());
		user.setName(newUser.getName());
		return user;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Users updateCharacter(int id, CharacterProfile character) {
		Users user = readUser(id);
		user.addCharacter(character);
		return user;
	}
	@Transactional(value =TxType.REQUIRED)
	public Users removeCharacter(int id, CharacterProfile character) {
		Users user = readUser(id);
		user.removeCharacter(character);
		return user;
	}
	@Transactional(value = TxType.REQUIRED)
	public void deleteUser(int id) {
		em.remove(readUser(id));
	}

}
