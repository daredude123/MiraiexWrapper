package com.andynordevelop.miraiexwrapper.domain;

public enum MiraiexCurrencyEnum {


	BTC ("BTC"),
	DAI ("DAI"),
	ETH ("ETH"),
	LTC ("LTC"),
	XRP ("XRP"),
	ADA ("ADA"),
	NOK ("NOK");

	String value;

	MiraiexCurrencyEnum(String value) {
		this.value = value;
	}
}
