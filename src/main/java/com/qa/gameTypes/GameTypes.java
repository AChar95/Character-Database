package com.qa.gameTypes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameTypes implements Types {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String gameName;
	private String genreName;

	public void setGameName(String name) {
		this.gameName=name;
	}

	public String getGameName() {
		return this.gameName;
	}

	public void setGenreName(String genre) {
		this.genreName=genre;

	}

	public String getGenreName() {
		return this.genreName;
	}

}
