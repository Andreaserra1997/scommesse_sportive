package com.bet.springlibrary.controller;

import com.bet.springlibrary.model.Event;
import com.bet.springlibrary.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvent() {
        return eventService.getAllEvent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveOrUpdateEvent(event);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody Event eventDetails) {
        Optional<Event> event = eventService.getEventById(id);
        if (event.isPresent()) {
            Event existEvent = event.get();
            existEvent.setName(eventDetails.getName());
            existEvent.setDate(eventDetails.getDate());
            existEvent.setOdds(eventDetails.getOdds());
            return ResponseEntity.ok(eventService.saveOrUpdateEvent(existEvent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
