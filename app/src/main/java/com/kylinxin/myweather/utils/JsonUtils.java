package com.kylinxin.myweather.utils;

import android.text.TextUtils;
import android.util.Log;

import com.kylinxin.myweather.MainActivity;
import com.kylinxin.myweather.bean.WFuture7Bean;
import com.kylinxin.myweather.bean.WHourly24Bean;
import com.kylinxin.myweather.bean.WRealTimeBean;
import com.kylinxin.myweather.callback.HttpCallback;
import com.kylinxin.myweather.callback.WeatherCallback_24H;
import com.kylinxin.myweather.callback.WeatherCallback_7D;
import com.kylinxin.myweather.callback.WeatherCallback_now;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    public static final String TAG = "MainActivityLog";


    public static void getNowWeather(String location, WeatherCallback_now callback) {
        String url = HttpUtils.getInstance().getNowUrl(location);
        Log.d(TAG, "url = " + url);
        HttpUtils.getInstance().Post(url, new HttpCallback() {
            @Override
            public void onFailed(int ErrorCode) {
                callback.onFailed(ErrorCode);
            }

            @Override
            public void onResponse(String JSONData) {
                if (TextUtils.isEmpty(JSONData)) {
                    callback.onFailed(0);
                    return;
                }
                Log.d(TAG, "now = " + JSONData);
                try {
                    JSONObject jsonObject = new JSONObject(JSONData);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    JSONObject now = jsonArray.getJSONObject(0).getJSONObject("now");
                    String time = jsonArray.getJSONObject(0).getString("last_update");
                    WRealTimeBean bean = HttpUtils.getInstance().fromJson(
                            now.toString(),
                            WRealTimeBean.class
                    );

                    if (bean != null) {
                        bean.setLast_update(time);
                        bean.setLocation(location);
                    }
                    callback.onSuccess(bean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void getFuture7Weather(String location, WeatherCallback_7D callback) {
        String url = HttpUtils.getInstance().getFuture7Url(location, 7);
        Log.d(TAG, "url = " + url);
        HttpUtils.getInstance().Post(url, new HttpCallback() {
            @Override
            public void onFailed(int ErrorCode) {
                callback.onFailed(ErrorCode);
            }

            @Override
            public void onResponse(String JSONData) {
                if (TextUtils.isEmpty(JSONData)) {
                    callback.onFailed(0);
                    return;
                }
                Log.d(TAG, "future7 = " + JSONData);
                try {
                    JSONObject jsonObject = new JSONObject(JSONData);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    JSONArray future7 = jsonArray.getJSONObject(0).getJSONArray("daily");
                    List<WFuture7Bean> bean = HttpUtils.getInstance().fromListJson(
                            future7.toString(),
                            WFuture7Bean.class
                    );
                    callback.onSuccess(bean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void getHourly24Weather(String location, WeatherCallback_24H callback) {
        String url = HttpUtils.getInstance().getHourly24Url(location, 24);
        Log.d(TAG, "url = " + url);
        HttpUtils.getInstance().Post(url, new HttpCallback() {
            @Override
            public void onFailed(int ErrorCode) {
                callback.onFailed(ErrorCode);
            }

            @Override
            public void onResponse(String JSONData) {
                if (TextUtils.isEmpty(JSONData)) {
                    callback.onFailed(0);
                    return;
                }
                Log.d(TAG, "hourlv24 = " + JSONData);
                try {
                    JSONObject jsonObject = new JSONObject(JSONData);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    JSONArray hourly24 = jsonArray.getJSONObject(0).getJSONArray("hourly");
                    List<WHourly24Bean> bean = HttpUtils.getInstance().fromListJson(
                            hourly24.toString(),
                            WHourly24Bean.class
                    );
                    callback.onSuccess(bean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}