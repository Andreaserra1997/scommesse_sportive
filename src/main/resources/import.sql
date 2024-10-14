INSERT INTO db_bet.event(draw, id, team1win, team2win, `date`, name) VALUES(2.80, 1, 1.50, 3.2, '2024-10-15 20:30:00', 'Juventus vs Milan');
INSERT INTO db_bet.event(draw, id, team1win, team2win, `date`, name) VALUES(3.52, 2, 1.21, 4.65, '2024-10-16 18:00:00', 'Inter vs Napoli');
INSERT INTO db_bet.bet(amount, event_id, id, `bet_type`) VALUES(10, 1, 1, 'team1win');
INSERT INTO db_bet.bet(amount, event_id, id, `bet_type`) VALUES(20, 2, 2, 'draw');