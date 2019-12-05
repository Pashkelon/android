package com.example.homeworkone;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkone.model.WeatherModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class ShowWeather extends AppCompatActivity implements View.OnClickListener{

    private Button refresh;
//    private TextView cityView;
//    private TextView pressureView;
//    private TextView temperatureView;
    private EditText cityText;
    private EditText pressureText;
    private EditText temperatureText;

    private static final String TAG = "WEATHER";
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=Moscow,RU&appid=";
    private static final String WEATHER_API_KEY = "bec8189939acefc6247781b3c04793c2";
    private SensorManager sensorManager;
    private List<Sensor> sensors;
    private Sensor sensorHumdity;
    private Sensor sensorTemperature;





    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_weather);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


//        cityView = findViewById(R.id.city_view);
//        pressureView = findViewById(R.id.pressure_view);
//        temperatureView = findViewById(R.id.temperature_view);
        cityText = findViewById(R.id.text_city);
        pressureText = findViewById(R.id.text_pressure);
        temperatureText = findViewById(R.id.text_temperature);
        Button refresh = findViewById(R.id.refresh);
        refresh.setOnClickListener(this);

    }

    @SuppressLint("ServiceCast")
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        Sensor sensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                pressureText.setText(" " + event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensor1, 1000);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                temperatureText.setText(" " +  event.values[0]);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensor, 1000);
    }

    @Override
    public void onClick(View view) {








//        try {
//            final URL uri = new URL(WEATHER_URL + WEATHER_API_KEY);
//            final Handler handler = new Handler();
//            new Thread(new Runnable() {
//                //   @RequiresApi(api = Build.VERSION_CODES.N)
//                public void run() {
//                    HttpsURLConnection urlConnection = null;
//                    try {
//                        urlConnection = (HttpsURLConnection) uri.openConnection();
//                        urlConnection.setRequestMethod("GET");
//                        urlConnection.setReadTimeout(10000);
//                        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                        String result = getLines(in);
//
//                        Gson gson = new Gson();
//                        final WeatherModel weatherModel = gson.fromJson(result, WeatherModel.class);
//
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                displayWeather(weatherModel);
//                            }
//                        });
//                    } catch (Exception e) {
//                        Log.e(TAG, "Fail connection", e);
//                        e.printStackTrace();
//                    } finally {
//                        if (null != urlConnection) {
//                            urlConnection.disconnect();
//                        }
//                    }
//                }
//            }).start();
//        } catch (MalformedURLException e) {
//            Log.e(TAG, "Fail URI", e);
//            e.printStackTrace();
//        }
//    }
//
//    //  @RequiresApi(api = Build.VERSION_CODES.N)
//    @TargetApi(Build.VERSION_CODES.N)
//    private String getLines(BufferedReader in) {
//        return in.lines().collect(Collectors.joining("\n"));
//    }
//
//    @SuppressLint("DefaultLocale")
//    private void displayWeather(WeatherModel weatherModel){
//        cityText.setText(weatherModel.getName());
//        temperatureText.setText(String.format("%f2", weatherModel.getMain().getTemp()));
//        pressureText.setText(String.format("%d", weatherModel.getMain().getPressure()));
//

     }
}



