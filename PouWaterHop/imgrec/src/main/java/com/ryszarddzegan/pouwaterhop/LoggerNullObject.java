package com.ryszarddzegan.pouwaterhop;

public class LoggerNullObject implements Logger {
    private static LoggerNullObject instance = null;

    public static LoggerNullObject getInstance() {
        if (instance == null) {
            instance = new LoggerNullObject();
        }

        return instance;
    }

    private LoggerNullObject() {}

    public void info(String tag, String message) {}
}
