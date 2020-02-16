package com.example.a2020scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.nearby.connection.Strategy;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.util.ArrayList;

public class AdvertiseMain extends AppCompatActivity {
    ImageButton cameraButton;
    Button advertiseButton;
    Button dataViewButton;
    TextView userDisplay;
    Button clearDisplay;
    GameRepository gameRepository;
    final int REQUEST_IMAGE_CAPTURE = 1;
     NearbyCreator nearby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise_main);
        cameraButton = findViewById(R.id.cameraButton);
        advertiseButton = findViewById(R.id.advertisebutton);
        dataViewButton= findViewById(R.id.DataViewButton);
        clearDisplay=findViewById(R.id.clearButton);
        gameRepository=new GameRepository(this.getApplication());
        clearDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDisplay.setText("People:");
                users.clear();
            }
        });
        nearby= new NearbyCreator(AdvertiseMain.this, "Labib Master", Strategy.P2P_STAR);

        dataViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdvertiseMain.this,DataView.class));
            }
        });

        userDisplay=findViewById(R.id.textView2);
        NearbyCreator.getPermissionToUseNearby(AdvertiseMain.this);


        advertiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(advertiseButton.getText().equals("Advertise")) {
                 nearby.startAdvertising("Labib Master", advertising);
                 Toast.makeText(AdvertiseMain.this, "advertising...", Toast.LENGTH_LONG).show();
                 advertiseButton.setText("Stop Advertising");
                 advertiseButton.setBackgroundColor(getResources().getColor(R.color.Red));
             }else{
                 nearby.stopAdvertising();
                 advertiseButton.setBackgroundColor(getResources().getColor(R.color.Blue));
                 advertiseButton.setText("Advertise");

             }





            }
        });


        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Log.d("Me", "Thinking its working");
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        Log.d("Me", "Hi ");
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
            }
        });



    }

    @Override
    protected void onStop() {
        nearby.stopAllConnections();
        super.onStop();
    }

    final ArrayList<String> users= new ArrayList<>();

NearbyCreator.OptionsOfAdvertising advertising= new NearbyCreator.OptionsOfAdvertising() {
    @Override
    public void OnDiscoverySuccess() {
        Toast.makeText(AdvertiseMain.this,"Discovery was succesful",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnDiscoveryFailure() {
        Toast.makeText(AdvertiseMain.this,"Discovery was succesful",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnStringReceived(String user, String s) {
        Toast.makeText(AdvertiseMain.this,"String was received from "+ user,Toast.LENGTH_SHORT).show();
        DeString deString= new DeString(s);
        GameData gd= new GameData(deString.matchNumber,deString.teamNumber,deString.startSide,deString.preloadedBalls,deString.crossedLine,
                deString.cellsShotHexagonAuto,deString.cellsShotRectAuto,deString.cellsShotCircleAuto,deString.cellsCollected,deString.cellsShotHexagon,deString.cellsShotRect,deString.cellsShotCircle,deString.cellsMissedTele,deString.rotationControl,deString.colorControl,deString.isParked,deString.isClimbed,deString.isHelperClimbed,deString.isBalanced,
                deString.isDefense(),deString.additionalComments);
        gameRepository.insert(gd);
        users.add(user+": "+deString.teamNumber);
       userDisplay.setText(userDisplay.getText()+"\n"+users.get(users.size()-1));
       nearby.sendMessage(user,"Scouting Data received");
       nearby.stopConnection(user);
    }

    @Override
    public void OnStringUpdate() {

    }

    @Override
    public void OnConnectionGood(String s) {

    }

    @Override
    public void OnConnectionError() {

    }

    @Override
    public void OnConnectionRejected() {

    }

    @Override
    public void OnConnectionDisconnected() {

    }
};


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("View", "I entered the wrong onActivityResult");


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Log.d("Me", "On Activity result ");

            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Log.d("sp","got IMAGE DATA");
            BarcodeDetector detector =
                    new BarcodeDetector.Builder(getApplicationContext())
                            .setBarcodeFormats(Barcode.DATA_MATRIX | Barcode.QR_CODE)
                            .build();
            if (!detector.isOperational()) {

                return;
            }
            Frame frame = new Frame.Builder().setBitmap(imageBitmap).build();
            SparseArray<Barcode> barcodes = detector.detect(frame);
            if(barcodes.size()!=0){
            Barcode thisCode = barcodes.valueAt(0);
            String finalValue=thisCode.displayValue;
            Log.d("sp","String received: "+finalValue);
            DeString deString= new DeString(finalValue);
            GameData gd= new GameData(deString.matchNumber,deString.teamNumber,deString.startSide,deString.preloadedBalls,deString.crossedLine,
                    deString.cellsShotHexagonAuto,deString.cellsShotRectAuto,deString.cellsShotCircleAuto,deString.cellsCollected,deString.cellsShotHexagon,deString.cellsShotRect,deString.cellsShotCircle,deString.cellsMissedTele,deString.rotationControl,deString.colorControl,deString.isParked,deString.isClimbed,deString.isHelperClimbed,deString.isBalanced,
                    deString.isDefense(),deString.additionalComments);
            gameRepository.insert(gd);}else{
                Toast.makeText(this,"No barcodes found",Toast.LENGTH_SHORT).show();

            }
        }else{
            Log.d("sp","Everything failed ");
        }
    }
}
