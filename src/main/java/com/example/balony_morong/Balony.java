package com.example.balony_morong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

    public class Balony extends Canvas {
    GraphicsContext gc;
    Group root;
    Timeline t;

    double nitka = 0 + (Math.random() * 75);
    double pom = (-1) + (Math.random() * 1);
    Color[] farby = {Color.RED, Color.BLUE, Color.YELLOW, Color.ORANGE,Color.FIREBRICK,
            Color.GREEN,Color.PURPLE,Color.VIOLET,Color.AQUA,Color.GOLD};
    //konštruktor
    public Balony(int w, int h, double x, double y, Group root) {
        super(w, h);
        this.root = root;
        setLayoutX(x);
        setLayoutY(y);
        gc = this.getGraphicsContext2D();
        //individuálna rýchlosť stúpania
        t = new Timeline(new KeyFrame(Duration.millis(20+(Math.random()*20)), (e) -> stupanie()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
        vykresli();
    }
    //nastavenie random farby
    public void vykresli() {
        int vyber_farieb = (int) (Math.random()*10);
        gc.setFill(farby[vyber_farieb]);
        gc.fillOval(0, 0, 75,100);
        gc.strokeLine(37.5,100,nitka,200);
    }
    //zmazanie
    public void prasknutie() {
        gc.clearRect(0, 0, getWidth(), getHeight());
    }
    //animácia stúpania
    public void stupanie() {
        if (getLayoutY() < 0) {
            gc.clearRect(0, 0, getWidth(), getHeight());
        } else {
            setLayoutX(getLayoutX() + pom);
            setLayoutY(getLayoutY() - 2);
        }
    }
}