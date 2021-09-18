package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexSpecificMarketTicker {
	double bid;
	double ask;
	double spread;

	public MiraiexSpecificMarketTicker() {
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getAsk() {
		return ask;
	}

	public void setAsk(double ask) {
		this.ask = ask;
	}

	public double getSpread() {
		return spread;
	}

	public void setSpread(double spread) {
		this.spread = spread;
	}

	@Override
	public String toString() {
		return "MiraiexSpecificMarketTicker{" +
				"bid='" + bid + '\'' +
				", ask='" + ask + '\'' +
				", spread='" + spread + '\'' +
				'}';
	}
}
