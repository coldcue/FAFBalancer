package com.andrewszell.fafbalancer.maps.slot;


import com.andrewszell.fafbalancer.Player;

public class SlotAssignment {
    private int slot;
    private Player player;

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
}
