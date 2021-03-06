package com.andrewszell.fafbalancer.maps;

import com.andrewszell.fafbalancer.maps.slot.SlotAssignment;
import com.andrewszell.fafbalancer.maps.slot.SlotMovement;
import com.andrewszell.fafbalancer.Team;

import java.util.List;

public interface GameMap {
    int getTeamBySlot(int slot);

    int getTeamCount();

    int getTeamPlayerCount();

    List<SlotMovement> getSlotMovements(List<SlotAssignment> slotAssignments);

    List<SlotAssignment> getSlotAssignments(List<Team> teamList);
}
