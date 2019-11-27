package com.example.homeworkone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;


public class WeatherActivity extends AppCompatActivity implements View.OnClickListener {

    public TextInputEditText chooseCity;
    public RadioButton spb;
    public RadioButton msc;
    public RadioButton hls;
    public RadioButton anth;
    public CheckBox prs;
    public CheckBox wnd;
    public Button lookWeather;

    Pattern checkCity = Pattern.compile("^[A-Z][a-z]{2,}$");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);
        chooseCity = findViewById(R.id.edit_city);
        spb = findViewById(R.id.saint_p);
        msc = findViewById(R.id.moscow);
        hls = findViewById(R.id.helsinki);
        anth = findViewById(R.id.another);
        prs = findViewById(R.id.show_pressed);
        wnd = findViewById(R.id.show_wind);
        lookWeather = findViewById(R.id.look_weather);
        lookWeather.setOnClickListener(this);
        spb.setOnClickListener(radioButtonClickListener);
        msc.setOnClickListener(radioButtonClickListener);
        hls.setOnClickListener(radioButtonClickListener);
        anth.setOnClickListener(radioButtonClickListener);

        chooseCity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) return;
                TextView tv = (TextView) view;

                validate(tv, checkCity,"It`s not city");
            }

            private void validate(TextView tv, Pattern check, String message) {
                String value = tv.getText().toString();
                if (check.matcher(value).matches()){
                    hideError(tv);
                }
                else{
                    showError(tv, message);
                }
            }

            private void showError(TextView view, String message) {
                view.setError(message);
            }

            private void hideError(TextView view) {
                view.setError(null);
            }
        });
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RadioButton radioButton = (RadioButton)view;
            switch (radioButton.getId()){
                case R.id.saint_p: chooseCity.setText(spb.getText().toString());
                break;
                case R.id.moscow: chooseCity.setText(msc.getText().toString());
                break;
                case R.id.helsinki: chooseCity.setText(hls.getText().toString());
                break;
                case R.id.another: Toast.makeText(WeatherActivity.this, "Choose your city", Toast.LENGTH_SHORT).show();
                break;
            }

        }
    };


    @Override
    public void onClick(View view) {
        String wind = "Speed wind is 20 m/s";
        String pressed = "20 mmHg";
        String city = chooseCity.getText().toString();
        String checkWnd = null;
        String checkPress = null;

        if(wnd.isChecked()) {
            checkWnd = wind;
        }
        if (prs.isChecked()){
            checkPress = pressed;
        }
        Intent intent = new Intent(this, ShowWeather.class);
        intent.putExtra("City Name", city);
        intent.putExtra("Pressed",checkPress );
        intent.putExtra("Wind", checkWnd);

        startActivity(intent);

    }
}
