package com.example.a2020scoutingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.Strategy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RecordEndGame extends AppCompatActivity {
    CheckBox parked;
    CheckBox climbed;
    CheckBox balanced;
    CheckBox helped;
    CheckBox defended;
    EditText additionalComments;
    Button advertise;
    Button showQR;
    ImageView qrImage;
    EditText clientName;
    NearbyCreator nc;
    Button exit;

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
        defended=findViewById(R.id.Defended);
        additionalComments=findViewById(R.id.addtionalComments);
        showQR=findViewById(R.id.QR);
        clientName=findViewById(R.id.AdName);
        qrImage=findViewById(R.id.imageView);
        advertise=findViewById(R.id.advertise);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences spe= RecordEndGame.this.getSharedPreferences("Saved Data",MODE_PRIVATE);
                spe.edit().putString("AutoData","").apply();
                spe.edit().putString("TeleData","").apply();
                spe.edit().putString("EndGameData","").apply();
                startActivity(new Intent(RecordEndGame.this,MainActivity.class));
            }
        });
        showQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringEndgame();
                SharedPreferences spe= RecordEndGame.this.getSharedPreferences("Saved Data",MODE_PRIVATE);

                QRCreator cd= new QRCreator(""+spe.getString("AutoData","")+spe.getString("TeleData","")+spe.getString("EndGameData",""),20,20);
                qrImage.setImageBitmap(cd.getBitmap());

            }
        });

        nc= new NearbyCreator(this, "", Strategy.P2P_POINT_TO_POINT);
        final NearbyCreator.OptionsOfDiscovery optionsOfDiscovery=new NearbyCreator.OptionsOfDiscovery() {
            @Override
            public void OnDiscoverySuccess() {
                Toast.makeText(RecordEndGame.this,"Discovery Starting ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnDiscoveryFailure() {
                Toast.makeText(RecordEndGame.this,"Discovery Failing please contact Davin or Pranav ",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnStringReceived(String s) {
                Toast.makeText(RecordEndGame.this,"Received Back: "+s,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnStringUpdate() {

            }

            @Override
            public void OnConnectionGood(String s) {

                if(s.equals("Labib Master")) {
                    SharedPreferences spe = getSharedPreferences("Saved Data", 0);
                    nc.sendMessage("Labib Master", getSharedPreferences("Saved Data", MODE_PRIVATE).getString(
                            "" + spe.getString("AutoData", "") + spe.getString("TeleData", "") + spe.getString("EndGameData", ""), ""));
                }else{
                    nc.stopConnection(s);
                }
            }

            @Override
            public void OnConnectionError() {
                Toast.makeText(RecordEndGame.this,"Connection error",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnConnectionRejected() {
                Toast.makeText(RecordEndGame.this,"You have been rejected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnConnectionDisconnected() {
                Toast.makeText(RecordEndGame.this,"Connection disconnected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean Authenticated(@NonNull DiscoveredEndpointInfo discoveredEndpointInfo) {
                return true;
            }

            @Override
            public void OnConnectionSuccess() {
                Toast.makeText(RecordEndGame.this,"Connection success",Toast.LENGTH_SHORT).show();
             }

            @Override
            public void OnConnectionFailure() {
                Toast.makeText(RecordEndGame.this,"Connection failed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnConnectionLost() {
                Toast.makeText(RecordEndGame.this,"Connection lost",Toast.LENGTH_SHORT).show();
            }
        };

        advertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringEndgame();

                if(!clientName.getText().toString().equals("")){
                nc.startDiscovery(clientName.getText().toString(),optionsOfDiscovery);}else{
                    clientName.setError("Please enter a name");
                }
            }
        });
    }

    private  void stringEndgame(){
        String delimeter="#@;-;@#";
        String endText=delimeter+parked.isChecked()+delimeter+climbed.isChecked()+delimeter+helped.isChecked()+delimeter+balanced.isChecked()+defended.isChecked()
                +delimeter+
                additionalComments.getText().toString()+" ";
        SharedPreferences sp= RecordEndGame.this.getSharedPreferences("Saved Data",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("EndGameData",endText);


    }


}
