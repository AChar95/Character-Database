package com.qa.profiles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Users implements UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(unique = true)
	private String username;
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "character_id")
	Set<CharacterProfile> characters = new HashSet<CharacterProfile>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CharacterProfile> getCharacter() {
		return characters;
	}

	public Set<CharacterProfile> setCharacter(Set<CharacterProfile> userCharact) {
		characters.addAll(userCharact);
		return characters;
	}

	public int getId() {
		return id;
	}

}