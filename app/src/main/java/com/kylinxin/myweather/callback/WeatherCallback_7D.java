package com.kylinxin.myweather.callback;

import com.kylinxin.myweather.bean.WFuture7Bean;

import java.util.List;

public interface WeatherCallback_7D {
    void onFailed(int ErrorCode);
    void onSuccess(List<WFuture7Bean> beanList);
}
