package com.example.weatherexpectations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.weatherexpectations.Adapters.DayForeCastAdapter;
import com.example.weatherexpectations.Adapters.HourForeCastAdapter;
import com.example.weatherexpectations.ForeCastObjects.DayForeCast;
import com.example.weatherexpectations.ForeCastObjects.HourForeCast;
import com.example.weatherexpectations.Fragments.PrimaryWeatherInfoFragment;
import com.example.weatherexpectations.Fragments.SecondaryWeatherInfoFragment;
import com.example.weatherexpectations.Network.NetworkUtils;
import com.example.weatherexpectations.entity.WeatherInfo;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView hourForeCastRecyclerView;
    private RecyclerView dayForeCastRecyclerView;

    private boolean CurrentFragment = true;

    private HeaderFragmentAdapter mHeaderFragmentAdapter;
    private ViewPager mViewPager;

    private LinearLayoutManager mLinearLayoutManager;
    private LinearLayoutManager mLinearLayoutManager2;

    public NetworkUtils mNetworkUtils = new NetworkUtils();

    HourForeCastAdapter mHourForeCastAdapter;
    DayForeCastAdapter mDayForeCastAdapter;

    ArrayList<HourForeCast> hourForeCast;
    ArrayList<DayForeCast> dayForeCast;


    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherDataGetTask weatherDataGetTask = new WeatherDataGetTask();
        weatherDataGetTask.run();
        mFragmentManager = getSupportFragmentManager();
        mViewPager = findViewById(R.id.pager);
        mHeaderFragmentAdapter = new HeaderFragmentAdapter(mFragmentManager);
        mViewPager.setAdapter(mHeaderFragmentAdapter);

        TabLayout tabLayout = findViewById(R.id.indicator);
        tabLayout.setupWithViewPager(mViewPager);


        hourForeCastRecyclerView = findViewById(R.id.hour_cast_recycler_view);
        dayForeCastRecyclerView = findViewById(R.id.day_forecast_recycler_view);

        hourForeCast = new ArrayList<>();



        mHourForeCastAdapter = new HourForeCastAdapter(hourForeCast);
//        mDayForeCastAdapter = new DayForeCastAdapter(dayForeCast);

        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mLinearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        hourForeCastRecyclerView.setLayoutManager(mLinearLayoutManager);
        hourForeCastRecyclerView.setAdapter(mHourForeCastAdapter);

        dayForeCastRecyclerView.setLayoutManager(mLinearLayoutManager2);
        dayForeCastRecyclerView.setAdapter(mDayForeCastAdapter);

        requestWeatherInfo();
        getForecastInfo();
//        requestWeatherInfoTwo();
    }

    private void requestWeatherInfo() {

        Call<WeatherInfo> mWeatherInfoCall = mNetworkUtils.NetworkUtilsInterface().getWeatherInfo(mNetworkUtils.getQueryMap(MainActivity.this));
        mWeatherInfoCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(@NotNull Call<WeatherInfo> call, @NotNull Response<WeatherInfo> response) {
                if (response.code() == 200){
                    WeatherInfo weatherInfo = response.body();
                    mHeaderFragmentAdapter.updateData(weatherInfo);
                }else{
                    Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getForecastInfo(){

        Call<WeatherForecasts> mForecastsCall = mNetworkUtils.NetworkUtilsInterface().getForecastInfo(mNetworkUtils.getQueryMap(MainActivity.this));
        mForecastsCall.enqueue(new Callback<WeatherForecasts>() {
            @Override
            public void onResponse(Call<WeatherForecasts> call, Response<WeatherForecasts> response) {
                if (response.code() == 200){
                    WeatherForecasts weatherForecasts = response.body();

                }
                else {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherForecasts> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    class WeatherDataGetTask implements Runnable {

        @Override
        public void run() {

        }
    }


    class HeaderFragmentAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;

        public HeaderFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            fragments = new ArrayList<>();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PrimaryWeatherInfoFragment();
                case 1:
                    return new SecondaryWeatherInfoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            fragments.add(fragment);
            return fragment;
        }

        public void updateData(WeatherInfo weatherInfo) {
            ((PrimaryWeatherInfoFragment)fragments.get(0)).updateWeatherInfo(weatherInfo);
        }
    }
}