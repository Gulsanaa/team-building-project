package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class Game extends Application {
    final int WIDTH = 500;
    final int HEIGHT = 500;
    final int SIZE = 4;
    Vertix[][] matrix = new Vertix[SIZE][SIZE];
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File file = new File("src\\com\\company\\Vertices.txt");
        Scanner scanner = new Scanner(file);
        Digraph digraph = new Digraph(scanner);
        System.out.println(digraph);

        Pane pane = new Pane();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Vertix vertix = new Vertix(100 * j + 75, 100 * i + 75, 25, Color.WHITE, i * SIZE + j);
                pane.getChildren().add(vertix);
                matrix[i][j] = vertix;
            }
        }

        for (int i = 0; i < digraph.getNumberOfVertices(); i++) {
            for (int w : digraph.adj(i)) {
                Arrow arrow = Arrow.drawArrow(matrix[i / SIZE][i % SIZE], matrix[w / SIZE][w % SIZE]);
                pane.getChildren().add(arrow);
            }
        }

        Player player = new Player(matrix, 0,0, digraph);
        pane.getChildren().add(player);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT: player.moveRight(); break;
                case LEFT: player.moveLeft(); break;
                case UP: player.moveUp(); break;
                case DOWN: player.moveDown(); break;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
