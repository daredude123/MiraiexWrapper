package com.andynordevelop.miraiexwrapper.domain;

public enum MiraiexPairEnum {

    BTCNOK ("BTCNOK"),
    DAINOK ("DAINOK"),
    ETHNOK ("ETHNOK"),
    LTCNOK ("LTCNOK"),
    XRPNOK ("XRPNOK"),
	ADANOK ("ADANOK");

    String pair;

    MiraiexPairEnum(String pair) {
        this.pair = pair;
    }
}
