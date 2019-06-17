package com.qa.profiles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CharacterProfile implements Profiles {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String firstName;
	private String surname;
	private String gameType;
	private String className;

	public void setFirstName(String firstName) {
		this.firstName = firstName;

	}

	public String getFirstName() {

		return this.firstName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return this.className;
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}

}
