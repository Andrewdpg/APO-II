package com.andrewdpg;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class PrimaryController implements Initializable {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    private int color;
    private Thread t;
    private int size = 50;
    private int x = 40;
    private int y = 40;
    private int step = 3;
    private boolean WPressed = false;
    private boolean SPressed = false;
    private boolean DPressed = false;
    private boolean APressed = false;
    private Wall wall = new Wall(150, 150, 250, 250);

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        color = 0;
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(this::onKeyPressed);
        canvas.setOnKeyReleased(this::onKeyReleased);
        gc = canvas.getGraphicsContext2D();
        draw();
        /*
         * gc.setFill(Color.RED);
         * gc.setLineWidth(2);
         * gc.setStroke(Color.RED);
         * gc.fillArc(50, 50, 80, 60, 35, 163, ArcType.OPEN);
         * gc.fillArc(118, 50, 80, 60, -20, 167, ArcType.OPEN);
         * gc.fillPolygon(new double[] { 52, 122, 196, 122 }, new double[] { 89, 160,
         * 90, 62.5 }, 4);
         */
    }

    public void onKeyPressed(KeyEvent key) {
        switch (key.getCode()) {
            case W:
                WPressed = true;
                break;
            case S:
                SPressed = true;
                break;
            case D:
                DPressed = true;
                break;
            case A:
                APressed = true;
                break;
            default:
                break;
        }
    }

    public void onKeyReleased(KeyEvent key) {
        switch (key.getCode()) {
            case W:
                WPressed = false;
                break;
            case S:
                SPressed = false;
                break;
            case D:
                DPressed = false;
                break;
            case A:
                APressed = false;
                break;
            default:
                break;
        }
    }

    public void draw() {
        t = new Thread(() -> {
            while (0 != 1) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(Color.WHITE);
                gc.fillRect(150, 150, 100, 100);
                gc.setFill(Color.RED);
                gc.fillOval(x, y, size, size);

                if (WPressed && y > 0 && !wall.coordInWall(x, y - step, size)) {
                    y -= step;
                }
                if (SPressed && y < canvas.getHeight() - size && !wall.coordInWall(x, y + step, size)) {
                    y += step;
                }
                if (DPressed && x < canvas.getWidth() - size && !wall.coordInWall(x + step, y, size)) {
                    x += step;
                }
                if (APressed && x > 0 && !wall.coordInWall(x - step, y, size)) {
                    x -= step;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }

            }
        });
        t.start();
    }

    public Color next() {
        switch (color) {
            case 0:
                color++;
                return Color.RED;
            case 1:
                color++;
                return Color.BLUE;
            case 2:
                color++;
                return Color.VIOLET;
            case 3:
                color = 0;
                return Color.GREEN;

            default:
                break;
        }
        return Color.RED;
    }
}