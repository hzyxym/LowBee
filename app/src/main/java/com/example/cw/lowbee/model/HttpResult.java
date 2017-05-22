package com.example.cw.lowbee.model;

/**
 * Created by cw on 2017/5/22.
 */

public class HttpResult<T> {
    private String error = "";
    //用来模仿Data
    private T results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getSubjects() {
        return results;
    }

    public void setSubjects(T subjects) {
        this.results = subjects;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("error=" + error);
        if (null != results) {
            sb.append(" subjects:" + results.toString());
        }
        return sb.toString();
    }
}
