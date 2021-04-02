package com.company;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Vertix extends StackPane {
    int number;

    public Vertix(double centerX, double centerY, double radius, Paint fill, int number) {
        Circle circle = new Circle(radius, fill);
        this.number = number;
        circle.setStroke(Color.BLACK);
        Text text = new Text(number + "");
        getChildren().addAll(circle, text);
        setLayoutX(centerX);
        setLayoutY(centerY);
    }

    public Vertix(double centerX, double centerY, double radius, Paint fill) {
        Circle circle = new Circle(radius, fill);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle);
        setLayoutX(centerX);
        setLayoutY(centerY);
    }
}
