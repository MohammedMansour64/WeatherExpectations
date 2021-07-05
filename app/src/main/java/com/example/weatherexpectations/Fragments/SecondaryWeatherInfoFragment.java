package com.example.weatherexpectations.Fragments;

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

public class SecondaryWeatherInfoFragment extends Fragment {
    TextView windMeasure;
    TextView pressureMeasure;
    TextView humidityMeasure;

    TextView windMeasureValue;
    TextView pressureMeasureValue;
    TextView humidityMeasureValue;

    ImageView windImageMeasure;
    ImageView pressureImageMeasure;
    ImageView humidityImageMeasure;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_secondary_weather_info , container , false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();

        windMeasure = view.findViewById(R.id.wind_fragment_text_view);
        pressureMeasure = view.findViewById(R.id.pressure_fragment_text_view);
        humidityMeasure = view.findViewById(R.id.humidity_fragment_text_view);

        windMeasureValue = view.findViewById(R.id.pressure_value_fragment_text_view);
        pressureMeasureValue = view.findViewById(R.id.pressure_value_fragment_text_view);
        humidityMeasureValue = view.findViewById(R.id.humidity_value_fragment_text_view);

        windImageMeasure = view.findViewById(R.id.wind_fragment_image_view);
        pressureImageMeasure = view.findViewById(R.id.wind_fragment_image_view);
        humidityImageMeasure = view.findViewById(R.id.humidity_fragment_image_view);

        showWeatherInfo();
    }

    public void showWeatherInfo() {
        String windMeasureName = "Wind";
        windMeasure.setText(windMeasureName);

        String pressureMeasureName = "Pressure";
        pressureMeasure.setText(pressureMeasureName);

        String humidityMeasureName = "Humidity";
        humidityMeasure.setText(humidityMeasureName);

        String windMeasureValueValue = "1Km/South";
        windMeasureValue.setText(windMeasureValueValue);

        String pressureMeasureValueValue = "1019 Hecto/Pascal";
        pressureMeasureValue.setText(pressureMeasureValueValue);

        String humidityMeasureValueValue = "86%";
        humidityMeasureValue.setText(humidityMeasureValueValue);
    }
}
