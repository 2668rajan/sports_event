package com.sportseventmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventmanagement.entity.Sports;

public interface SportsDao extends JpaRepository<Sports, Long>{

	List<Sports> findBysportsName(String sportsName);

	boolean existsBysportsName(String sportsName);

	//List<Sports> findByName(String sportsName);

}
