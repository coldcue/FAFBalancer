package com.andrewszell.fafbalancer.partition;

import com.andrewszell.fafbalancer.Player;
import com.andrewszell.fafbalancer.Team;
import com.andrewszell.fafbalancer.maps.GameMap;

import java.util.List;

public class Partitioner implements Partition {
    private final List<Player> players;
    private final GameMap gameMap;

    public Partitioner(List<Player> players, GameMap gameMap) {
        this.players = players;
        this.gameMap = gameMap;
    }

    public List<Team> partition() {
        System.out.println("Partitioning...");
        BruteForcePartition bruteForcePartition = new BruteForcePartition(players, gameMap);
        return bruteForcePartition.partition();
    }
}
