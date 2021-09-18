package com.andynordevelop.miraiexwrapper.domain;

import java.util.Arrays;

public class MiraiexOrderDepth {

    double[][] bids;
    double[][] asks;

    public MiraiexOrderDepth() {
    }

    public double[][] getBids() {
        return bids;
    }

    public void setBids(double[][] bids) {
        this.bids = bids;
    }

    public double[][] getAsks() {
        return asks;
    }

    public void setAsks(double[][] asks) {
        this.asks = asks;
    }

    @Override
    public String toString() {
        String ret = "asks: ";
        for (int i = 0; i < asks.length; i++) {
            ret +=  Arrays.toString(asks[i]);
        }
        ret += "\n bids: ";
        for (int i = 0; i < bids.length; i++) {
            ret += "bids: " + Arrays.toString(bids[i]);
        }
        return ret;
    }
}
