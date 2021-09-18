package com.andynordevelop.miraiexwrapper.client;

import com.andynordevelop.miraiexwrapper.configuration.MiraiexClientConfiguration;
import com.andynordevelop.miraiexwrapper.domain.*;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class MiraiexClient {

	private final RestTemplate restTemplate;
	private final MiraiexClientConfiguration miraiexClientConfiguration;

	@Autowired
	public MiraiexClient(MiraiexClientConfiguration miraiexClientConfiguration) throws Exception {
		this.miraiexClientConfiguration = miraiexClientConfiguration;
		if (Strings.isNullOrEmpty(miraiexClientConfiguration.getApiKey()) ||
				Strings.isNullOrEmpty(miraiexClientConfiguration.getClientId()) ||
				Strings.isNullOrEmpty(miraiexClientConfiguration.getSecretKey())) {
			throw new Exception("Need to set api, clientid, or secret key");
		}
		restTemplate = new RestTemplate();
		System.out.println("test");
	}

	public MiraiexTime getTime() {
		String requestUrl = miraiexClientConfiguration.getBaseurl().concat(miraiexClientConfiguration.getTime());
		return restTemplate.getForObject(requestUrl, MiraiexTime.class);
	}

	public MiraiexPair[] getmiraiexTradeablePairs() {
		String reqestUrl = miraiexClientConfiguration.getBaseurl().concat(miraiexClientConfiguration.getTradeablePairs());
		return restTemplate.getForObject(reqestUrl, MiraiexPair[].class);
	}

	public MiraiexPair getSpecificMarketInfo(MiraiexPairEnum miraiexPairEnum) {
		String requestUrl = miraiexClientConfiguration.getBaseurl().concat(miraiexClientConfiguration.getSpecificMarketInfoPrefix()).concat(miraiexPairEnum.name());
		MiraiexPair miraiexPair = restTemplate.getForObject(requestUrl, MiraiexPair.class);
		Objects.requireNonNull(miraiexPair).setId(miraiexPairEnum.name());
		return miraiexPair;
	}

	/**
	 *
	 * @param miraiexPairEnum which market to query
	 * @param count default 100, max 1000
	 * @return MiraiexPairHistory[] returns array
	 */
	public MiraiexPairHistory[] getspecificMarketHistory(MiraiexPairEnum miraiexPairEnum, int count) {

		String requestUrl = miraiexClientConfiguration.getBaseurl().concat(miraiexClientConfiguration.getSpecificMarketInfoPrefix())
				.concat(miraiexPairEnum.name())
				.concat(miraiexClientConfiguration.getSpecificMarketHistorySuffix())
				.concat("?count="+ count);


		return restTemplate.getForObject(requestUrl, MiraiexPairHistory[].class);
	}

	public MiraiexOrderDepth getSpecificMarketOrderDepth(MiraiexPairEnum miraiexPairEnum) {

		String requestUrl = miraiexClientConfiguration.getBaseurl()
				.concat(miraiexClientConfiguration.getSpecificMarketInfoPrefix())
				.concat(miraiexPairEnum.name())
				.concat(miraiexClientConfiguration.getSpecificMarketOrderDepthsuffix());


		return restTemplate.getForObject(requestUrl, MiraiexOrderDepth.class);
	}

	public MiraiexMarketTicker[] getMarketTicker() {
		String requestUrl;
		requestUrl = miraiexClientConfiguration.getBaseurl()
				.concat(miraiexClientConfiguration.getMarketTicker());

		return restTemplate.getForObject(requestUrl, MiraiexMarketTicker[].class);
	}

    public MiraiexMarketTicker getMarketTicker(MiraiexPairEnum miraiexPairEnum) {

		String requestUrl =  miraiexClientConfiguration.getBaseurl()
				.concat(miraiexClientConfiguration.getSpecificMarketInfoPrefix())
				.concat(miraiexPairEnum.name())
				.concat(miraiexClientConfiguration.getSpecificMarketTickerSuffix());

		MiraiexMarketTicker miraiexMarketTickers = restTemplate.getForObject(requestUrl, MiraiexMarketTicker.class);
		Objects.requireNonNull(miraiexMarketTickers).setMarket(miraiexPairEnum.name());
		return miraiexMarketTickers;
	}
}
