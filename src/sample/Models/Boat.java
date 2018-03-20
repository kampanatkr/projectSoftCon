package sample.Models;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import static javafx.scene.shape.ArcType.CHORD;

public class Boat extends Canvas implements Drawable,Moveable{
    private Color bodyColor,mastColor,sailColorOne,sailColorTwo,waveColor;

    public Boat (int x,int y){
        setTranslateX(x);
        setTranslateY(y);
        setWidth(100);
        setHeight(100);
    }

    @Override
    public void draw(){
        drawBody();
        drawMast();
        drawSail();
        drawWave();
    }

    public void drawBody(){
        GraphicsContext gc = getGraphicsContext2D();
        double[] xPoints = {0,25,75,100};
        double[] yPoints = {70,100,100,70};
        gc.setFill(bodyColor);
        gc.fillPolygon(xPoints,yPoints,4);
        gc.strokePolygon(xPoints,yPoints,4);
    }

    public void drawMast(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(mastColor);
        gc.fillRect(47.5,0,3,70);
        gc.strokeRect(47.5,0,3,70);
    }

    public void drawSail(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(sailColorOne);
        gc.fillRect(52.5,0,47.5,25);
        gc.strokeRect(52.5,0,47.5,25);
        gc.setFill(sailColorTwo);
        gc.fillRect(52.5,25,47.5,25);
        gc.strokeRect(52.5,25,47.5,25);
    }

    public void drawWave(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(waveColor);
        gc.fillArc(40,97,25,15,0,180,CHORD);
        gc.fillArc(25,97,25,18,0,180,CHORD);
        gc.fillArc(15,97,15,20,0,180,CHORD);
        gc.fillArc(55,97,20,20,0,180,CHORD);
        gc.fillArc(70,97,15,10,-10,180,CHORD);


    }


    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void setMastColor(Color mastColor) {
        this.mastColor = mastColor;
    }

    public void setSailColorOne(Color sailColorOne) {
        this.sailColorOne = sailColorOne;
    }

    public void setSailColorTwo(Color sailColorTwo) {
        this.sailColorTwo = sailColorTwo;
    }

    public void setWaveColor(Color waveColor) {
        this.waveColor = waveColor;
    }

    public boolean isClick(double mouseX,double mouseY){
        double maxWidth = getTranslateX() + getWidth();
        double maxHeight = getTranslateY() + getHeight();
        if (mouseX < getTranslateX()) return false;
        if (mouseY < getTranslateY()) return false;
        if (mouseX > maxWidth) return false;
        if (mouseY > maxHeight) return false;
        return true;
    }

    @Override
    public void move(int distance) {
        TranslateTransition ttBoat = new TranslateTransition(
                Duration.millis(3000), this);
        ttBoat.setFromX(this.getTranslateX());
        ttBoat.setToX(this.getTranslateY() + distance);
        ttBoat.setCycleCount(Animation.INDEFINITE);
        ttBoat.setAutoReverse(true);
        ttBoat.play();
    }
}
