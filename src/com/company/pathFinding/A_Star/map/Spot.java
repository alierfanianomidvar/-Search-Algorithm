package com.company.pathFinding.A_Star.map;

import java.util.List;
import java.util.Random;

public class Spot {

    // position of  spot
    private Position position;
    private int f;
    private int h;
    private int g;

    private List<Spot> neighbors;
    private Spot previous;

    private Boolean wall;

    public Spot(Position position) {
        this.position = position;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.previous = null;
        if (new Random().nextInt(2) == 1) {
            if (new Random().nextInt(2) == 1) {
                this.wall = true;
            } else {
                this.wall = false;
            }
        } else {
            this.wall = false;
        }
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


    public Boolean getWall() {
        return wall;
    }

    public void setWall(Boolean wall) {
        this.wall = wall;
    }

    @Override
    public String toString() {
        return "position: " + this.position.getX() + " : " + this.position.getY();
    }


}
