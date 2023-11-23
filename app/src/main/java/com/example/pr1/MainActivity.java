package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_Mat;
    private Button btn_Test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Mat = (Button) findViewById(R.id.main_button1);
        btn_Test = (Button) findViewById(R.id.main_button2);

        btn_Mat.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MaterialsPage.class);
                        startActivity(intent);
                    }
                }
        );

        btn_Test.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, TestPage.class);
                        startActivity(intent);
                    }
                }
        );
    }
    }
