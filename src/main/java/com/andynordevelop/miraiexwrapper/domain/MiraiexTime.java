package com.andynordevelop.miraiexwrapper.domain;

import java.io.Serializable;

public class MiraiexTime implements Serializable {
    private String time;

    public MiraiexTime() {
    }

    public MiraiexTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MiraiexTime{" +
                "time='" + time + '\'' +
                '}';
    }
}
