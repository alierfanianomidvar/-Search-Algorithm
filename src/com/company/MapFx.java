package com.company;

import com.company.javaFx.Cell;
import com.company.javaFx.Grid;
import com.company.pathFinding.AStar;
import com.company.pathFinding.map.Map;
import com.company.pathFinding.map.Position;
import com.company.pathFinding.map.Spot;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class MapFx extends Application {

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






}
