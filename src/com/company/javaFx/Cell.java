package com.company.javaFx;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Cell extends StackPane {

    int column;
    int row;

    public Cell(int column, int row) {

        this.column = column;
        this.row = row;

        getStyleClass().add("cell");


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

    public void showFNumber(int f) {
        Label label = new Label("f :" + String.valueOf(f));
        getChildren().add(label);
    }


    public void hoverUnhighlight() {
        getStyleClass().remove("cell-hover-highlight");
    }

    public String toString() {
        return this.column + "/" + this.row;
    }

}
