package com.example.a2020scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText passWord;
    Button next;
    Button guest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find IDs
        next = findViewById(R.id.useFullButton);
        passWord = findViewById(R.id.password);
        userName = findViewById(R.id.username);

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,(RecordAuto.class)));
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this,(RecordAuto.class)));

                validate(userName.getText().toString(), passWord.getText().toString());
            }
        });

    }
    private void validate(String userName, String passWord){
        if (userName.equals("thanksdavin") && passWord.equals("thankspranav")){
            startActivity(new Intent(MainActivity.this,(AdvertiseMain.class)));
        }
    }
}
