package com.example.weatherexpectations.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatherexpectations.R;
import com.example.weatherexpectations.entity.WeatherInfo;

public class PrimaryWeatherInfoFragment extends Fragment {
    private TextView cityName;
    private TextView mainTemperature;
    private TextView todayDate;
    private TextView highAndLowTemperature;
    private TextView weatherCondition;
    private ImageView weatherImageCondition;
    private WeatherInfo mWeatherInfo;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_primary_weather_info , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View mainView = getView();

        cityName =mainView.findViewById(R.id.city);
        mainTemperature = mainView.findViewById(R.id.temperature);
        todayDate = mainView.findViewById(R.id.date);
        highAndLowTemperature = mainView.findViewById(R.id.high_low_temperature);
        weatherCondition = mainView.findViewById(R.id.weather_description);
        weatherImageCondition = mainView.findViewById(R.id.weather_icon);
        showWeatherInfo();
    }

    private void showWeatherInfo() {

        /* Weather Icon ************************************************************************* */

        // Get the weather icon resource id based on icon string passed from the api
        int weatherImageId = R.drawable.ic_clear_sky;

        // Display weather condition icon
        weatherImageCondition.setImageResource(weatherImageId);

        /* Current city ************************************************************************* */

        // Read date from weather info object
        String cityName1 = "State of Kuwait";

        // Display city name
        cityName.setText(cityName1);

        /* Weather Date ************************************************************************* */

        // Get human readable string using getFriendlyDateString utility method and display it
        String dateString = "Wed, 24 April";

        /* Display friendly date string */
        todayDate.setText(dateString);

        /* Weather Description ****************************************************************** */

        // Get weather condition description
        String description = "Cloudy";

        // Display weather description
        weatherCondition.setText(description);


        /* Temperature ************************************************************************** */

        // Read temperature from weather object
        String temperatureString = "17°";

        // Display high temperature
        mainTemperature.setText(temperatureString);


        /* High (max) & Low (min) temperature temperature *************************************** */

        // Read high temperature from weather object
        String highTemperatureString = "19°";

        // Read low temperature from weather object
        String lowTemperatureString = "10°";

        // Display high/low temperature
       // highAndLowTemperature.setText(getString(R.string.high_low_temperature, lowTemperatureString, highTemperatureString));

    }

    public void updateWeatherInfo(WeatherInfo weatherInfo) {
        mWeatherInfo = weatherInfo;
        showWeatherInfo();
    }
}
