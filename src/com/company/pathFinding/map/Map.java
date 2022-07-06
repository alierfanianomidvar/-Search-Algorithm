package com.company.pathFinding.map;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private int rows;
    private int columns;
    private double width;
    private double height;

    public Map(
            int rows,
            int columns,
            double width,
            double height) {
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
    }


    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public List<List<Spot>> creatMap() {

        List<List<Spot>> map = new ArrayList<>();
        List<Spot> mapSpot;
        List<Spot> neighbors;

        for (int i = 0; i < this.columns; i++) {
            mapSpot = new ArrayList<>();
            for (int j = 0; j < this.rows; j++) {
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

        map.get(0).get(1).setPrevious(null);
        map.get(0).get(1).setWall(false);
        map.get(6).get(3).setWall(false);

        return map;
    }


}
