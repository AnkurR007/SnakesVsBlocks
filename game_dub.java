package SnakevsBlocks;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

import static java.lang.System.exit;


public class game_dub extends Application {

    public static Group group = new Group();
    public static String[] color = { "#CD5C5C","#ADD8E6","#00FFFF","#FF1493","#FFFFE0","#90EE90","#FFA500","#F5DEB3" };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #0000;");

        Label welcome = new Label("  Welcome");
        welcome.setStyle("-fx-font-size: 4em;");
        welcome.setTextFill(Color.BLUE);
        welcome.setLayoutX(30);
        welcome.setLayoutY(10);

        Line line_01 = new Line(10, 70, 290, 70);
        line_01.setStrokeWidth(3.0f);

        Label join_the_community = new Label("\t Join the Community    ");
        join_the_community.setStyle("-fx-font-size: 2em;");
        join_the_community.setTextFill(Color.CHOCOLATE);
        //join_the_community.setStyle("-fx-background-color: #E0FFFF;");
        join_the_community.setLayoutX(280);
        join_the_community.setLayoutY(160);
        join_the_community.setPrefSize(300,30);


        Label email = new Label(" Email:");
        email.setTextFill(Color.CHOCOLATE);
        //email.setStyle("-fx-background-color: #00CED1;");
        email.setFont(new Font(16));
        email.setLayoutX(240);
        email.setLayoutY(200);
        email.setPrefSize(50,30);

        TextField email_id = new TextField();
        email_id.setPromptText(" Email");
        email_id.setLayoutX(320);
        email_id.setLayoutY(200);
        email_id.setPrefSize(250,30);

        Label pass = new Label(" Password:");
        pass.setTextFill(Color.CHOCOLATE);
        //email.setStyle("-fx-background-color: #00CED1;");
        pass.setFont(new Font(16));
        pass.setLayoutX(240);
        pass.setLayoutY(250);
        pass.setPrefSize(75,30);

        PasswordField password_field = new PasswordField();
        password_field.setPromptText(" **********");
        password_field.setLayoutX(320);
        password_field.setLayoutY(250);
        password_field.setPrefSize(250,30);

        Button forget_password = new Button("Forget Password ?");
        forget_password.setLayoutX(450);
        forget_password.setLayoutY(290);
        forget_password.setPrefSize(120,10);
        forget_password.setTextFill(Color.GREY);
        forget_password.setStyle("-fx-background-color: #ADD8E6;");

        Button login = new Button("  Login");
        login.setLayoutX(320);
        login.setLayoutY(320);
        login.setPrefSize(250,30);
        login.setTextFill(Color.BLACK);
        login.setStyle("-fx-background-color: #00CED1;");

        pane.getChildren().addAll(welcome, line_01, join_the_community, email, email_id, pass, password_field, forget_password, login);
        primaryStage.setTitle("Snake Vs Blocks");
        Scene new_scene = new Scene(pane, 600, 500, Color.LIGHTBLUE);

        primaryStage.setScene(new_scene);

//Forget-Password - Exit ( Define the Function)
//##################################################################
        forget_password.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //game_dub forget_pass = new game_dub();
                //forget_pass.forget();
                System.exit(0);
                //primaryStage.hide();
            }
        });
        forget_password.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                    System.exit(0);
                }
            }
        });


//Login - Start Game
//##################################################################

        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game_dub forget_pass = new game_dub();
                forget_pass.snakeblock();
                primaryStage.hide();
            }
        });
        login.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                    game_dub forget_pass = new game_dub();
                    forget_pass.snakeblock();
                    primaryStage.hide();
                }
            }
        });
//        Label galat_enter = new Label("");
//        //galat_enter.setTextFill(Color.RED);
//        galat_enter.setFont(new Font(12));
//        galat_enter.setLayoutX(240);
//        galat_enter.setLayoutY(360);
//        galat_enter.setPrefSize(75,30);
//
//        new_scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//
//                if ( ( email_id.getText() != null || !(email_id.getText().trim().isEmpty()) ) && ( password_field.getText() != null || !(password_field.getText().trim().isEmpty())) && event.getCode().equals(KeyCode.ENTER) ) {
//                    game_dub forget_pass = new game_dub();
//                    forget_pass.snakeblock();
//                    primaryStage.hide();
//                }
//                if( ( email_id.getText() == null || email_id.getText().trim().isEmpty() ) && ( password_field.getText() == null || password_field.getText().trim().isEmpty()) && event.getCode().equals(KeyCode.ENTER) ){
//                    galat_enter.setText(" Please Enter Email and Password!");
//                    galat_enter.setTextFill(Color.RED);
//                    pane.getChildren().addAll(galat_enter);
//
//                }
//            }
//        });

        primaryStage.show();

    }




