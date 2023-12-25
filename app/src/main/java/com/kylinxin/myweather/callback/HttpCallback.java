package com.kylinxin.myweather.callback;

public interface HttpCallback {
    void onFailed(int ErrorCode);
    void onResponse(String JSONData);
}
