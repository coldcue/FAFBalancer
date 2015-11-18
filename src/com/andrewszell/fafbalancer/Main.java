package com.andrewszell.fafbalancer;

import com.andrewszell.fafbalancer.maps.GameMap;
import com.andrewszell.fafbalancer.maps.SentonsClutchGameMap;
import com.andrewszell.fafbalancer.maps.slot.SlotMovement;
import com.andrewszell.fafbalancer.partition.Partitioner;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameMap map = new SentonsClutchGameMap();

        List<Player> players = Arrays.asList(
                new Player(0, 500),
                new Player(1, 600),
                new Player(2, 1200),
                new Player(3, 900),
                new Player(4, 800),
                new Player(5, 200),
                new Player(6, 100),
                new Player(7, 1100)
        );

        System.out.println("### Partition players in " + map.getClass().getSimpleName());

        Partitioner teamPartition = new Partitioner(players, map);
        List<Team> teamList = teamPartition.partition();
        teamList.forEach(System.out::println);

        System.out.println("### Getting slot movements for " + map.getClass().getSimpleName());
        List<SlotMovement> slotMovements = map.getSlotMovements(teamList);
        slotMovements.forEach(System.out::println);
    }
}
