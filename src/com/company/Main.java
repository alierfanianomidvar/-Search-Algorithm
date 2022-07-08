package com.company;

import com.company.pathFinding.AStar;
import com.company.pathFinding.Bfs;
import com.company.pathFinding.Dfs;
import com.company.pathFinding.map.Map;
import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        AStar aStar = new AStar();
        Bfs bfs = new Bfs();
        Dfs dfs = new Dfs();

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

        //aStar.AStarPathFinder(map, map.get(0).get(0), new Position(9, 9), false);
        //List<Position> path = bfs.BfsPathFinder(map.get(0).get(0), map.get(9).get(9));
        List<Position> path = dfs.dfsPathFinder(map.get(0).get(0), map.get(9).get(9));

        for (List<Spot> spots : map) {
            System.out.print("| ");
            for (Spot spot : spots) {
                if (spot.getWall()) {
                    System.out.print(" * ");
                } else if (path.contains(spot.getPosition())) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" o ");
                }
            }
            System.out.println(" |");
        }
    }
}
