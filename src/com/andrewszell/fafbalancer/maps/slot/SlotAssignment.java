package com.andrewszell.fafbalancer.maps.slot;


import com.andrewszell.fafbalancer.Player;

import java.util.Comparator;

public class SlotAssignment {
    private int slot;
    private Player player;

    public static Comparator<SlotAssignment> COMPARE_BY_PLAYER_SLOT = new Comparator<SlotAssignment>() {
        @Override
        public int compare(SlotAssignment o1, SlotAssignment o2) {
            return Integer.compare(o1.player.getSlot(), o2.player.getSlot());
        }
    };

    public SlotAssignment(int slot, Player player) {
        this.slot = slot;
        this.player = player;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "SlotAssignment " +
                "slot:" + (slot + 1) +
                ", " + player;
    }
}
