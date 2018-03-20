package sample.Models;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import static javafx.scene.shape.ArcType.CHORD;

public class Ship extends Boat{
    private Color bodyColor;
    private Color cargoColor;
    private Color waveColor;

    public Ship(int x, int y) {
        super(x, y);
        setWidth(80);
        setHeight(80);
    }

    @Override
    public void draw(){
        drawBody();
        drawCargo();
        drawWave();
    }

    public void drawBody(){
        GraphicsContext gc = getGraphicsContext2D();
        double[] xPoints = {0,16,64,80};
        double[] yPoints = {56,80,80,56};
        gc.setFill(bodyColor);
        gc.fillPolygon(xPoints,yPoints,4);
        gc.strokePolygon(xPoints,yPoints,4);
    }

    public void drawCargo(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(cargoColor);
        gc.fillRect(40,31,25,25);
        gc.setFill(Color.color(1,1,1));
        gc.fillRect(43,40,10,10);
        gc.fillRect(53,40,10,10);
        gc.strokeRect(43,40,10,10);
        gc.strokeRect(53,40,10,10);
    }

    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void setCargoColor(Color cargoColor) {
        this.cargoColor = cargoColor;
    }

    @Override
    public void setWaveColor(Color waveColor) {
        this.waveColor = waveColor;
    }


}
