package com.company;

import com.company.pathFinding.AStar;
import com.company.pathFinding.map.Map;
import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class MapFx extends Application {

    boolean showHoverCursor = true;

    AStar aStar = new AStar();
    @Override
    public void start(Stage primaryStage) {
        try {
            StackPane root = new StackPane();
            // create grid
            Map mapCreator = new Map(
                    10,
                    10,
                    500,
                    500);

            Grid grid = new Grid(
                    mapCreator.getColumns(),
                    mapCreator.getRows(),
                    mapCreator.getWidth(),
                    mapCreator.getHeight());

            List<List<Spot>> map = mapCreator.creatMap();

            // fill grid
            for (List<Spot> spots : map) {
                for (Spot spot : spots) {
                    Position position = spot.getPosition();
                    Cell cell = new Cell(position.getX(), position.getY());
                    grid.add(cell, position.getX(), position.getY());
                }
            }
            for (List<Spot> spots : map) {
                for (Spot spot : spots) {
                    if(spot.getWall()){
                        grid.showWall(spot.getPosition());
                    }
                }
            }

            List<Position> positions = aStar.AStarPathFinder(map,
                    map.get(0).get(0),
                    new Position(9, 9),
                    true);

            for (Position position : positions) {
                grid.showPath(position);
            }

            root.getChildren().addAll(grid);

            // create scene and stage
            Scene scene = new Scene(
                    root,
                    mapCreator.getWidth(),
                    mapCreator.getHeight());

            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }


    private class Grid extends Pane {

        int rows;
        int columns;

        double width;
        double height;

        Cell[][] cells;

        public Grid( int columns, int rows, double width, double height) {

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
            System.out.println(position.getX() + " _ "+  position.getY() );
            Cell cell = cells[position.getX()][position.getY()];
            cell.showWall();
        }
        public void showPath(Position position) {
            System.out.println(position.getX() + " _ "+  position.getY() );
            Cell cell = cells[position.getX()][position.getY()];
            cell.showPath();
        }

    }

    private class Cell extends StackPane {

        int column;
        int row;

        public Cell(int column, int row) {

            this.column = column;
            this.row = row;

            getStyleClass().add("cell");

//          Label label = new Label(this.toString());
//
//          getChildren().add(label);

            setOpacity(0.9);
        }

        public void showPath() {
            // ensure the style is only once in the style list
            getStyleClass().remove("cell-highlight");
            // add style
            getStyleClass().add("cell-highlight");
        }


        public void showWall() {
            // ensure the style is only once in the style list
            getStyleClass().remove("cell-hover-highlight");
            // add style
            getStyleClass().add("cell-hover-highlight");
        }

        public void hoverUnhighlight() {
            getStyleClass().remove("cell-hover-highlight");
        }

        public String toString() {
            return this.column + "/" + this.row;
        }

    }

}
