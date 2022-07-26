package com.wifilocation.demo.model;


public class Result {
    private boolean success;
    private int number;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Result() {
    }

    public Result(boolean success, int number) {
        this.success = success;
        this.number = number;
    }
}
