package sample.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Background extends Canvas implements Drawable{
    private Color sandColor,seaColor,skyColor;

    public Background(int x, int y){
        setTranslateX(x);
        setTranslateY(y);
        setHeight(500);
        setWidth(600);
    }

    @Override
    public void draw(){
        drawBeach();
        drawSky();
        drawSea();
    }

    private void drawBeach(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(sandColor);
        gc.fillRect(0,300,600,200);
    }

    public void drawSky(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(seaColor);
        gc.fillRect(0,0,600,100);
    }

    public void drawSea(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(skyColor);
        gc.fillRect(0,100,600,200);
    }

    public void setSandColor(Color sandColor) {
        this.sandColor = sandColor;
    }

    public void setSeaColor(Color seaColor) {
        this.seaColor = seaColor;
    }

    public void setSkyColor(Color skyColor) {
        this.skyColor = skyColor;
    }
}
