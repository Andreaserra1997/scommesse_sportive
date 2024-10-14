package com.bet.springlibrary.service;

import com.bet.springlibrary.model.Bet;
import com.bet.springlibrary.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    public List<Bet> getAllBet() {
        return betRepository.findAll();
    }

    public List<Bet> getBetByEventId(Integer eventId) {
        return betRepository.findByEventId(eventId);
    }

    public Optional<Bet> getBetById(Integer id) {
        return betRepository.findById(id);
    }

    public Bet saveBet(Bet bet) {
        return betRepository.save(bet);
    }

    public void deleteBet(Integer id) {
        betRepository.deleteById(id);
    }
}
