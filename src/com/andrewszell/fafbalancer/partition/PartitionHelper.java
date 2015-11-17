package com.andrewszell.fafbalancer.partition;

import com.andrewszell.fafbalancer.Team;
import com.andrewszell.fafbalancer.maps.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PartitionHelper {
    public static Optional<Team> getTeamWithLowestRatingSum(ArrayList<Team> teams) {
        return teams.stream().min((o1, o2) -> Integer.compare(o1.getRatingSum(), o2.getRatingSum()));
    }

    public static boolean isTeamsEven(List<Team> teams) {
        int sum = teams.get(0).getRatingSum();

        for (Team team : teams) {
            if (team.getRatingSum() != sum) {
                return false;
            }
        }

        return true;
    }

    public static int getTeamRatingDifference(List<Team> teams) {
        int sum = teams.get(0).getRatingSum();
        int difference = 0;

        for (Team team : teams) {
            difference += Math.abs(sum - team.getRatingSum());
        }

        return difference;
    }

    public static ArrayList<Team> emptyTeamsList(GameMap gameMap) {
        int teamCount = gameMap.getTeamCount();

        ArrayList<Team> result = new ArrayList<>(teamCount);
        for (int i = 0; i < teamCount; i++) {
            result.add(new Team(i));
        }
        return result;
    }
}
