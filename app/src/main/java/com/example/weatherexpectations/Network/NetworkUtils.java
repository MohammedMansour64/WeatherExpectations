package com.example.weatherexpectations.Network;

import android.content.Context;

import com.example.weatherexpectations.R;
import com.example.weatherexpectations.OpenWeatherApiInterface;
import com.example.weatherexpectations.utils.SharedPreferencesHelper;

import java.util.HashMap;
import java.util.Locale;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    private static final String WEATHER_ENDPOINT = "weather";
    private static final String FORECAST_ENDPOINT = "forecast";

    private static final String QUERY_PARAM = "q";
    private static final String FORMAT_PARAM = "mode";
    private static final String UNITS_PARAM = "units";
    private static final String LANG_PARAM = "lang";
    private static final String APP_ID_PARAM = "appid";

    private static final String FORMAT = "json";

    OpenWeatherApiInterface mApiInterface;


    public HashMap<String, String> getQueryMap(Context context) {
        HashMap<String, String> map = new HashMap<>();

        map.put(QUERY_PARAM, SharedPreferencesHelper.getPreferredWeatherLocation(context));
        map.put(FORMAT_PARAM , FORMAT);
        map.put(UNITS_PARAM , SharedPreferencesHelper.getPreferredMeasurementSystem(context));
        map.put(LANG_PARAM, Locale.getDefault().getLanguage());
        map.put(APP_ID_PARAM , context.getString(R.string.api_key));

       return map;
    }



    public OpenWeatherApiInterface NetworkUtilsInterface(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mApiInterface = retrofit.create(OpenWeatherApiInterface.class);
    }
//    public static String getResponseFromHttpUrl(URL url) throws IOException {
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//        httpURLConnection.setRequestMethod("GET");
//        httpURLConnection.connect();
//        try {
//            InputStream inputStream = httpURLConnection.getInputStream();
//            Scanner scanner = new Scanner(inputStream);
//            scanner.useDelimiter("\\A");
//            boolean hasInput = scanner.hasNext();
//            String response = null;
//            if (hasInput) {
//                response = scanner.next();
//            }
//            scanner.close();
//            Log.d(TAG , "Response" + response);
//            System.out.println("Response" + response);
//            return response;
//        } finally {
//            httpURLConnection.disconnect();
//        }
//    }

    public OpenWeatherApiInterface getApiInterface(){
        return mApiInterface;
    }

}
