package sample.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.util.Random;

public class Crab extends Canvas implements Drawable{
    Random random = new Random();
    private Color bodyColor;

    public Crab(int x,int y){
        setTranslateX(x);
        setTranslateY(y);
        setHeight(50);
        setWidth(50);
    }

    @Override
    public void draw(){
        drawBody();
        drawLeg();
        drawArm();
        drawEye();
    }

    private void drawBody(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(bodyColor);
        gc.fillOval(10,20,30,20);
        gc.strokeOval(10,20,30,20);
    }

    private void drawLeg(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.color(1, 0.4549, 0.1373));
        //ขาคู่แรก
        gc.fillOval(6,30,4,4);
        gc.fillOval(40,30,4,4);
        gc.fillPolygon(new double[]{5,7,6}, new double[]{38.5, 38.5, 40.5},3);
        gc.fillOval(4,33,4,6);
        gc.fillPolygon(new double[]{43.3,45.3,44.3}, new double[]{38.5, 38.5, 40.5},3);
        gc.fillOval(42.3,33,4,6);
        //ขาคู่สอง
        gc.fillPolygon(new double[]{9,10,9.5}, new double[]{40.7, 40.7, 41.5},3);
        gc.fillPolygon(new double[]{40.0,41.0,40.5}, new double[]{40.7, 40.7, 41.5},3);
        gc.fillOval(9.0,34.0,3.0,3.0);
        gc.fillOval(38.1,34.0,3.0,3.0);
        gc.fillOval(8.0,36.8,3.0,4.0);
        gc.fillOval(39.0,36.8,3.0,4.0);
        //ขาคู่สุดท้าย
        gc.fillOval(12.6,37.0,2.5,2.5);
        gc.fillOval(35.0,37.0,2.5,2.5);
        gc.fillOval(12.0,39.3,2.0,2.5);
        gc.fillPolygon(new double[]{12.45,13.5,13.0},new double[]{41.7,41.7,42.2},3);
        gc.fillOval(36.0,39.3,2.0,2.5);
        gc.fillPolygon(new double[]{36.5,37.5,36.8},new double[]{41.7,41.7,42.2},3);

    }

    private void drawEye(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(bodyColor);
        gc.fillRect(21.0,17.0,2.0,4.0);
        gc.fillRect(27.0,17.0,2.0,4.0);
        gc.setFill(Color.WHITE);
        gc.fillOval(19.0,12.0,6.0,6.0);
        gc.fillOval(25.0,12.0,6.0,6.0);
        gc.setFill(Color.BLACK);
        gc.fillOval(20.0,13.0,4.0,4.0);
        gc.fillOval(26.0,13.0,4.0,4.0);
    }

    private void drawArm(){
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.color(1, 0.4549, 0.1373));
        gc.fillOval(10.0,18.6,5.0,5.0);
        gc.fillOval(35.0,18.6,5.0,5.0);
        gc.fillOval(8.0,14.6,4.5,4.5);
        gc.fillOval(37.0,14.5,4.5,4.5);
        gc.setFill(Color.color(0.8588, 0.3451, 0.098));
        gc.fillArc(7.0,6.8,5.0,8.0,110,330, ArcType.ROUND);
        gc.fillArc(37.0,6.5,5.0,8.0,120,310, ArcType.ROUND);

    }

    public void setBodyColor() {
        this.bodyColor =  Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }
    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void goUp(){
        if (getTranslateY() > 280)
        {
            setTranslateY(getTranslateY() - 1);
        }
    }

    public void goDown(){
        if (getTranslateY() < 455)
        {
            setTranslateY(getTranslateY() + 1);
        }
    }

    public void goLeft(){
        if (getTranslateX() > 0)
        setTranslateX(getTranslateX() - 1);
    }

    public void goRight(){
        if (getTranslateX() < 550)
        setTranslateX(getTranslateX() + 1);
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
}
