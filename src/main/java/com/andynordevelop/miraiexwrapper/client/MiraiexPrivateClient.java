package com.andynordevelop.miraiexwrapper.client;

import com.andynordevelop.miraiexwrapper.configuration.MiraiexClientConfiguration;
import com.andynordevelop.miraiexwrapper.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

@Component
public class MiraiexPrivateClient {
	
	
	private RestTemplate restTemplate;
	private MiraiexClientConfiguration miraiexClientConfiguration;
	Logger logger = LoggerFactory.getLogger(MiraiexPrivateClient.class);
	@Autowired
	public MiraiexPrivateClient(MiraiexClientConfiguration miraiexClientConfiguration) throws Exception {

		this.miraiexClientConfiguration = miraiexClientConfiguration;
		restTemplate = new RestTemplate();
		if (Strings.isNullOrEmpty(miraiexClientConfiguration.getApiKey()) ||
				Strings.isNullOrEmpty(miraiexClientConfiguration.getClientId()) ||
				Strings.isNullOrEmpty(miraiexClientConfiguration.getSecretKey())) {
			throw new Exception("Need to set api, clientid, or secret key");
		}
	}
	
	public MiraiexAccountBalance[] getMiraiExAccountBalance() throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getAccountBalance());
		
		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());
		ResponseEntity<MiraiexAccountBalance[]> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexAccountBalance[].class);
		return responseEntity.getBody();
	}
	
	
	public MiraiexDepositAddress getMiraiexDepositAddresses() throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getDepositAddresses());
		
		
		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());

		return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexDepositAddress.class).getBody();
	}
	
	public MiraiexDepositHistory getMiraiexDepositHistory() throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getDepositHistory());
		
		
		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());
		return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexDepositHistory.class).getBody();
	}
	
	public MiraiexOrder[] getMiraiexOrders() throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getOrderPrefix());
		
		
		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());
		return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexOrder[].class).getBody();
	}
	
	
	public MiraiexOrder[] getMiraiexSpecificOrder(MiraiexPairEnum miraiexPairEnum) throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getOrderPrefix())
		.concat("/".concat(miraiexPairEnum.name()));

		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());
		return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexOrder[].class).getBody();
	}
	
	public MiraiexOrder[] getMiraiexOrderHistory() throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getOrderPrefix())
		.concat(miraiexClientConfiguration.getOrderHistorySuffix());
		
		
		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());
		return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexOrder[].class).getBody();
	}
	
	public MiraiexOrder[] getSpecificOrderHistory(MiraiexPairEnum pairEnum) throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getOrderPrefix())
		.concat("/".concat(pairEnum.name()))
		.concat(miraiexClientConfiguration.getOrderHistorySuffix());
		
		
		HttpEntity<String> entity = new HttpEntity<>("body", getHeadersForPrivateClient());
		return restTemplate.exchange(requestUrl, HttpMethod.GET, entity, MiraiexOrder[].class).getBody();
	}
	
	/**
	* create order for a buy
	*/
	public int createOrder(MiraiexCreateOrder miraiexCreateOrder) {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getOrderPrefix());
		
		HttpEntity<String> entity = null;
		ObjectMapper mapper = new ObjectMapper();
		String body = "";

		try {
			body = mapper.writeValueAsString(miraiexCreateOrder);

			entity = new HttpEntity<>(body, getHeadersForPrivateClient());
			logger.info("response {}",entity.toString());
			return restTemplate.exchange(requestUrl, HttpMethod.POST, entity, OrderResponse.class).getBody().getId();
		} catch (Exception e) {
			logger.error("EXCEPTION\t", e);
			logger.info("posting error... HEADER : {} \nBODY : {}",entity.getHeaders(), entity.getBody());
			return 0;
		}
	}

	public int deleteAllOrders() throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
		.concat(miraiexClientConfiguration.getOrderPrefix());
		
		HttpEntity<String> entity = new HttpEntity<>(null, getHeadersForPrivateClient());
		ResponseEntity<String> stringResponseEntity = restTemplate.exchange(requestUrl, HttpMethod.DELETE, entity, String.class);
		return stringResponseEntity.getStatusCodeValue();
	}

	public void deleteOrderInSpecificMarket(String market) throws Exception {
		String requestUrl = miraiexClientConfiguration.getBaseurl()
				.concat(miraiexClientConfiguration.getOrderPrefix())
				.concat("/")
				.concat(market);

		HttpEntity<String> entity = new HttpEntity<>(null, getHeadersForPrivateClient());
		ResponseEntity<String> stringResponseEntity = restTemplate.exchange(requestUrl, HttpMethod.DELETE, entity, String.class);
		if (stringResponseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
			logger.info("deleted orders in market: {}",market);
		}
	}


	private HttpHeaders getHeadersForPrivateClient() throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("miraiex-user-clientid", miraiexClientConfiguration.getClientId());
		httpHeaders.add("miraiex-user-signature", generateSignature());
		httpHeaders.add("miraiex-access-key",  miraiexClientConfiguration.getApiKey());
		httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
		return httpHeaders;
	}

	private String generateSignature() throws Exception {
		CryptoBody cryptoBody = new CryptoBody();

		float x = Math.round(new Date().getTime() / 1000);
		cryptoBody.setTimeStamp(x);
		cryptoBody.setValidity(2000);

		ObjectMapper mapper = new ObjectMapper();
		return encode(miraiexClientConfiguration.getSecretKey(), mapper.writeValueAsString(cryptoBody));
	}

	private String encode(String key, String data) throws Exception {
		Mac sha256_MAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
		sha256_MAC.init(secretKeySpec);
		return Hex.encodeHexString(sha256_MAC.doFinal(data.getBytes("UTF-8")));
	}
}
