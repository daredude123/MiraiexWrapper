package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexOrder {

	int id;
	String market;
	String type;
	double price;
	double amount;
	double remaining;
	double matched;
	double cancelled;
	String created_at;

	public MiraiexOrder() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}

	public double getMatched() {
		return matched;
	}

	public void setMatched(double matched) {
		this.matched = matched;
	}

	public double getCancelled() {
		return cancelled;
	}

	public void setCancelled(double cancelled) {
		this.cancelled = cancelled;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "MiraiexOrder{" +
				"id='" + id + '\'' +
				", market='" + market + '\'' +
				", type='" + type + '\'' +
				", price='" + price + '\'' +
				", amount='" + amount + '\'' +
				", remaining='" + remaining + '\'' +
				", matched='" + matched + '\'' +
				", cancelled='" + cancelled + '\'' +
				", created_at='" + created_at + '\'' +
				'}';
	}
}
