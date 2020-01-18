package com.example.a2020scoutingapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RawData")
public class GameData {

//Pre Game data
    @PrimaryKey( autoGenerate= true)
    public int matchNumber;

    @ColumnInfo(name= "TeamNumber")
    public String teamNumber;
    @ColumnInfo(name= "Start Position")
    public String startSide;

    @ColumnInfo(name= "Preloaded Ball Number")
    public int preloadedBalls;
//Auto
    @ColumnInfo(name="Did they Cross the Line")
    public boolean crossedLine;
    @ColumnInfo(name= "Power cells shot in Hexagon Auto")
    public String cellsShotHexagonAuto;

    @ColumnInfo(name= "Power cells shot in Rectangle Auto")
    public String cellsShotRectAuto;

    @ColumnInfo(name= "Power cells shot in Circle Auto")
    public String cellsShotCircleAuto;

    @ColumnInfo(name= "Power Cells Collected in Auto")
    public int cellsCollected;

    @ColumnInfo(name= "Overall Auto Role Description")
    public String overallAutoRole;

    @ColumnInfo(name= "Additional Comments")
    public String AutoComments;
// Teleop
    @ColumnInfo(name= "Power cells shot in Hexagon")
    public String cellsShotHexagon;

    @ColumnInfo(name= "Power cells shot in Rectangle")
    public String cellsShotRect;

    @ColumnInfo(name= "Power cells shot in Circle")
    public String cellsShotCircle;

    @ColumnInfo(name= "Ability to Spin")
    public int AbilityToSpin;



    @ColumnInfo(name= "Ability To Choose Color")
    public int AbilityToChoose;
//End Game
    @ColumnInfo(name= "Balanced")
    public boolean isBalance;

    @ColumnInfo(name= "Parked")
    public boolean isParked;

    @ColumnInfo(name= "Climbed")
    public boolean isClimbed;

    @ColumnInfo(name= "Helped Climbed")
    public boolean isHelperClimbed;

    @ColumnInfo(name= "Additional Comments")
    public String additionalComments;


//calculated values
    @ColumnInfo(name= "3 point Percentage")
    public int threePointPercentage;
    @ColumnInfo(name= "Total Auto points")
    public int TotalAutoPoints;
    @ColumnInfo(name = "Total Teleop points")
    public int TotalTelePoints;



}
