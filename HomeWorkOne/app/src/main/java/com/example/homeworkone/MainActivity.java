package com.example.homeworkone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button weath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weath = findViewById(R.id.weather);
        weath.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
