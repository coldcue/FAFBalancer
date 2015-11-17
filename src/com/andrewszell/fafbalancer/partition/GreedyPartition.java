package com.andrewszell.fafbalancer.partition;

import com.andrewszell.fafbalancer.Player;
import com.andrewszell.fafbalancer.Team;
import com.andrewszell.fafbalancer.maps.GameMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GreedyPartition implements Partition {
    private final List<Player> players;
    private final GameMap gameMap;

    public GreedyPartition(List<Player> players, GameMap gameMap) {
        this.players = Collections.unmodifiableList(players);
        this.gameMap = gameMap;
    }


    public List<Team> partition() {
        ArrayList<Team> teams = PartitionHelper.emptyTeamsList(gameMap);
        ArrayList<Player> playerList = new ArrayList<>(players);

        //Sort players in reverse order
        Collections.sort(playerList, Collections.reverseOrder(Player.RATING_ORDER));

        //Add players to the team with less rating sum
        playerList.forEach(player -> PartitionHelper.getTeamWithLowestRatingSum(teams).get().addPlayer(player));

        return teams;
    }


}
