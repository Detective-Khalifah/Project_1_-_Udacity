package com.blogspot.thengnet.imagi_football;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA (View view) {
        scoreTeamA++;
        displayForTeamA();
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA (View view) {
        scoreTeamA += 2;
        displayForTeamA();
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA (View view) {
        scoreTeamA += 3;
        displayForTeamA();
    }

    /**
     * Displays the given @param score for Team B.
     */
    public void addOneForTeamB (View view) {
        scoreTeamB++;
        displayForTeamB();
    }

    /**
     * Displays the given @param score for Team B.
     */
    public void addTwoForTeamB (View view) {
        scoreTeamB += 2;
        displayForTeamB();
    }

    /**
     * Displays the given @param score for Team B.
     */
    public void addThreeForTeamB (View view) {
        scoreTeamB += 3;
        displayForTeamB();
    }

    /**
     * Displays the given @param score for Team A.
     */
    public void displayForTeamA () {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB () {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    public void resetScore (View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA();
        displayForTeamB();
    }
}