package sample.Controller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Models.*;

import java.io.IOException;
import java.util.Random;


public class HomeController {
    Random random = new Random();
    @FXML
    private Pane pane;
    private Boat boat1,boat2;
    private Ship ship1;
    private OceanLiner oceanLiner1;
    private Background backGround;
    private Crab crab1,crab2,crab3,crab4;
    private Sun sun;
    private Cloud cloud,cloud2,cloud3,cloud4;
    private KeyAction key;
    public Button autoPlayButton;

    @FXML
    public void initialize(){
        Random random = new Random();
        boat1 = new Boat(150,50);
        boat2 = new Boat(250,100);
        ship1 = new Ship(100,30);
        backGround = new Background(0,0);
        oceanLiner1 = new OceanLiner(500,0);
        crab1 = new Crab(180,450);
        crab2 = new Crab(300,420);
        crab3 = new Crab(400,410);
        crab4 = new Crab(480,390);
        sun = new Sun(80,5);
        cloud = new Cloud(random.nextInt(499)+1,random.nextInt(50)+2);
        cloud2 = new Cloud(random.nextInt(499)+1,random.nextInt(50)+2);
        cloud3 = new Cloud(random.nextInt(499)+1,random.nextInt(50)+2);
        cloud4 = new Cloud(random.nextInt(499)+1,random.nextInt(50)+2);
        key = new KeyAction(crab2);
        autoPlayButton = new Button();
        initialScreen();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                key.action();
            }
        };
        timer.start();

        pane.setFocusTraversable(true);
        pane.getParent().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case W:case UP:
                        key.setMoveUp(true);
                        break;
                    case S:case DOWN:
                        key.setMoveDown(true);
                        break;
                    case A:case LEFT:
                        key.setMoveLeft(true);
                        break;
                    case D:case RIGHT:
                        key.setMoveRight(true);
                        break;
                }
            }
        });

        pane.getParent().setOnKeyReleased(event -> {
            double x = pane.getParent().getLayoutX();
            double y = pane.getParent().getLayoutY();
            switch (event.getCode()){
                case W:case UP:
                        key.setMoveUp(false);
                        break;
                case S:case DOWN:
                        key.setMoveDown(false);
                        break;
                case A:case LEFT:
                        key.setMoveLeft(false);
                        break;
                case D:case RIGHT:
                        key.setMoveRight(false);
                        break;
            }
        });

        pane.getParent().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                clickOnCrab(crab1,x,y);
                clickOnCrab(crab2,x,y);
                clickOnCrab(crab3,x,y);
                clickOnCrab(crab4,x,y);

            }

            private void clickOnCrab(Crab crab, double x,double y){
                if (crab.isClick(x,y)){
                    key.setCrab(crab);
                    pane.getChildren().remove(crab);
                    crab.setBodyColor();
                    crab.draw();
                    pane.getChildren().add(crab);
                    }


            }
        });
    }

    private void initialScreen(){
        pane.getChildren().clear();
        backGround.setSandColor(Color.color(1, 0.7216, 0.0196, 0.6353));
        backGround.setSeaColor(Color.color(0.0745, 0.8471, 1, 0.6353));
        backGround.setSkyColor(Color.SKYBLUE);
        backGround.draw();
        //OceanLiner
        oceanLiner1.draw();
        //Ship
        ship1.setBodyColor(Color.color(0.749, 0.1804, 0.0784));
        ship1.setCargoColor(Color.color(1, 0.3882, 0.0235));
        ship1.setWaveColor(Color.color(0.3176, 0.5922, 1));
        ship1.draw();
        //Boat 1
        boat1.setBodyColor(Color.DARKGRAY);
        boat1.setMastColor(Color.BISQUE);
        boat1.setSailColorOne(Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        boat1.setSailColorTwo(Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        boat1.setWaveColor(Color.color(0.3176, 0.5922, 1));
        boat1.draw();
        //Boat 2
        boat2.setBodyColor(Color.color(0.3,0.3,0.3));
        boat2.setMastColor(Color.color(0.302, 0.2078, 0.0118));
        boat2.setSailColorOne(Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        boat2.setSailColorTwo(Color.color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        boat2.setWaveColor(Color.color(0.3333, 0.6549, 1));
        boat2.draw();
        //Crab
        crab1.setBodyColor(Color.color(0.7804, 0.251, 0.0353));
        crab1.draw();
        crab2.setBodyColor(Color.color(0.7804, 0.3725, 0.0471));
        crab2.draw();
        crab3.setBodyColor(Color.color(0.7804, 0.2196, 0.0627));
        crab3.draw();
        crab4.setBodyColor(Color.color(0.6235, 0.2588, 0.0196));
        crab4.draw();
        sun.setBodyColor(Color.color(1, 0.1255, 0.0588));
        sun.draw();
        cloud.draw();
        cloud2.draw();
        cloud3.draw();
        cloud4.draw();

        pane.getChildren().add(backGround);
        pane.getChildren().add(sun);
        pane.getChildren().add(cloud);
        pane.getChildren().add(cloud2);
        pane.getChildren().add(cloud3);
        pane.getChildren().add(cloud4);
        pane.getChildren().add(oceanLiner1);
        pane.getChildren().add(ship1);
        pane.getChildren().add(boat1);
        pane.getChildren().add(boat2);
        pane.getChildren().add(crab1);
        pane.getChildren().add(crab2);
        pane.getChildren().add(crab3);
        pane.getChildren().add(crab4);

    }

    @FXML
    public void autoPlayAction(ActionEvent e) {

        boat1.move(random.nextInt(200)+100);
        boat2.move(random.nextInt(200)+150);
        cloud.move(random.nextInt(400)+50);
        cloud2.move(random.nextInt(400)+50);
        cloud3.move(random.nextInt(400)+50);
        cloud4.move(random.nextInt(400)+50);
        oceanLiner1.move(400);
        ship1.move(100);



    }

    @FXML
    public void showAboutMeAction(ActionEvent e) throws IOException {
        Button b = (Button) e.getSource();
        try {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../AboutMe.fxml"));
        Pane aboutMe = loader.load();
        Scene scene = new Scene(aboutMe);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("About me");
        stage.showAndWait();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void showHowToAction(ActionEvent e) throws IOException {
        Button b = (Button) e.getSource();
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../HowTo.fxml"));
            Pane aboutMe = loader.load();
            Scene scene = new Scene(aboutMe);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("How To");
            stage.showAndWait();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }





}
