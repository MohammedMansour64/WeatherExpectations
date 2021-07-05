package com.example.weatherexpectations.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherexpectations.ForeCastObjects.HourForeCast;
import com.example.weatherexpectations.R;

import java.util.ArrayList;

public class HourForeCastAdapter extends RecyclerView.Adapter {

    ArrayList<HourForeCast> hourForeCastArrayList;

    public HourForeCastAdapter(ArrayList<HourForeCast> hourForeCastArrayList) {
        this.hourForeCastArrayList = hourForeCastArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_hour_forecast , parent , false);
        HourForeCastViewHolder hourForeCastViewHolder = new HourForeCastViewHolder(view);

        return hourForeCastViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HourForeCast hourForeCastList = hourForeCastArrayList.get(position);
        ((HourForeCastViewHolder)holder).clockHourForeCast.setText(hourForeCastList.getClock());
        ((HourForeCastViewHolder)holder).conditionHourForeCast.setImageResource(hourForeCastList.getCondition());
        ((HourForeCastViewHolder)holder).TemperatureHourForeCast.setText(hourForeCastList.getTemperature());
    }

    @Override
    public int getItemCount() {
        return hourForeCastArrayList.size();
    }

    public static class HourForeCastViewHolder extends RecyclerView.ViewHolder{
        TextView clockHourForeCast;
        ImageView conditionHourForeCast;
        TextView TemperatureHourForeCast;
        public HourForeCastViewHolder(@NonNull View itemView) {
            super(itemView);

            clockHourForeCast = itemView.findViewById(R.id.hour_forecast_clock);
            conditionHourForeCast = itemView.findViewById(R.id.condition_hour_forecast_image_view);
            TemperatureHourForeCast = itemView.findViewById(R.id.temperature_hour_forecast_text_view);
        }
    }
}
