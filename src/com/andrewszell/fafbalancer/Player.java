package com.andrewszell.fafbalancer;

import java.util.Comparator;

public class Player {
    private int slot;
    private int rating;

    public static final Comparator<Player> RATING_ORDER = new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
            return Integer.compare(o1.rating, o2.rating);
        }
    };

    public Player(int slot, int rating) {
        this.slot = slot;
        this.rating = rating;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Player " +
                "slot:" + (slot + 1) +
                ", rating: " + rating;
    }
}


