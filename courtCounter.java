package com.example.naszga.happybirthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class courtCounter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    //
    int teamACounter = 0,
        teamBCounter = 0;
    //
    public void add3PointsToA(View v) {
        teamACounter += 3;
        //call addmechine
        addPointsToTeamA(teamACounter);
    }
    //
    public void add2PointsToA(View v) {
        teamACounter += 2;
        //call addmechine
        addPointsToTeamA(teamACounter);
    }
    //
    public void add1PointToA(View v) {
        teamACounter += 1;
        //call addmechine
        addPointsToTeamA(teamACounter);
    }
    //
    public void add3PointsToB(View v) {
        teamBCounter += 3;
        //call addmechine
        addPointsToTeamB(teamBCounter);
    }
    //
    public void add2PointsToB(View v) {
        teamBCounter += 2;
        //call addmechine
        addPointsToTeamB(teamBCounter);
    }
    //
    public void add1PointToB(View v) {
        teamBCounter += 1;
        //call addmechine
        addPointsToTeamB(teamBCounter);
    }
    //
    public void resetCounter (View v) {
        teamACounter = 0;
        teamBCounter = 0;
        addPointsToTeamA(teamACounter);
        addPointsToTeamB(teamBCounter);
    }
    //
    public void addPointsToTeamA(int num) {
        TextView pointRecord = (TextView) findViewById(R.id.team_a_counter);
        pointRecord.setText("" + num);
    }
    //
    public void addPointsToTeamB(int num) {
        TextView pointRecord = (TextView) findViewById(R.id.team_b_counter);
        pointRecord.setText("" + num);
    }
}

