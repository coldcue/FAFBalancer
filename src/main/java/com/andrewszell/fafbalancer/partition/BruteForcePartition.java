package com.andrewszell.fafbalancer.partition;

import com.andrewszell.fafbalancer.Player;
import com.andrewszell.fafbalancer.Team;
import com.andrewszell.fafbalancer.maps.GameMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BruteForcePartition implements Partition {
    private final List<Player> players;
    private final GameMap gameMap;

    public BruteForcePartition(List<Player> players, GameMap gameMap) {
        this.players = Collections.unmodifiableList(players);
        this.gameMap = gameMap;
    }


    public List<Team> partition() {
        List<Team> bestTeams = null;
        int lowestDifference = Integer.MAX_VALUE;

        Permute permute = new Permute(players.toArray());
        while (permute.hasNext()) {
            Object[] next = (Object[]) permute.next();
            List<Player> ppList = new ArrayList<>();
            Arrays.asList(next).forEach(o -> ppList.add((Player) o));

            List<Team> teams = putPlayersInTeams(ppList);
            int teamRatingDifference = PartitionHelper.getTeamRatingDifference(teams);
            if (teamRatingDifference < lowestDifference) {
                lowestDifference = teamRatingDifference;
                bestTeams = teams;
            }
            if (teamRatingDifference == 0) {
                break;
            }
        }

        return bestTeams;
    }

    private List<Team> putPlayersInTeams(List<Player> players) {
        ArrayList<Team> teams = PartitionHelper.emptyTeamsList(gameMap);

        int teamPlayerCount = 0;
        int teamId = 0;

        for (Player player : players) {
            teams.get(teamId).addPlayer(player);

            teamPlayerCount++;

            if (teamPlayerCount == gameMap.getTeamPlayerCount()) {
                teamPlayerCount = 0;
                teamId++;
            }
        }

        return teams;
    }

}
