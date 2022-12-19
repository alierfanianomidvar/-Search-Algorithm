package com.company.pathFinding;

import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;

import java.util.ArrayList;
import java.util.List;

public class Dfs {

    // DFS does not necessarily yield the shortest paths in an undirected graph.
    // BFS would be the correct choice here.
    Spot endNode;
    int length = 0;
    int shortLength = Integer.MAX_VALUE;

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

    public void  recursiveDfs(
            Spot spot){

        length +=1;

        if(length > shortLength)
            return;

        if(PositionCheck(spot.getPosition(), this.endNode.getPosition())){
            shortLength = length;
            return;
        }

        spot.setVisited(true);

        for (Spot spotNeighbor : spot.getNeighbors()) {
            if(!spotNeighbor.getVisited() && !spotNeighbor.getWall()){
                spotNeighbor.setPrevious(spot);
                recursiveDfs(spotNeighbor);
            }

        }

        length -= 1;
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

    public List<Position> dfsPathFinder(
            Spot start,
            Spot end) {

        this.endNode = end;

        recursiveDfs(start);
        List<Position> positions = trace_route(end);

        return positions;

    }
}
