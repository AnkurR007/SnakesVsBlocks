package SnakevsBlocks;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.exit;


public class game2 extends Application {

    //final static Pane root = new Pane();
    //Scene sc;
    //final static double snake_radius = 10;
    static double i=5;
    static double i2 = 5;

    static HBox box = new HBox();
    static Group group = new Group();
    static Label label_1 = new Label();
    static Label label_2 = new Label();
    static Label label_3 = new Label();
    static Label label_4 = new Label();
    static Label label_5 = new Label();

    public static ArrayList<Circle> circle = new ArrayList<>();

    static Random random = new Random();
    public static String[] color = {
            "#CD5C5C",
            "#ADD8E6",
            "#00FFFF",
            "#FF1493",
            "#FFFFE0",
            "#90EE90",
            "#FFA500",
            "#F5DEB3"
    };

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #0000;");

        Label label1 = new Label("Snake\n   VS\nBlocks");
        label1.setStyle("-fx-font-size: 4em;");
        label1.setTextFill(Color.RED);
        label1.setLayoutX(150);
        label1.setLayoutY(50);

        Button button1 = new Button();
        button1.setStyle("-fx-font-size: 2em; ");
        button1.setLayoutX(180);
        button1.setLayoutY(400);
        button1.setText("Play Game");

        Button button2 = new Button();
        button2.setStyle("-fx-font-size: 2em; ");
        button2.setLayoutX(200);
        button2.setLayoutY(450);
        button2.setText("LeaderBoard");

        Button button3 = new Button();
        button3.setStyle("-fx-font-size: 2em; ");
        button3.setLayoutX(220);
        button3.setLayoutY(500);
        button3.setText("Exit Game    ");


        pane.getChildren().addAll(label1 ,button1, button2, button3);

        primaryStage.setTitle("Snake Vs Blocks ");

        Scene New_Scene = new Scene(pane, 500, 700, Color.BLACK);

        primaryStage.setScene(New_Scene);


        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exit(0);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LeaderBoard leaderboard = new LeaderBoard();
                leaderboard.display();
                leaderboard.exit();
                primaryStage.hide();
            }
        });

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game2 play_game = new game2();
                play_game.start_game();

                primaryStage.hide();
            }
        });

        primaryStage.show();
    }

//    public static void update(double original_x, double i) {
//        time = 0;
//        box.setLayoutX(original_x + i);
//    }


    public static void start_game() {

//        box.setStyle("-fx-background-color: #0000;");
//        box.setPadding(new Insets(5,0,100,0));
        System.out.println("Playing");

        Button pause_button = new Button("Pause");
        pause_button.setStyle("-fx-font-size: 1em;");
        pause_button.setLayoutX(2);
        pause_button.setLayoutY(2);

        Stage the_Stage = new Stage();

//        ArrayList<String> color1 = new ArrayList<>(){{
//            add("#CD5C5C");
//            add("#ADD8E6");
//            add("#00FFFF");
//            add("#FF1493");
//            add("#FFFFE0");
//            add("#90EE90");
//            add("#FFA500");
//            add("#F5DEB3");
//            add("#ADFF2F");
//            add(Color.LIGHTBLUE);
//            add(Color.LIGHTCORAL);
//            add(Color.GREENYELLOW);
//            add(Color.PINK);
//            add(Color.LIGHTYELLOW);
//            add(Color.CHOCOLATE);
//            add(Color.GREEN);
//            add(Color.WHEAT);
//            add(Color.BEIGE);
//        }};


        //Snake

        AnimationTimer timer = new AnimationTimer() {
            double time;

            @Override
            public void handle(long now) {
                time=time+0.05;
                if (time<=15 ) {
                    game2 play_game = new game2();
                    play_game.update();

                }

            }
        };
        timer.start();

        Rectangle r = new Rectangle();
        r.setLayoutX(300);
        r.setLayoutY(200);
        r.setFill(Color.WHEAT);

        //group.getChildren().addAll(label_1, label_2, label_3, label_4, label_5,r);
        Label label_100 = block1();
        Label label_200 = block2();
        Label label_300 = block3();
        Label label_400 = block4();
        Label label_500 = block5();


        group.getChildren().addAll(pause_button,label_100, label_200, label_300,label_400,label_500);
        the_Stage.setScene(new Scene(group,500,700,Color.BLACK));


        the_Stage.show();
    }


    public static void snakes(int n) {
         


    }


    public static Label block1() {
//        Label label_100 = new Label();
        label_1.setText("             "+Integer.toString(random.nextInt(10)+1));
        String s1 = "-fx-background-color:"+color[random.nextInt(8)]+";";
        label_1.setLayoutX(0);
        label_1.setLayoutY(5);
        label_1.setStyle(s1);
        label_1.setPrefWidth(100);
        label_1.setPrefHeight(100);

        return label_1;
    }

    public static Label block2() {
//        Label label_200 = new Label();
        label_2.setText("             "+Integer.toString(random.nextInt(10)+1));
        label_2.setLayoutX(100);
        label_2.setLayoutY(5);
        String s2 = "-fx-background-color:"+color[random.nextInt(8)]+";";
        label_2.setStyle(s2);
        label_2.setPrefWidth(100);
        label_2.setPrefHeight(100);

        return label_2;

    }

    public static Label block3() {
//        Label label_300 = new Label();
        label_3.setText("             "+Integer.toString(random.nextInt(10)+1));
        label_3.setLayoutX(200);
        label_3.setLayoutY(5);
        String s3 = "-fx-background-color:"+color[random.nextInt(8)]+";";
        label_3.setStyle(s3);
        label_3.setPrefWidth(100);
        label_3.setPrefHeight(100);

        return label_3;
    }

    public static Label block4() {
//        Label label_400 = new Label();
        label_4.setText("             "+Integer.toString(random.nextInt(10)+1));
        label_4.setLayoutX(300);
        label_4.setLayoutY(5);
        String s4 = "-fx-background-color:"+color[random.nextInt(8)]+";";
        label_4.setStyle(s4);
        label_4.setPrefWidth(100);
        label_4.setPrefHeight(100);

        return label_4;
    }

    public static Label block5() {
//        Label label_500 = new Label();
        label_5.setText("             "+Integer.toString(random.nextInt(10)+1));
        label_5.setLayoutX(400);
        label_5.setLayoutY(5);
        String s5 = "-fx-background-color:"+color[random.nextInt(8)]+";";
        label_5.setStyle(s5);
        label_5.setPrefWidth(100);
        label_5.setPrefHeight(100);

        return label_5;
    }


    public static void update() {

        i=i+2;
        label_1.setTranslateX(0);
        label_1.setTranslateY(i);

        label_2.setTranslateX(0);
        label_2.setTranslateY(i);

        label_3.setTranslateX(0);
        label_3.setTranslateY(i);

        label_4.setTranslateX(0);
        label_4.setTranslateY(i);

        label_5.setTranslateX(0);
        label_5.setTranslateY(i);

        if (label_1.getLayoutY() < 650) {
//            Label label_100 = block1();
//            Label label_200 = block2();
//            Label label_300 = block3();
//            Label label_400 = block4();
//            Label label_500 = block5();

        }

    }




    public static void main(String[] args) { launch(args);    }

}
