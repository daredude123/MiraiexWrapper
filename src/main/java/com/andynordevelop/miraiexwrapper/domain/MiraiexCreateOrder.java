package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexCreateOrder {

	String market;
	String type;
	double price;
	double amount;

	public MiraiexCreateOrder() {
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public String getType() {
		return type;
	}

	/**
	 *
	 * @param type bid eller ask. bid for kjøp, ask for selg
	 */
	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MiraiexCreateOrder{" +
				"market='" + market + '\'' +
				", type='" + type + '\'' +
				", price='" + price + '\'' +
				", amount='" + amount + '\'' +
				'}';
	}
}
