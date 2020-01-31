package com.example.a2020scoutingapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class RecordEndGame extends AppCompatActivity {
    CheckBox parked;
    CheckBox climbed;
    CheckBox balanced;
    CheckBox helped;
    EditText additionalComments;
    Button advertise;
    Button showQR;
    ImageView qrImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_end_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        helped= findViewById(R.id.checkBox3);
        parked= findViewById(R.id.checkBox5);
        balanced=findViewById(R.id.checkBox2);
        climbed=findViewById(R.id.checkBox4);
        additionalComments=findViewById(R.id.addtionalComments);
        showQR=findViewById(R.id.QR);

        qrImage=findViewById(R.id.imageView);
        advertise=findViewById(R.id.advertise);
        showQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add qr code
                SharedPreferences spe= RecordEndGame.this.getSharedPreferences("Saved Data",MODE_PRIVATE);

                QRCreator cd= new QRCreator(""+spe.getString("AutoData","")+spe.getString("TeleData","")+spe.getString("EndGameData",""),20,20);


            }
        });

        advertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO add nearby connections
            }
        });
    }
    private  void stringEndgame(){
        String delimeter="#@;-;@#";
        String endText=delimeter+parked.isChecked()+delimeter+climbed.isChecked()+delimeter+helped.isChecked()+delimeter+balanced.isChecked()
                +delimeter+
                additionalComments.getText().toString();
        SharedPreferences sp= RecordEndGame.this.getSharedPreferences("Saved Data",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("EndGameData",endText);


    }

}
