package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexMarketTicker {

	String market;
    double bid;
    double ask;
	double spread;

    public MiraiexMarketTicker() {
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getSpread() {
        return spread;
    }

    public void setSpread(double spread) {
        this.spread = spread;
    }

    @Override
    public String toString() {
        return "MiraiexMarketTicker{" +
                "ask='" + ask + '\'' +
                ", market='" + market + '\'' +
                ", bid='" + bid + '\'' +
                ", spread='" + spread + '\'' +
                '}';
    }
}
