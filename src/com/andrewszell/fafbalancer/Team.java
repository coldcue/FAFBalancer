package com.andrewszell.fafbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andras on 11/17/15.
 */
public class Team {
    private int id;
    private ArrayList<Player> players;

    public Team(int id) {
        this.id = id;
        this.players = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getRatingSum() {
        return players.stream().mapToInt(Player::getRating).sum();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("com.andrewszell.fafbalancer.Team " + id + " [" + getRatingSum() + "]");
        players.forEach(player -> s.append(System.lineSeparator()).append(player.toString()));
        return s.toString();
    }
}
