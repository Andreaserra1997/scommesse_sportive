package com.bet.springlibrary.repository;

import com.bet.springlibrary.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
