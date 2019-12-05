package com.example.homeworkone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class AboutDeveloper extends AppCompatActivity {

    public TextView aboutMe;
    public ImageView photoMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me_activity);

        aboutMe = findViewById(R.id.text_about_me);
        photoMe = findViewById(R.id.photo_me);


    }

}
