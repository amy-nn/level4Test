package com.example.net.log;

import android.util.Log;

/**
 * Log接口的实现类
 */
public class ILogImpl implements ILog{

    private static final String TAG = "amy-- >";

    @Override
    public void d(String Tag, String messag) {
        Log.d(Tag, messag);
    }

    @Override
    public void d(String messag) {
        Log.d(TAG,messag);
    }

    @Override
    public void i(String Tag, String messag) {
        Log.d(Tag, messag);
    }

    @Override
    public void i(String messag) {
        Log.d(TAG, messag);
    }

    @Override
    public void e(String Tag, String messag) {
        Log.d(Tag, messag);
    }

    @Override
    public void e(String messag) {
        Log.d(TAG, messag);
    }
}
