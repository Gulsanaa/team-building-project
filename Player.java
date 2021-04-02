package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Player extends Vertix {
    int row, col;
    Vertix[][] matrix;
    Digraph digraph;
    public Player(Vertix[][] matrix, int row, int col, Digraph digraph) {
        super(matrix[row][col].getLayoutX(), matrix[row][col].getLayoutY(), 25, Color.RED);
        this.row = row;
        this.col = col;
        this.matrix = matrix;
        this.digraph = digraph;
    }

    public void moveRight() {
        int row = this.row;
        int col = this.col + 1;
        move(row, col);
    }

    public void moveLeft() {
        int row = this.row;
        int col = this.col - 1;
        move(row, col);
    }

    public void moveUp() {
        int row = this.row - 1;
        int col = this.col;
        move(row, col);
    }

    public void moveDown() {
        int row = this.row + 1;
        int col = this.col ;
        move(row, col);
    }

    private void move(int row, int col) {
        if (row >= matrix.length || row < 0 || col >= matrix.length || col < 0)
            return;
        for (int w : digraph.adj(this.row * matrix.length + this.col)) {
            if (w == row * matrix.length + col) {
                setLayoutX(matrix[row][col].getLayoutX());
                setLayoutY(matrix[row][col].getLayoutY());
                this.row = row;
                this.col = col;
            }
        }
    }
}
