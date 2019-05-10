package com.example.rushilkhattar.navdr;

/**
 * Created by rushilkhattar on 12/11/17.
 */

public class Score {
    String pin;
    int score;
    public Score(){

    }

    public Score(String pin, int score) {
        this.pin = pin;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getPin() {
        return pin;
    }
}
