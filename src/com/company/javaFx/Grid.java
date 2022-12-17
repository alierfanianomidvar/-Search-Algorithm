package com.company.javaFx;

import com.company.pathFinding.map.Position;
import javafx.scene.layout.Pane;

public class Grid extends Pane {

    int rows;
    int columns;

    double width;
    double height;

    Cell[][] cells;

    public Grid(int columns, int rows, double width, double height) {

        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;

        cells = new Cell[rows][columns];

    }

    /**
     * Add cell to array and to the UI.
     */
    public void add(Cell cell, int column, int row) {

        cells[row][column] = cell;

        double w = width / columns;
        double h = height / rows;
        double x = w * column;
        double y = h * row;

        cell.setLayoutX(x);
        cell.setLayoutY(y);
        cell.setPrefWidth(w);
        cell.setPrefHeight(h);

        getChildren().add(cell);

    }

    public void showWall(Position position) {
        Cell cell = cells[position.getX()][position.getY()];
        cell.showWall();
    }

    public void showPath(Position position, int f, Boolean showNumber) {
        Cell cell = cells[position.getX()][position.getY()];
        cell.showPath(f, showNumber);
    }

    public void showFNumber(Position position, int f) {
        Cell cell = cells[position.getX()][position.getY()];
        cell.showFNumber(f);
    }


}
