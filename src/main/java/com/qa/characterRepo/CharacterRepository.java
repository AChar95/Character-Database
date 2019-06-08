package com.qa.characterRepo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.profiles.CharacterProfile;

@Transactional(value = TxType.SUPPORTS)
public class CharacterRepository implements ProfileRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED)
	public CharacterProfile createChar(CharacterProfile character) {
		em.persist(character);
		return character;
	}

	public CharacterProfile readChar(int id) {
		CharacterProfile character = em.find(CharacterProfile.class, id);
		return character;
	}

	public List<CharacterProfile> readName(String firstName) {
		TypedQuery<CharacterProfile> tQ = em.createQuery(
				"Select char from CharacterProfile char where FIRSTNAME = '" + firstName + "'", CharacterProfile.class);
		List<CharacterProfile> charList = tQ.getResultList();
		return charList;
	}

	public List<CharacterProfile> getListFromStream(Stream<CharacterProfile> stream) {
		List<CharacterProfile> list = stream.collect(Collectors.toList());
		return list;
	}

	@Override
	public List<CharacterProfile> readAll() {
		TypedQuery<CharacterProfile> tQ = em.createQuery("Select char from CharacterProfile char",
				CharacterProfile.class);
		List<CharacterProfile> charList = tQ.getResultList();
		return charList;
	}

	@Transactional(value = TxType.REQUIRED)
	public CharacterProfile update(int id, CharacterProfile newChar) {
		CharacterProfile character = readChar(id);
		character.setFirstName(newChar.getFirstName());
		character.setSurname(newChar.getSurname());
		character.setClassName(newChar.getClassName());
		character.setGameType(newChar.getGameType());
		return character;
	}

	@Transactional(value = TxType.REQUIRED)
	public void deleteChar(int id) {
		em.remove(readChar(id));

	}
}
