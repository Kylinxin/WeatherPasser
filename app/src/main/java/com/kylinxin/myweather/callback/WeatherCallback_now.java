package com.kylinxin.myweather.callback;

import com.kylinxin.myweather.bean.WRealTimeBean;

public interface WeatherCallback_now {
    void onFailed(int ErrorCode);
    void onSuccess(WRealTimeBean bean);
}
