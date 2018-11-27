package SnakevsBlocks;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Random;

public class snake {

    public ArrayList<Circle> snakes = new ArrayList<>();

    snake(int n) {
        double x=0;
        for (int i = 0; i < n; i++) {
            Circle c1 = new Circle(8, Color.YELLOW);
            c1.setCenterX(250);
            c1.setCenterY(430+x);
            snakes.add(c1);

            x+=16;
        }
    }

    public ArrayList<Circle> add(int n) {
        double x=16;
        for (int i = 0; i < n; i++) {
            Circle c1 = new Circle(8, Color.YELLOW);
            c1.setCenterX(snakes.get(snakes.size()).getCenterX());
            c1.setCenterY(snakes.get(snakes.size()).getCenterY()+x);
            snakes.add(c1);
        }
        return snakes;
    }

    public ArrayList<Circle> getSnakes() {
        return snakes;
    }

    public double getsize() {
        return snakes.size();
    }

    public ArrayList<Circle> remove (int n) {
        for (int i = 0; i < n; i++) {
            snakes.remove(snakes.size());
        }
        return snakes;
    }
}

//#######################################################################
//    Blocks
//#######################################################################

class Blocks {

    public static String[] color = { "#CD5C5C","#ADD8E6","#00FFFF","#FF1493","#FFFFE0","#90EE90","#FFA500","#F5DEB3" };
    public ArrayList<Label> block_list = new ArrayList<>();
    Random random = new Random();

    Blocks(int n) {

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0); temp.add(100);temp.add(200);temp.add(300);temp.add(400);
        int x=n;
        for (int i = 0; i < n; i++) {
            Label lab = new Label();
            lab.setText("             "+Integer.toString(random.nextInt(10)+1));
            String s1 = "-fx-background-color:"+color[random.nextInt(8)]+";";
            lab.setStyle(s1);

            int temp2=random.nextInt(x);
            lab.setLayoutX(temp.get(temp2));
            temp.remove(temp2);
            x--;
            lab.setLayoutY(5);
            lab.setPrefWidth(100);
            lab.setPrefHeight(100);

            block_list.add(lab);

        }

    }

    public ArrayList<Label> getblocks(int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0); temp.add(100);temp.add(200);temp.add(300);temp.add(400);
        int x=n;
        for (int i = 0; i < n; i++) {
            Label lab = new Label();
            lab.setText("             "+Integer.toString(random.nextInt(10)+1));
            String s1 = "-fx-background-color:"+color[random.nextInt(8)]+";";
            lab.setStyle(s1);

            int temp2=random.nextInt(x);
            lab.setLayoutX(temp.get(temp2));
            temp.remove(temp2);
            x--;
            lab.setLayoutY(5);
            lab.setPrefWidth(100);
            lab.setPrefHeight(100);

            block_list.add(lab);

        }

        return block_list;
    }

    public ArrayList<Label> getBlock_list() {
        return block_list;
    }

    public ArrayList<Label> remove() {
        for (int i = block_list.size(); i >= 0; i--) {
            block_list.remove(i);
        }

        return block_list;
    }
}

//#######################################################################
//    Score
//#######################################################################

class Score {

    public  double score_point;

    Score() {
        score_point=0;
    }

    public double add(int n) {
        return score_point+=n;
    }



}















