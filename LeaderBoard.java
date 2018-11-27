package SnakevsBlocks;


import java.util.*;


public class LeaderBoard {
    private int max;
    private ArrayList<Integer> score ;

    LeaderBoard() {
        max=0;
        score.add(40);
    }

    public void updateLeaderboard(int S) {
        this.score.add(S);
        Collections.sort(score);
    }

    public void display() {
        if (score.size() != 0) {
            System.out.println(score);
        }
        else {
            System.out.println("empty");
            exit();
        }

    }

    public void exit() {
        exit();
    }
}
