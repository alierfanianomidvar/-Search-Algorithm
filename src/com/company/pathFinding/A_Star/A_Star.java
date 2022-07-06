package com.company.pathFinding.A_Star;

import com.company.pathFinding.A_Star.map.Position;
import com.company.pathFinding.A_Star.map.Spot;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class A_Star {

    private int heuristic(Position neighbor, Position current, Boolean allowDiagonals) {
        int newG;
        if (allowDiagonals) {
            newG = (int) Point2D.distance(
                    neighbor.getX(),
                    neighbor.getY(),
                    current.getX(),
                    current.getY());
        } else {
            newG = Math.abs(neighbor.getX() - current.getX())
                    + Math.abs(neighbor.getY() - current.getY());
        }
        return newG;
    }

    private boolean PositionCheck(
            Position current,
            Position end) {

        if (current.getX() == end.getX()
                && current.getY() == end.getY()) {
            return true;
        } else {
            return false;
        }
    }

    private int AStarPathFinder(
            List<List<Spot>> map,
            Spot start,
            Position end,
            Boolean allowDiagonals) {

        List<Spot> openSet = new ArrayList<Spot>();
        List<Spot> closedSet = new ArrayList<Spot>();
        //Position lastCheckedNode = start;
        openSet.add(start);

        while (true) {
            if (!openSet.isEmpty()) {
                int winner = 0;
                for (int i = 0; i < openSet.size(); i++) {

                    Spot currentSpot = openSet.get(i);
                    Spot winnerSpot = openSet.get(winner);

                    if (currentSpot.getF() < winnerSpot.getF()) {
                        winner = i;
                    } else if (currentSpot.getF() == winnerSpot.getF()) {
                        if (currentSpot.getG() > winnerSpot.getG()) {
                            winner = i;
                        }
                    }
                }
                Spot current = openSet.get(winner);
                //lastCheckedNode = current.getPosition();

                if (PositionCheck(current.getPosition(), end)) {
                    System.out.println("Done !!");
                    return 1;
                }

                openSet.remove(current);
                closedSet.add(current);

                List<Spot> neighbors = current.getNeighbors();

                for (Spot neighbor : neighbors) {
                    if (!closedSet.contains(neighbor)) {
                        var tempG = current.getG() + heuristic(
                                neighbor.getPosition(),
                                current.getPosition(),
                                allowDiagonals);

                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        } else if (tempG >= neighbor.getG()) {
                            // No, it's not a better path
                            continue;
                        }
                        neighbor.setG(tempG);
                        neighbor.setH(heuristic(
                                neighbor.getPosition(),
                                end,
                                allowDiagonals));
                        if (!allowDiagonals) {
                           // neighbor.vh = this.visualDist(neighbor, end);
                        }
                        neighbor.setF(neighbor.getG() + neighbor.getH());
                        neighbor.setPrevious(current);
                    }
                }

                return 0;

            } else {
                System.out.println("no solution !!!");
                return -1;
            }
        }
    }


}
