package com.wifilocation.demo.model;


public class Result {
    private boolean success;
    private int count;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Result() {
    }

    public Result(boolean success, int count) {
        this.success = success;
        this.count = count;
    }
}
