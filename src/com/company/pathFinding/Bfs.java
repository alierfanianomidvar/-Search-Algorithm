package com.company.pathFinding;

import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// using Adjacency List
public class Bfs {

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

    public List<Position> BfsPathFinder(
            Spot start,
            Spot end) {

        Queue<Spot> queue = new LinkedList<Spot>();
        queue.add(start);
        start.setVisited(true);
        while (!queue.isEmpty()){
            Spot currentSpot = queue.poll();
            for (Spot currentSpotNeighbor : currentSpot.getNeighbors()) {
                if ( !currentSpotNeighbor.getVisited() && !currentSpotNeighbor.getWall()){
                    queue.add(currentSpotNeighbor);
                    currentSpotNeighbor.setVisited(true);
                    currentSpotNeighbor.setPrevious(currentSpot);
                    if (PositionCheck(currentSpotNeighbor.getPosition(), end.getPosition())){
                        queue.clear();
                        break;
                    }
                }
            }


        }
        return trace_route(end);
    }

    private List<Position> trace_route(Spot end){
        List<Position> path = new ArrayList<>();
        Spot traceSpot = end;
        path.add(end.getPosition());
        while (traceSpot.getPrevious() != null){
            traceSpot = traceSpot.getPrevious();
            path.add(traceSpot.getPosition());
        }

        return path;
    }

}