//###########################################################################################
    //          Snake vs Block' Screen
//###########################################################################################


    public static void snakeblock() {
        Stage the_stage = new Stage();
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #00CED1;");

        Label label1 = new Label("Snake\n   VS\nBlocks");
        label1.setStyle("-fx-font-size: 4em;");
        label1.setTextFill(Color.CHOCOLATE);
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
        the_stage.setTitle("Snake Vs Blocks ");
        Scene New_Scene = new Scene(pane, 500, 600);
        the_stage.setScene(New_Scene);

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
                the_stage.hide();
            }
        });
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game_dub bt = new game_dub();
                bt.play_game();
                the_stage.hide();
            }
        });
        the_stage.show();
    }

//###########################################################################################################
//                  Game Starts
//###########################################################################################################

    public void play_game() {
        Stage game_stage = new Stage();
        Group group = new Group();


        Button pause = new Button("Pause");
        //pause.setTextFill(Color.CHOCOLATE);

        pause.setLayoutX(5);
        pause.setLayoutY(5);

        //########################################
        // Snake Added
        //########################################

        snake s = new snake(6);
        group.getChildren().addAll(s.snakes);

        Label count_snake = new Label("6");
        count_snake.setStyle("-fx-background-color: #808080;");
        count_snake.setTextFill(Color.WHITE);
        count_snake.setLayoutX(246);
        count_snake.setLayoutY(405);
        group.getChildren().addAll(pause,count_snake);

        Blocks blk1 = new Blocks(5);
        Blocks blk2 = new Blocks(5);
        group.getChildren().addAll(blk1.block_list);


        AnimationTimer timer = new AnimationTimer() {
            double time;
            double i = 0;double i2 =0;

            @Override
            public void handle(long now) {
                time+=0.05;
                if (time <= 14 ) {
                    i = i + 2;
                    for (int j = 0; j < blk1.block_list.size(); j++) {
                        blk1.block_list.get(j).setTranslateX(0);
                        blk1.block_list.get(j).setTranslateY(i);
                    }
                }
                if (time >= 14) {
                    time=0;
                    i=0;
                    group.getChildren().removeAll(blk1.block_list);


                }
            }
        };

        timer.start();






        game_stage.setTitle("Snake Vs Blocks");
        Scene game_scene = new Scene(group, 500, 600, Color.GREY);
        game_stage.setScene(game_scene);

        game_scene.setOnKeyPressed(e->{
                    switch (e.getCode()) {
                        case A:

                            moveleft(s.snakes,count_snake);
                            break;

                        case D:

                            moveright(s.snakes,count_snake);
                            break;

                    }
                }
        );

        game_stage.show();
    }

//    public static void erase() {
//        group.getChildren().remove();
//    }


    public static void moveleft(ArrayList<Circle> snake, Label l)
    {
        if(snake.get(0).getCenterX() <= 130){
            l.setTranslateX(l.getTranslateX() - 0);
            for(int i=0;i<snake.size();i++) {
                snake.get(i).setTranslateX(snake.get(i).getTranslateX() - 0);

            }
        }
        else{
            l.setTranslateX(l.getTranslateX() - 20);
            l.setLayoutX(l.getLayoutX() - 20);

            for(int i=0;i<snake.size();i++) {
                snake.get(i).setTranslateX(snake.get(i).getTranslateX() - 20);
                snake.get(i).setCenterX(snake.get(i).getCenterX() - 20);
            }
        }

    }

    public static void moveright(ArrayList<Circle> snake,Label l)
    {
        if(snake.get(0).getCenterX() >= 370){
            l.setTranslateX(l.getTranslateX() + 0);
            for(int i=0;i<snake.size();i++) {

                snake.get(i).setTranslateX(snake.get(i).getTranslateX()+0);
            }
        }
        else {
            l.setTranslateX(l.getTranslateX() + 20);
            l.setLayoutX(l.getLayoutX() + 20);
            for(int i=0;i<snake.size();i++) {
                snake.get(i).setTranslateX(snake.get(i).getTranslateX()+20);
                snake.get(i).setCenterX(snake.get(i).getCenterX() + 20);
            }
        }

    }



}
