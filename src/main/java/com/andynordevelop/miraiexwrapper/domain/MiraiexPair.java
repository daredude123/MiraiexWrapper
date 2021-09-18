package com.andynordevelop.miraiexwrapper.domain;

import java.io.Serializable;

public class MiraiexPair implements Serializable {

    String id;
	double last;
	double high;
	double change;
	double low;
	double volume;

    public MiraiexPair() {
    }

    public MiraiexPair(String id, double last, double high, double change, double low, double volume) {
        this.id = id;
        this.last = last;
        this.high = high;
        this.change = change;
        this.low = low;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "MiraiexPair{" +
                "id='" + id + '\'' +
                ", last='" + last + '\'' +
                ", high='" + high + '\'' +
                ", change='" + change + '\'' +
                ", low='" + low + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
