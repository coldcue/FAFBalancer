import com.andrewszell.fafbalancer.Player;
import com.andrewszell.fafbalancer.Team;
import com.andrewszell.fafbalancer.maps.GameMap;
import com.andrewszell.fafbalancer.maps.GapOfRohan5V5GameMap;
import com.andrewszell.fafbalancer.maps.slot.SlotAssignment;
import com.andrewszell.fafbalancer.maps.slot.SlotMovement;
import com.andrewszell.fafbalancer.partition.Partitioner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andras on 11/18/15.
 */

public class GapOfRohan5v5Test {
    @Test
    public void testWithPlayers() {
        GameMap map = new GapOfRohan5V5GameMap();

        List<Player> players = new ArrayList<>();

        players.add(new Player(0, 1400));
        players.add(new Player(1, 400));
        players.add(new Player(2, 600));
        players.add(new Player(3, 800));
        players.add(new Player(4, 500));
        players.add(new Player(5, 300));
        players.add(new Player(6, 100));
        players.add(new Player(7, 700));
        players.add(new Player(8, 700));
        players.add(new Player(9, 1100));

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
