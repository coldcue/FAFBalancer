package com.andrewszell.fafbalancer.maps;

import java.util.Arrays;
import java.util.List;

public class SentonsClutchGameMap implements GameMap {
    private final List<Integer> teams = Arrays.asList(
            1,
            2,

            1,
            2,

            1,
            2,

            1,
            2
    );

    @Override
    public int getTeamBySlot(int slot) {
        return teams.get(slot);
    }

    @Override
    public int getTeamCount() {
        return 2;
    }

    @Override
    public int getTeamPlayerCount() {
        return 4;
    }
}
