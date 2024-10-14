package com.bet.springlibrary.controller;

import com.bet.springlibrary.dto.BetRequest;
import com.bet.springlibrary.model.Bet;
import com.bet.springlibrary.model.Event;
import com.bet.springlibrary.repository.BetRepository;
import com.bet.springlibrary.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bets")
public class BetController {
    @Autowired
    private BetRepository betRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public ResponseEntity<List<BetRequest>> getBetsByEventId(@RequestParam Integer eventId) {
        List<Bet> bets = betRepository.findByEventId(eventId);

        List<BetRequest> betRequests = bets.stream()
                .map(bet -> new BetRequest(bet.getId(), bet.getEvent().getId(), bet.getBetType(), bet.getAmount()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(betRequests);
    }

    @PostMapping
    public ResponseEntity<Bet> createBet(@RequestBody BetRequest betRequest) {
        Optional<Event> eventOptional = eventRepository.findById(betRequest.getEventId());
        if (!eventOptional.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        Event event = eventOptional.get();

        Bet bet = new Bet();
        bet.setEvent(event);
        bet.setBetType(betRequest.getBetType());
        bet.setAmount(betRequest.getAmount());

        Bet savedBet = betRepository.save(bet);
        return ResponseEntity.ok(savedBet);
    }

    @DeleteMapping("/{betId}")
    public ResponseEntity<Void> deleteBet(@PathVariable Integer betId) {
        if (!betRepository.existsById(betId)) {
            return ResponseEntity.notFound().build();
        }
        betRepository.deleteById(betId);
        return ResponseEntity.noContent().build();
    }
}
