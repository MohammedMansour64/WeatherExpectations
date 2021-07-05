package com.example.weatherexpectations.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherexpectations.ForeCastObjects.DayForeCast;
import com.example.weatherexpectations.R;

import java.util.ArrayList;

public class DayForeCastAdapter extends RecyclerView.Adapter {

    ArrayList<DayForeCast> dayForeCasts;

    public DayForeCastAdapter(ArrayList<DayForeCast> dayForeCasts) {
        this.dayForeCasts = dayForeCasts;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_day_forecast , parent , false);
        DayForeCastViewHolder dayForeCastViewHolder = new DayForeCastViewHolder(view);

        return dayForeCastViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DayForeCast dayForeCastList = dayForeCasts.get(position);
        ((DayForeCastViewHolder)holder).dayForeCastConditionImage.setImageResource(dayForeCastList.getImageCondition());
        ((DayForeCastViewHolder)holder).dayForeCastCondition.setText(dayForeCastList.getTextCondition());
        ((DayForeCastViewHolder)holder).dayForeCastDay.setText(dayForeCastList.getDate());
        ((DayForeCastViewHolder)holder).dayForeCastHighTemp.setText(dayForeCastList.getHighTemperature());
        ((DayForeCastViewHolder)holder).dayForeCastLowTemp.setText(dayForeCastList.getLowTemperature());

    }

    @Override
    public int getItemCount() {
        return dayForeCasts.size();
    }

    public static class DayForeCastViewHolder extends RecyclerView.ViewHolder {
        ImageView dayForeCastConditionImage;
        TextView dayForeCastDay;
        TextView dayForeCastCondition;
        TextView dayForeCastHighTemp;
        TextView dayForeCastLowTemp;
        public DayForeCastViewHolder(@NonNull View itemView) {
            super(itemView);
            dayForeCastConditionImage = itemView.findViewById(R.id.day_forecast_condition_image_view);
            dayForeCastDay = itemView.findViewById(R.id.day_forecast_day_text_view);
            dayForeCastCondition = itemView.findViewById(R.id.day_forecast_condition_text_view);
            dayForeCastHighTemp = itemView.findViewById(R.id.day_forecast_high_temp);
            dayForeCastLowTemp = itemView.findViewById(R.id.day_forecast_low_temp);

        }
    }
}
