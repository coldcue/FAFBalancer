package com.andrewszell.fafbalancer.maps;

import com.andrewszell.fafbalancer.Team;
import com.andrewszell.fafbalancer.maps.slot.SlotAssignment;
import com.andrewszell.fafbalancer.maps.slot.SlotMovement;
import com.andrewszell.fafbalancer.partition.PartitionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GapOfRohan5V5GameMap implements GameMap {
    private final List<Integer> teams = Arrays.asList(
            2,
            2,
            2,
            2,
            2,

            1,
            1,
            1,
            1,
            1
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
        return 5;
    }

    @Override
    public List<SlotMovement> getSlotMovements(List<Team> teamList) {
        PartitionHelper.sortTeamPlayersByRating(teamList);

        List<SlotAssignment> slotAssignments = new ArrayList<>(getTeamCount() * getTeamPlayerCount());

        slotAssignments.add(new SlotAssignment(0, teamList.get(1).getPlayers().get(0)));
        slotAssignments.add(new SlotAssignment(1, teamList.get(1).getPlayers().get(1)));
        slotAssignments.add(new SlotAssignment(2, teamList.get(1).getPlayers().get(2)));
        slotAssignments.add(new SlotAssignment(3, teamList.get(1).getPlayers().get(3)));
        slotAssignments.add(new SlotAssignment(4, teamList.get(1).getPlayers().get(4)));

        slotAssignments.add(new SlotAssignment(5, teamList.get(0).getPlayers().get(0)));
        slotAssignments.add(new SlotAssignment(6, teamList.get(0).getPlayers().get(1)));
        slotAssignments.add(new SlotAssignment(7, teamList.get(0).getPlayers().get(2)));
        slotAssignments.add(new SlotAssignment(8, teamList.get(0).getPlayers().get(3)));
        slotAssignments.add(new SlotAssignment(9, teamList.get(0).getPlayers().get(4)));

        List<SlotMovement> slotMovements = SlotMovement.generateSlotMovementsWithOnlyTeamPosition(slotAssignments, this);

        return slotMovements;
    }
}
