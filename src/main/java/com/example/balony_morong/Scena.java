package com.example.balony_morong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

    public class Scena extends Canvas {
    GraphicsContext gc;
    Scene scene;
    Group root;
    Timeline t;
    double pozX;

    int poc;

    public Scena(Scene scene, Group root) {
        this.scene = scene;
        this.root = root;
        gc = this.getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(400), (e) -> spawn()));
        t.setCycleCount(Animation.INDEFINITE);
        t.play();
    }
    // Spawn balónikov, velkosť celého canvasu a random pozicia
    public void spawn() {
        pozX = 75 + (Math.random() * (scene.getWidth() - 75));
        Balony b = new Balony(75, 200, pozX, scene.getHeight() - 95, root);
        root.getChildren().add(b);
        b.setOnMouseClicked(e -> b.prasknutie());
        }
    }

