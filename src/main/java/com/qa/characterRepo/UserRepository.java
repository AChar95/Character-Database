package com.qa.characterRepo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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

	@Transactional(value = TxType.REQUIRED)
	public Users update(int id, Users newUser) {
		Users user = readUser(id);
		user.setUsername(newUser.getUsername());
		user.setName(newUser.getName());
		user.setCharacter(newUser.getCharacter());
		return user;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteUser(int id) {
		em.remove(readUser(id));
	}

}
