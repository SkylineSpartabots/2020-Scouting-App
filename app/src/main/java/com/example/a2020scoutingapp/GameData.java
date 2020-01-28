package com.example.a2020scoutingapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RawData")
public class GameData {

//Pre Game data
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name= "MatchNumber")
    public int matchNumber;

    @ColumnInfo(name= "TeamNumber")
    public String teamNumber;

    // options: center,right,left
    @ColumnInfo(name= "Start Position")
    public String startSide;

    @ColumnInfo(name= "Has Preloaded Balls")
    public boolean preloadedBalls;
//Auto
    @ColumnInfo(name="Did they Cross the Line")
    public boolean crossedLine;

    @ColumnInfo(name= "Power cells shot in Hexagon Auto")
    public int cellsShotHexagonAuto;

    @ColumnInfo(name= "Power cells shot in Rectangle Auto")
    public int cellsShotRectAuto;

    @ColumnInfo(name= "Power cells shot in Circle Auto")//may not be used
    public int cellsShotCircleAuto;

    @ColumnInfo(name= "Power Cells Shot and missed in Auto")
    public int cellsMissed;

    // max 20
    @ColumnInfo(name= "Power Cells Collected in Auto")
    public int cellsCollected;

// Teleop

    @ColumnInfo(name= "Power cells shot in Hexagon")
    public int cellsShotHexagon;

    @ColumnInfo(name= "Power cells shot in Rectangle")
    public int cellsShotRect;

    @ColumnInfo(name= "Power cells shot in Circle")//remove maybe
    public int cellsShotCircle;

    @ColumnInfo(name= "Power cells Missed in Teleop")//remove maybe
    public int cellsMissedTele;


    //how many successful rotation control (0 to 2)
    @ColumnInfo(name= "Ability to Spin")//remove
    public int RotationControl;




    //how may successful choose color control
    @ColumnInfo(name= "Ability To Choose Color")
    public boolean colorControl;

//End Game

    @ColumnInfo(name= "Parked")
    public boolean isParked;

    @ColumnInfo(name= "Climbed")
    public boolean isClimbed;

    @ColumnInfo(name= "Helped Climbed")
    public boolean isHelperClimbed;

    @ColumnInfo(name= "Balanced")
    public boolean isBalance;

    // an large edit text
    @ColumnInfo(name= "Additional Comments")
    public String additionalComments;


//calculated values

    //may not actually need this
    @ColumnInfo(name= "3 point Percentage")
    public int threePointPercentage;



//    @ColumnInfo(name= "Total Auto points")
//    public int TotalAutoPoints;
//    @ColumnInfo(name = "Total Teleop points")
//    public int TotalTelePoints;



}
