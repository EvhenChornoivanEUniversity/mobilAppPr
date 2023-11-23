package com.example.pr1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaterialsPage extends AppCompatActivity {

    private Button btn_test;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials_page);

        btn_test = (Button) findViewById(R.id.btn_test);

        btn_test.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MaterialsPage.this, TestPage.class);
                        startActivity(intent);
                    }
                }
        );
    }
}