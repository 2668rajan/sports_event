package com.sportseventmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportseventmanagement.dao.SportsDao;
import com.sportseventmanagement.entity.Event;
import com.sportseventmanagement.entity.Sports;

@Service
public class SportsServiceImpl implements SportsService{
	
	@Autowired
	private SportsDao sportsDao;
	
	List<Sports> List;
	
	public SportsServiceImpl() {
//		sportsList = new ArrayList<>();
//		sportsList.add(new Sports(1001L, 2L, "Chess", "Indor"));
//		sportsList.add(new Sports(1002L, 2L, "Carrom", "Indoor"));
//		sportsList.add(new Sports(1003L, 22L, "Cricket", "Outdoor"));
//		sportsList.add(new Sports(1004L, 22L, "Hockey", "Outdoor"));
				
	}

	@Override
	public List<Sports> getSports() {
		return sportsDao.findAll();
	}

	@Override
	public Sports addSports(Sports sport) {
		sportsDao.save(sport);
		return sport;
	}

	@Override
	public List<Sports> getSportBysportsName(String sportsName) {
		return sportsDao.findBysportsName(sportsName);
	}

	@Override
	public boolean sportsExists(String sportsName) {
		return sportsDao.existsBysportsName(sportsName);
	}

	

}
