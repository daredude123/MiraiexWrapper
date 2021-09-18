package com.andynordevelop.miraiexwrapper.domain;

public enum MiraiexOrderType {

	BID("bid"),
	ASK("ask");

	String type;

	MiraiexOrderType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return type;
	}
}
