package com.andrewszell.fafbalancer;

import com.andrewszell.fafbalancer.maps.GameMap;
import com.andrewszell.fafbalancer.maps.GapOfRohan5V5GameMap;
import com.andrewszell.fafbalancer.maps.SentonsClutchGameMap;
import com.andrewszell.fafbalancer.maps.slot.SlotAssignment;
import com.andrewszell.fafbalancer.maps.slot.SlotMovement;
import com.andrewszell.fafbalancer.partition.Partitioner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        GameMap map;
        List<Player> players = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select map: [0:Senton's Clutch, 1:GapOfRohan5V5]");
        System.out.print("> ");
        switch (scanner.nextInt()) {
            case 0:
                map = new SentonsClutchGameMap();
                break;
            case 1:
                map = new GapOfRohan5V5GameMap();
                break;
            default:
                throw new Exception("Unknown map");
        }


        System.out.println("Please type in the ratings: ");
        for (int i = 0; i < map.getTeamCount() * map.getTeamPlayerCount(); i++) {
            System.out.print("> ");
            Player e = new Player(i, scanner.nextInt());
            players.add(e);
            System.out.println(e);
        }

        System.out.println("### Partition players in " + map.getClass().getSimpleName());

        Partitioner teamPartition = new Partitioner(players, map);
        List<Team> teamList = teamPartition.partition();
        teamList.forEach(System.out::println);

        System.out.println("### Getting slot assignments for " + map.getClass().getSimpleName());
        List<SlotAssignment> slotAssignments = map.getSlotAssignments(teamList);
        slotAssignments.forEach(System.out::println);

        System.out.println("### Getting slot movements for " + map.getClass().getSimpleName());
        List<SlotMovement> slotMovements = map.getSlotMovements(slotAssignments);
        slotMovements.forEach(System.out::println);
    }
}
