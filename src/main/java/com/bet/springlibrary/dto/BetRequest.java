package com.bet.springlibrary.dto;

public class BetRequest {
    private Integer betId;

    private Integer eventId;
    private String betType;
    private Double amount;

    public Integer getBetId() {
        return betId;
    }

    public void setBetId(Integer betId) {
        this.betId = betId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BetRequest(Integer betId, Integer eventId, String betType, Double amount) {
        this.betId = betId;
        this.eventId = eventId;
        this.betType = betType;
        this.amount = amount;
    }
}
