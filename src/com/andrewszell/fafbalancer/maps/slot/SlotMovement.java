package com.andrewszell.fafbalancer.maps.slot;

import com.andrewszell.fafbalancer.maps.GameMap;

import java.util.ArrayList;
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

        for (SlotAssignment slotAssignment : slotAssignments) {
            SlotMovement newSlotMovement = SlotMovement.fromAssignment(slotAssignment);

            //If from equals to
            if (newSlotMovement.getFrom() == newSlotMovement.getTo()) {
                continue;
            }

            //Add unique movement
            boolean found = false;
            for (SlotMovement slotMovement : slotMovements) {
                if (slotMovement.equals(newSlotMovement)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                slotMovements.add(newSlotMovement);
            }
        }
        return slotMovements;
    }

    public static List<SlotMovement> generateSlotMovementsWithOnlyTeamPosition(List<SlotAssignment> slotAssignments, GameMap map) {
        List<SlotMovement> slotMovements = new ArrayList<>();

        for (SlotAssignment slotAssignment : slotAssignments) {
            SlotMovement newSlotMovement = SlotMovement.fromAssignment(slotAssignment);

            //If from equals to
            if (newSlotMovement.getFrom() == newSlotMovement.getTo()) {
                continue;
            }

            //Add unique movement
            boolean found = false;
            for (SlotMovement slotMovement : slotMovements) {
                if (slotMovement.equals(newSlotMovement)) {
                    found = true;
                    break;
                }
            }
            if (!found && !isInGoodTeam(slotAssignment, map)) {
                slotMovements.add(newSlotMovement);
            }
        }
        return slotMovements;
    }

    public static boolean isInGoodTeam(SlotAssignment slotAssignment, GameMap map) {
        return map.getTeamBySlot(slotAssignment.getSlot()) == map.getTeamBySlot(slotAssignment.getPlayer().getSlot());
    }

    private static SlotMovement fromAssignment(SlotAssignment slotAssignment) {
        return new SlotMovement(slotAssignment.getPlayer().getSlot(), slotAssignment.getSlot());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlotMovement slotMovement = (SlotMovement) o;

        if (from == slotMovement.to && to == slotMovement.from) return true;

        return from == slotMovement.from && to == slotMovement.to;
    }
}
