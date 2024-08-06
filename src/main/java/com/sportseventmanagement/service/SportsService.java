package com.sportseventmanagement.service;

import java.util.List;

import com.sportseventmanagement.entity.Sports;

public interface SportsService {

	List<Sports> getSports();

	Sports addSports(Sports sport);

	List<Sports> getSportBysportsName(String sportsName);

	boolean sportsExists(String sportsName);

	//List<Sports> getSportByName(String sportsName);


	
}
