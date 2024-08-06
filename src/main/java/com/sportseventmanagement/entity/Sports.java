package com.sportseventmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Sports {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sportsId;
	//@NotNull(message = "Player name cannot be null")
	private Long noOfPlayers;
	//@NotNull(message = "Player name cannot be null")
	private String sportsName;
	//@NotNull(message = "Player name cannot be null")
	private String sportsType;

	public Sports(Long sportsId, Long noOfPlayers, String sportsName, String sportsType) {
		super();
		this.sportsId = sportsId;
		this.noOfPlayers = noOfPlayers;
		this.sportsName = sportsName;
		this.sportsType = sportsType;
	}

	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSportsId() {
		return sportsId;
	}

	public void setSportsId(Long sportsId) {
		this.sportsId = sportsId;
	}

	public Long getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(Long noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public String getSportsType() {
		return sportsType;
	}

	public void setSportsType(String sportsType) {
		this.sportsType = sportsType;
	}

	@Override
	public String toString() {
		return "Sports [sportsId=" + sportsId + ", noOfPlayers=" + noOfPlayers + ", sportsName=" + sportsName
				+ ", sportsType=" + sportsType + "]";
	}

}
