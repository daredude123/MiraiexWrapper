package com.andynordevelop.miraiexwrapper.domain;

import java.util.Arrays;

public class MiraiexDepositHistory {
	int count;
	Transaction[] transactions;

	public MiraiexDepositHistory() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Transaction[] getTransactions() {
		return transactions;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "MiraiexDepositHistory{" +
				"count=" + count +
				", transactions=" + Arrays.toString(transactions) +
				'}';
	}
}
