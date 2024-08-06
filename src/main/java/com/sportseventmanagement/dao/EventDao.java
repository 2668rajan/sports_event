package com.sportseventmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportseventmanagement.entity.Event;

public interface EventDao extends JpaRepository<Event, Long> {

	List<Event> findByeventName(String eventName);

}
