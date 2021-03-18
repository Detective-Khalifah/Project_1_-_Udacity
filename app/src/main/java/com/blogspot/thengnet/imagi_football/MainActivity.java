package com.blogspot.thengnet.imagi_football;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    boolean penaltyKicked = true;

    private Button btnA1, btnB1, // "+1 point" score buttons for both teams
            btnAFoul, btnBFoul, // "Foul" buttons for both teams
            btnAFree, btnBFree; // "Free Kick" buttons for both teams

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA1 = (Button) findViewById(R.id.btn_one_a);
        btnB1 = (Button) findViewById(R.id.btn_b_one);

        btnAFoul = (Button) findViewById(R.id.btn_a_foul);
        btnBFoul = (Button) findViewById(R.id.btn_b_foul);

        btnAFree = (Button) findViewById(R.id.btn_a_free);
        btnBFree = (Button) findViewById(R.id.btn_b_free);
    }

    /**
     * Increase the score for Team A by 1 point, and display the new score
     */
    public void addOneForTeamA (View view) {
        scoreTeamA++;
        displayForTeamA();
    }

    /**
     * Displays the given @param score for Team B, and display the new score
     */
    public void addOneForTeamB (View view) {
        scoreTeamB++;
        displayForTeamB();
    }

    /**
     * Generate a random boolean value to determine if "Team A" scores +1 point after the free kick
     * then enable all buttons with exception of the "Free Kick" buttons -- until another foul occurs.
     * the @param vi #freeKickForTeamA button
     */
    public void freeKickForTeamA(View vi) {
        boolean freeKickWinned = false;
        Random freeForA = new Random();

        while (!penaltyKicked) {
            freeKickWinned = freeForA.nextBoolean();
            penaltyKicked = true;
        }

        if (freeKickWinned) {
            // Display Team A's current score after the free kick
            addOneForTeamA(vi);
        }

        btnA1.setEnabled(true);
        btnB1.setEnabled(true);
        btnAFoul.setEnabled(true);
        btnBFoul.setEnabled(true);

        // Disable the "Free Kick" buttons from being clicked
        btnAFree.setEnabled(false);
        btnBFree.setEnabled(false);
    }

    /**
     * Generate a random boolean value to determine if "Team B" scores +1 point after the free kick
     * then enable all buttons with exception of the "Free Kick" buttons -- until another foul occurs.
     * the @param vi #freeKickForTeamB button
     */
    public void freeKickForTeamB(View vi) {
        boolean freeKickWinned = false;
        Random freeForB = new Random();

        while (!penaltyKicked) {
            freeKickWinned = freeForB.nextBoolean();
            penaltyKicked = true;
        }

        if (freeKickWinned) {
            // Display Team B's current score after the free kick
            addOneForTeamB(vi);
        }

        btnA1.setEnabled(true);
        btnB1.setEnabled(true);
        btnAFoul.setEnabled(true);
        btnBFoul.setEnabled(true);

        // Disable the "Free Kick" buttons from being clicked
        btnAFree.setEnabled(false);
        btnBFree.setEnabled(false);

    }

    /**
     * Disable all buttons except the opponent team B's "Free Kick" when team A makes a foul
     * @param vi "Team A's" foul button
     */
    public void teamAFouls(View vi) {
        penaltyKicked = false;

        // Disable score & foul buttons from getting clicked when a foul occurs
        btnA1.setEnabled(false);
        btnB1.setEnabled(false);
        btnAFoul.setEnabled(false);
        btnBFoul.setEnabled(false);
        btnAFree.setEnabled(false); // disable the 'fouling' team A from making a free kick at the moment

        // Enable "Team B" to make a "Free Kick"
        btnBFree.setEnabled(true);
    }

    /**
     * Disable all buttons except the opponent team A's "Free Kick" when team B makes a foul
     * @param vi "Team B's" foul button
     */
    public void teamBFouls(View vi) {
        penaltyKicked = false;

        // Disable score & foul buttons from getting clicked when a foul occurs
        btnA1.setEnabled(false);
        btnB1.setEnabled(false);
        btnAFoul.setEnabled(false);
        btnBFoul.setEnabled(false);
        btnBFree.setEnabled(false); // disable the 'fouling' team B from making a free kick at the moment

        // Enable "Team A" to make a "Free Kick"
        btnAFree.setEnabled(true);
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