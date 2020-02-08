package com.example.a2020scoutingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;

import java.util.Scanner;

public class RecordTeleOp extends AppCompatActivity {
    CheckBox pickColor;
    Button endGame;
    NumberPicker rectNum;
    NumberPicker circNum;
    NumberPicker hexNum;
    NumberPicker missNum;
    NumberPicker rotationControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_tele_op);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        missNum= findViewById(R.id.missedShots);
        hexNum=findViewById(R.id.hexNumPick);
        circNum= findViewById(R.id.circNumPick);
        rectNum= findViewById(R.id.rectNumPick);
        rotationControl= findViewById(R.id.rotateControl);



        //end game
        endGame = findViewById(R.id.endGame);
        //picks Color
        pickColor = findViewById(R.id.pickedTheColor);
        pickColor.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        missNum.setMaxValue(50);
        hexNum.setMaxValue(50);
        rectNum.setMaxValue(50);
        circNum.setMaxValue(50);
        rotationControl.setMaxValue(2);
        missNum.setMinValue(0);
        hexNum.setMinValue(0);
        rectNum.setMinValue(0);
        circNum.setMinValue(0);
        rotationControl.setMinValue(0);
        final SharedPreferences sp= RecordTeleOp.this.getSharedPreferences("Saved Data",MODE_PRIVATE);
        String se=sp.getString("TeleData","");
        if(!se.equals("")){
            Scanner sc =new Scanner(se);
            sc.useDelimiter("#@;-;@#");
            rectNum.setValue(sc.nextInt());
            circNum.setValue(sc.nextInt());
            hexNum.setValue(sc.nextInt());
            missNum.setValue(sc.nextInt());
            rotationControl.setValue(sc.nextInt());
            pickColor.setChecked(sc.nextBoolean());

        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        endGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String delimeter="#@;-;@#";
                String teleText=delimeter+rectNum.getValue()+delimeter+circNum.getValue()+delimeter+hexNum.getValue()+delimeter+missNum.getValue()+delimeter+
                        rotationControl.getValue()+delimeter+pickColor.isChecked();

                SharedPreferences.Editor ed=sp.edit();
                ed.putString("TeleData",teleText).apply();


                startActivity(new Intent(RecordTeleOp.this,RecordEndGame.class));
            }
        });
    }
}
