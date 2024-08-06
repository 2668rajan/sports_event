package com.sportsevent;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sportseventmanagement.SportsEventApplication;
import com.sportseventmanagement.dao.EventDao;
import com.sportseventmanagement.dao.SportsDao;
import com.sportseventmanagement.entity.Event;
import com.sportseventmanagement.entity.Sports;
import com.sportseventmanagement.service.SportsService;

@SpringBootTest(classes = SportsEventApplication.class)
class SportsEventApplicationTests {
	
	@Autowired
	private SportsDao repo;
	
	@Autowired
	private EventDao dao;
	
	@Autowired
	private SportsService service;

	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void setUp() {
		Sports sports = new Sports(1001L, 2L, "Chess", "Indor");
		repo.save(sports);
		Sports sports1 = new Sports(1002L, 22L, "Carrom", "Outdoor");
		repo.save(sports1);
		
		Event event = new Event(1l, new Date(2022, 9, 07, 0, 0, 0), "Winter Olympic", 4l, "Chess");
		dao.save(event);
	}
	
	@Test
	void getSports() {
		List<Sports> actualList = repo.findAll();
		assertThat(actualList).asList();
	}
	
	@Test
	void addSports() {
		Sports sports = new Sports(1001L, 22L, "Cricket", "Outdoor");
		repo.save(sports);
	}
	
	@Test
	void getSportBysportsName() {
		List<Sports> bysportsName = repo.findBysportsName("Carrom");
		assertThat(bysportsName).isNotEmpty();
	}
	
	@Test
	void sportsExists() {
		boolean existsBysportsName = repo.existsBysportsName("Carrom");
		assertThat(existsBysportsName).isTrue();
	}
	
	@Test
	void getEvents() {
		List<Event> actualList = dao.findAll();
		assertThat(actualList).asList();
	}
	
	@Test
	void addEvent() {
		Event event = new Event(1l, new Date(2022, 9, 07, 0, 0, 0), "Winter Olympic", 4l, "Chess");
		dao.save(event);
	}
	
	@Test
	void updateEvent() {
		Event event = new Event(1l, new Date(2022, 9, 07, 0, 0, 0), "Winter Olympic", 4l, "Cricket");
		dao.save(event);
	}
	
	@Test
	void deleteEvent() {
		dao.deleteById(1l);
	}
	
	@Test
	void getEventByeventName() {
		List<Event> byeventName = dao.findByeventName("Winter Olympic");
		assertThat(byeventName).isNotEmpty();
	}
	
	@Test
	void eventExists() {
		Optional<Event> actual = dao.findById(1l);
		assertThat(actual).isNotEmpty();
	}
	

}
