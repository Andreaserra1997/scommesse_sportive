package com.bet.springlibrary.repository;

import com.bet.springlibrary.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Integer> {
    List<Bet> findByEventId(Integer eventId);
}
