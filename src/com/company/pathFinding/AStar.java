package com.company.pathFinding;

import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class AStar {


    // Here we use Euclidean Distance to find heuristic
    private int heuristic(
            Position neighbor,
            Position current,
            Boolean allowDiagonals) {
        int heuristic = 0;
        if (allowDiagonals) {
            heuristic = (int) Point2D.distance(
                    neighbor.getX(),
                    neighbor.getY(),
                    current.getX(),
                    current.getY());
        } else {
            heuristic = Math.abs(neighbor.getX() - current.getX())
                    + Math.abs(neighbor.getY() - current.getY());
        }
        return heuristic;
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


    public List<Position> AStarPathFinder(
            List<List<Spot>> map,
            Spot start,
            Position end,
            Boolean allowDiagonals) {

        List<Spot> openSet = new ArrayList<Spot>();
        List<Spot> closedSet = new ArrayList<Spot>();
        List<Position> path = new ArrayList<>();
        //Position lastCheckedNode = start;

        // At first in our open set we only have our starting node.
        openSet.add(start);

        while (true) {
            if (!openSet.isEmpty()) {
                int winner = 0;

                for (int i = 0; i < openSet.size(); i++) {//Here we will choose the best node to choose for our next node.

                    Spot currentSpot = openSet.get(i);
                    Spot winnerSpot = openSet.get(winner);

                    if (currentSpot.getF() < winnerSpot.getF()) {
                        winner = i;
                    } else if (currentSpot.getF() == winnerSpot.getF()) { //We want the best node.
                        if (currentSpot.getG() > winnerSpot.getG()) {
                            winner = i;
                        }
                    }
                }

                Spot current = openSet.get(winner); //here we move to our new node(THE BEST NODE).
                //lastCheckedNode = current.getPosition();
                if (PositionCheck(current.getPosition(), end)) { //Check if our new node is the end or not.
                    System.out.println("Done !!");
                    Spot currentPosition = current;
                    path.add(current.getPosition());
                    while (currentPosition.getPrevious() != null) {
                        path.add(currentPosition.getPosition());
                        currentPosition = currentPosition.getPrevious();

                    }
                    path.add(start.getPosition());
                    for (List<Spot> spots : map) { // to print the map
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
                    return path;
                }

                openSet.remove(current);
                closedSet.add(current);

                for (Spot neighbor : current.getNeighbors()) { // loop on list of neighbors
                    if (!closedSet.contains(neighbor) && !neighbor.getWall()) {
                        int tempG = current.getG() + heuristic( //To find the better value of g.
                                neighbor.getPosition(),
                                current.getPosition(),
                                allowDiagonals);
                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        } else if (tempG >= neighbor.getF()) { // No, it's not a better path
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

            } else {
                System.out.println("no solution !!!");
                return new ArrayList<Position>();
            }
        }
    }
}
