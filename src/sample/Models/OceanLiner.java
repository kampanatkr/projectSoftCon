package sample.Models;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class OceanLiner extends Boat {

    public OceanLiner(int x, int y) {
        super(x, y);
        setHeight(100);
        setHeight(100);
    }

    @Override
    public void draw(){
        drawBody();
        drawTank();
        drawPipe();
    }

    public void drawBody(){
        GraphicsContext gc = getGraphicsContext2D();
        double[] xPoint = {0,15,85,100};
        double[] yPoint = {90,100,100,90};
        gc.setFill(Color.BLACK);
        gc.fillPolygon(xPoint,yPoint,4);
    }

    public void drawTank(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(30,85,60,5);
    }

    public void drawPipe(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillRect(40,78,5,7);
        gc.fillRect(50,78,5,7);
        gc.fillRect(60,78,5,7);
        gc.fillRect(70,78,5,7);
        gc.fillRect(80,78,5,7);
    }

    @Override
    public void move(int distance) {
        TranslateTransition ttBoat = new TranslateTransition(
                Duration.millis(10000), this);
        ttBoat.setFromX(this.getTranslateX());
        ttBoat.setToX(this.getTranslateY() + distance);
        ttBoat.play();
    }
}
