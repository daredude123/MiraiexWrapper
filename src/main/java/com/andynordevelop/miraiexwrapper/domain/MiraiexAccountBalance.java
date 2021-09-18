package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexAccountBalance {

	String currency;
	double balance;
	double hold;
	double available;

	public MiraiexAccountBalance() {
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getHold() {
		return hold;
	}

	public void setHold(double hold) {
		this.hold = hold;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "MiraiexAccountBalance{" +
				"currency='" + currency + '\'' +
				", balance='" + balance + '\'' +
				", hold='" + hold + '\'' +
				", available='" + available + '\'' +
				'}';
	}
}