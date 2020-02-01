package com.example.a2020scoutingapp;


import java.util.Scanner;

public class DeString {
    public String str;
    public DeString(String s){
        this.str = s;
        Scanner deScan = new Scanner(s);
        deScan.useDelimiter("#@;-;@#");
        this.matchNumber = deScan.next();
        this.teamNumber = deScan.next();
        this.alliance = deScan.next();

        this.cellsCollected = deScan.nextInt();
        int rectScore = deScan.nextInt();
        int circScore = deScan.nextInt();
        int hexScore = deScan.nextInt();



    }

    public String matchNumber;


    public String teamNumber;

    public String alliance;

    // options: center,right,left
    public String startSide;

    public boolean preloadedBalls;
    //Auto
    public boolean crossedLine;

    public int cellsShotHexagonAuto;

    public int cellsShotRectAuto;

    public int cellsShotCircleAuto;

    public int cellsMissed;

    // max 20
    public int cellsCollected;

// Teleop

    public int cellsShotHexagon;

    public int cellsShotRect;

    public int cellsShotCircle;

    public int cellsMissedTele;


    //how many successful rotation control (0 to 2)
    public int RotationControl;




    //how may successful choose color control
    public boolean colorControl;

//End Game

    public boolean isParked;

    public boolean isClimbed;

    public boolean isHelperClimbed;

    public boolean isBalance;

    // an large edit text
    public String additionalComments;


//calculated values

    //may not actually need this
    public int threePointPercentage;

}

