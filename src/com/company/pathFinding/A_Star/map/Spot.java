package com.company.pathFinding.A_Star.map;

import java.util.List;

public class Spot {

    // position of  spot
    private Position position;
    private int f;
    private int h;
    private int g;

    private List<Spot> neighbors;
    private Spot previous;

    public Spot(Position position) {
        this.position = position;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.previous = null;
    }

    public Spot() {
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }


    public Spot getPrevious() {
        return previous;
    }

    public void setPrevious(Spot previous) {
        this.previous = previous;
    }

    public List<Spot> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Spot> neighbors) {
        this.neighbors = neighbors;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }


    @Override
    public String toString() {
        return "position: " +  this.position.getX() + " : " + this.position.getY();
    }


}
