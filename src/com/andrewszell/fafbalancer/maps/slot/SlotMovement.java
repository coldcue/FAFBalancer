package com.andrewszell.fafbalancer.maps.slot;

import com.andrewszell.fafbalancer.maps.GameMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SlotMovement {
    private int from;
    private int to;

    public SlotMovement(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static List<SlotMovement> generateSlotMovements(List<SlotAssignment> slotAssignments) {
        List<SlotMovement> slotMovements = new ArrayList<>();
        List<SlotAssignment> assignments = new ArrayList<>(slotAssignments);
        Collections.sort(assignments, SlotAssignment.COMPARE_BY_PLAYER_SLOT);

        int i, j, minIndex;
        int size = assignments.size();

        for (i = 0; i < size - 1; ++i) {
            minIndex = i;                /* minimum keresése */
            for (j = i + 1; j < size; ++j)
                if (assignments.get(j).getSlot() < assignments.get(minIndex).getSlot())
                    minIndex = j;
            if (minIndex != i) {         /* csere? */
                Collections.swap(assignments, i, minIndex);
                slotMovements.add(new SlotMovement(i, minIndex));
            }
        }

        //Collections.reverse(slotMovements);

        return slotMovements;
    }

    public static boolean isInGoodTeam(SlotAssignment slotAssignment, GameMap map) {
        return map.getTeamBySlot(slotAssignment.getSlot()) == map.getTeamBySlot(slotAssignment.getPlayer().getSlot());
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Slot " + (from + 1) + " => " + (to + 1);
    }
}
