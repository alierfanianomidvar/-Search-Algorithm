package com.company.pathFinding.map;

import com.company.pathFinding.AStar;

import java.util.ArrayList;
import java.util.List;

public class Map {


    public List<List<Spot>> creatMap() {
        List<List<Spot>> map = new ArrayList<>();
        List<Spot> mapSpot;
        List<Spot> neighbors;

        AStar a_star = new AStar();

        for (int i = 0; i < 10; i++) {
            mapSpot = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                mapSpot.add(new Spot(new Position(i, j)));
            }
            map.add(mapSpot);
        }

        for (int i = 0; i < 10; i++) {
            List<Spot> spots = map.get(i);

            for (int j = 0; j < 10; j++) {
                neighbors = new ArrayList<>();
                Spot spot = spots.get(j);
                if (i > 0) {
                    neighbors.add(map.get(i - 1).get(j));
                }
                if (i < 9) {
                    neighbors.add(map.get(i + 1).get(j));
                }
                if (j > 0) {
                    neighbors.add(map.get(i).get(j - 1));
                }
                if (j < 9) {
                    neighbors.add(map.get(i).get(j + 1));
                }
                if (i > 0 && j > 0) {
                    neighbors.add(map.get(i - 1).get(j - 1));
                }
                if (i < 9 && j > 0) {
                    neighbors.add(map.get(i + 1).get(j - 1));
                }
                if (i > 0 && j < 9) {
                    neighbors.add(map.get(i - 1).get(j + 1));
                }
                if (i < 9 && j < 9) {
                    neighbors.add(map.get(i + 1).get(j + 1));
                }
                spot.setNeighbors(neighbors);
            }
        }

        return map;
    }


}
