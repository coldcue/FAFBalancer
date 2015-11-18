package com.andrewszell.fafbalancer.maps.slot;

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
        return "Slot " + from + " => " + to;
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
