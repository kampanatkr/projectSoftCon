package sample.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Sun extends Canvas implements Drawable{
    private Color bodyColor;

    public Sun(int x,int y){
        setTranslateX(x);
        setTranslateY(y);
        setHeight(75);
        setWidth(75);
    }

    @Override
    public void draw() {
        drawBody();
    }

    public void drawBody(){
        GraphicsContext gc = getGraphicsContext2D();
        //ออร่า
        gc.setFill(Color.color(1, 0.949, 0.0431));
        gc.fillOval(0,0,68,68);
        gc.setFill(Color.color(1, 0.6863, 0.0667));
        gc.fillOval(2,2,65,65);
        gc.setFill(Color.color(1, 0.4431, 0.0392));
        gc.fillOval(4,4,62,62);

        //ดวงอาทิตย์
        gc.setFill(bodyColor);
        gc.fillOval(6,6,60,60);

    }

    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }
}
