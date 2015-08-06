package com.ryszarddzegan.pouwaterhop;

import android.util.Log;

public class LoggerImp implements Logger {
    private static LoggerImp instance = null;

    public static LoggerImp getInstance() {
        if (instance == null) {
            instance = new LoggerImp();
        }

        return instance;
    }

    private LoggerImp() {}

    public void info(String tag, String message) {
        Log.i(tag, message);
    }
}
