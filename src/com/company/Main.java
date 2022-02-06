package com.company;

import com.company.pathFinding.A_Star.AStar;
import com.company.pathFinding.A_Star.map.Position;
import com.company.pathFinding.A_Star.map.Spot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
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

        //System.out.println(Arrays.toString(map.get(2).toArray()));

        for (List<Spot> spots : map) {
            for (Spot spot : spots) {
                System.out.println(spot.toString());
            }
        }

        for (int i = 0; i < 10; i++) {
            List<Spot> spots = map.get(i);

            for (int j = 0; j < 10; j++) {
                neighbors = new ArrayList<>();
                Spot spot = spots.get(j);
                if( i > 0){
                    neighbors.add(map.get(i-1).get(j));
                }
                if( i < 9){
                    neighbors.add(map.get(i+1).get(j));
                }
                if( j > 0){
                    neighbors.add(map.get(i).get(j-1));
                }
                if( j < 9){
                    neighbors.add(map.get(i).get(j+1));
                }
                spot.setNeighbors(neighbors);
            }
        }
        map.get(0).get(0).setPrevious(null);
        map.get(9).get(9).setWall(false);
        map.get(0).get(0).setWall(false);
        for (List<Spot> spots : map) {
            System.out.print("| ");
            for (Spot spot : spots) {
                if(spot.getWall()){
                    System.out.print(" * ");
                } else {
                    System.out.print(" o ");
                }
            }
            System.out.println(" |");
        }
        a_star.AStarPathFinder(map,map.get(0).get(0),new Position(9,9),false);
    }
}
