package com.bet.springlibrary.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Odds {
    private Double team1Win;
    private Double team2Win;
    private Double draw;

    public Double getTeam1Win() {
        return team1Win;
    }

    public void setTeam1Win(Double team1Win) {
        this.team1Win = team1Win;
    }

    public Double getTeam2Win() {
        return team2Win;
    }

    public void setTeam2Win(Double team2Win) {
        this.team2Win = team2Win;
    }

    public Double getDraw() {
        return draw;
    }

    public void setDraw(Double draw) {
        this.draw = draw;
    }
}
