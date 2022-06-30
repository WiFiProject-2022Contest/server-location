package com.wifilocation.demo.model;


public class Result {
    private boolean success;
    public Result(boolean success){
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
