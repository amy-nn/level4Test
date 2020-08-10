package com.example.level4;

public interface Result {

    public void success(String path);
    public void fail(Throwable msg);
}
