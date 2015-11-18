package com.andrewszell.fafbalancer;

import com.andrewszell.fafbalancer.maps.GameMap;
import com.andrewszell.fafbalancer.maps.GapOfRohan5V5GameMap;
import com.andrewszell.fafbalancer.maps.slot.SlotMovement;
import com.andrewszell.fafbalancer.partition.Partitioner;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameMap map = new GapOfRohan5V5GameMap();

        List<Player> players = Arrays.asList(
                new Player(0, 500),
                new Player(1, 800),
                new Player(2, 100),
                new Player(3, 1600),
                new Player(4, 300),
                new Player(5, 700),
                new Player(6, 400),
                new Player(7, 800),
                new Player(8, 400),
                new Player(9, 1000)
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
