package com.andynordevelop.miraiexwrapper.domain;

public class CryptoBody {

	float timestamp;
	float validity;

	public CryptoBody() {
	}

	public float getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(float timeStamp) {
		this.timestamp = timeStamp;
	}

	public float getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}
}
