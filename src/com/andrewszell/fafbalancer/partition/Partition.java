package com.andrewszell.fafbalancer.partition;

import com.andrewszell.fafbalancer.Team;

import java.util.ArrayList;
import java.util.List;


interface Partition {
    List<Team> partition();
}
