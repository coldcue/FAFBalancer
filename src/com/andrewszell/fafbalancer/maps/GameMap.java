package com.andrewszell.fafbalancer.maps;

public interface GameMap {
    int getTeamBySlot(int slot);

    int getTeamCount();

    int getTeamPlayerCount();
}
