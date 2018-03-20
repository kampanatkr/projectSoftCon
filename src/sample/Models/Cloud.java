package sample.Models;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Random;

public class Cloud extends Canvas implements Drawable,Moveable {
    Random random = new Random();
    private Color[] bodyColors = {
            Color.color(0.2431, 0.4902, 1)
            ,Color.color(0.7216,1,0.9333)
            ,Color.color(0.3647,0.9608,1)
            ,Color.color(0.4824, 0.5216, 0.8)
            ,Color.color(0.3255, 0.6902, 1)
            ,Color.color(0.1333, 0.4745, 0.5216)
            ,Color.color(0.9686, 1, 0.9373)
            ,Color.color(0.6431, 0.7529, 0.8902)
            ,Color.color(0.6863, 1, 0.8627)
            ,Color.color(0.1412, 0.3686, 0.451)};

    public Cloud (int x, int y){
        setTranslateX(x);
        setTranslateY(y);
        setHeight(50);
        setWidth(80);
    }

    public void drawBody(){
        GraphicsContext gc = getGraphicsContext2D();

        gc.setFill(bodyColors[random.nextInt(9)+0]);
        gc.fillOval(10,5,20,15);
        gc.fillOval(20,0,25,25);
        gc.fillOval(35,5,18,18);


    }
    @Override
    public void draw() {
        drawBody();


    }

    public void move(int distance){
        TranslateTransition ttCloud = new TranslateTransition(
                Duration.millis(5000), this);
        ttCloud.setFromX(this.getTranslateX());
        ttCloud.setToX(this.getTranslateY() + distance);
        ttCloud.setCycleCount(Animation.INDEFINITE);
        ttCloud.setAutoReverse(true);
        ttCloud.play();
    }

}
