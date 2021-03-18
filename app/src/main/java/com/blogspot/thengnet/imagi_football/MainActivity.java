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
     * Displays the given @param score for Team B.
     */
    public void addOneForTeamB (View view) {
        scoreTeamB++;
        displayForTeamB();
    }

    public void freeKickForTeamA(View vi) {

    }

    public void freeKickForTeamB(View vi) {

    }

    public void teamAFouls(View vi) {

    }

    public void teamBFouls(View vi) {

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