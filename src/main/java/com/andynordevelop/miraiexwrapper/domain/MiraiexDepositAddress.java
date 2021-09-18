package com.andynordevelop.miraiexwrapper.domain;

public class MiraiexDepositAddress {

	String btc_address;
	String ltc_address;

	public MiraiexDepositAddress() {
	}

	public String getBtc_address() {
		return btc_address;
	}

	public void setBtc_address(String btc_address) {
		this.btc_address = btc_address;
	}

	public String getLtc_address() {
		return ltc_address;
	}

	public void setLtc_address(String ltc_address) {
		this.ltc_address = ltc_address;
	}

	@Override
	public String toString() {
		return "MiraiexDepositAddress{" +
				"btc_address='" + btc_address + '\'' +
				", ltc_address='" + ltc_address + '\'' +
				'}';
	}
}
