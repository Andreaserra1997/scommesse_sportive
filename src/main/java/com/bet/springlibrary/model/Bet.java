package com.bet.springlibrary.model;

import jakarta.persistence.*;

@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String betType;
    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String type) {
        this.betType = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Bet() {
    }

    public Bet(Integer id, Event event, String type, Double amount) {
        this.id = id;
        this.event = event;
        this.betType = type;
        this.amount = amount;
    }
}
