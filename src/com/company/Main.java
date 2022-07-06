package com.company;

import com.company.pathFinding.AStar;
import com.company.pathFinding.map.Map;
import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        AStar aStar = new AStar();
        Map creatMap = new Map(10,10,500,500);

        List<List<Spot>> map = creatMap.creatMap();

        for (List<Spot> spots : map) {
            System.out.print("| ");
            for (Spot spot : spots) {
                if (spot.getWall()) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" o ");
                }
            }
            System.out.println(" |");
        }

        Spot start = map.get(0).get(0);
        start.setPrevious(null);
        start.setWall(false);
        map.get(9).get(9).setWall(false);

        aStar.AStarPathFinder(map, map.get(0).get(0), new Position(9, 9), false);
    }
}
