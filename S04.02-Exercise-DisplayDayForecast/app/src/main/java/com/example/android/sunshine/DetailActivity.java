package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mWeatherForDayTextView = (TextView) findViewById(R.id.tv_weather_for_day);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            String weatherForDay = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            mWeatherForDayTextView.setText(weatherForDay);
        }

    }
}