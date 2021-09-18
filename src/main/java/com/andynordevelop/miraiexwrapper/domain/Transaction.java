package com.andynordevelop.miraiexwrapper.domain;

public class Transaction {
	int id;
	double amount;
	String currency;
	String deposited_at;
	String transaction_hash;
	String status;
	String confirmation;

	public Transaction() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDeposited_at() {
		return deposited_at;
	}

	public void setDeposited_at(String deposited_at) {
		this.deposited_at = deposited_at;
	}

	public String getTransaction_hash() {
		return transaction_hash;
	}

	public void setTransaction_hash(String transaction_hash) {
		this.transaction_hash = transaction_hash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "Transaction{" +
				"id='" + id + '\'' +
				", amount='" + amount + '\'' +
				", currency='" + currency + '\'' +
				", deposited_at='" + deposited_at + '\'' +
				", transaction_hash='" + transaction_hash + '\'' +
				", status='" + status + '\'' +
				", confirmation='" + confirmation + '\'' +
				'}';
	}
}


