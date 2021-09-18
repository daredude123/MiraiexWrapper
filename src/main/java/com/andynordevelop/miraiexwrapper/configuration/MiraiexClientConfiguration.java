package com.andynordevelop.miraiexwrapper.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix="miraiexclient")
public class MiraiexClientConfiguration {

    String baseurl;
    String time;
    String tradeablePairs;
    String specificMarketInfoPrefix;
    String specificMarketHistorySuffix;
    String specificMarketOrderDepthsuffix;
    String marketTicker;
    String specificMarketTickerSuffix;
    String apiKey;
    String secretKey;
    String clientId;
    String accountBalance;
    String depositAddresses;
    String depositHistory;
    String orderPrefix;
    String orderHistorySuffix;
    String tradeCostPercentage;

    public String getTradeCostPercentage() {
        return tradeCostPercentage;
    }

    public void setTradeCostPercentage(String tradeCostPercentage) {
        this.tradeCostPercentage = tradeCostPercentage;
    }

    public String getOrderHistorySuffix() {
        return orderHistorySuffix;
    }

    public void setOrderHistorySuffix(String orderHistorySuffix) {
        this.orderHistorySuffix = orderHistorySuffix;
    }

    public String getOrderPrefix() {
        return orderPrefix;
    }

    public void setOrderPrefix(String orderPrefix) {
        this.orderPrefix = orderPrefix;
    }

    public String getDepositAddresses() {
        return depositAddresses;
    }

    public void setDepositAddresses(String depositAddresses) {
        this.depositAddresses = depositAddresses;
    }

    public String getDepositHistory() {
        return depositHistory;
    }

    public void setDepositHistory(String depositHistory) {
        this.depositHistory = depositHistory;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTradeablePairs() {
        return tradeablePairs;
    }

    public void setTradeablePairs(String tradeablePairs) {
        this.tradeablePairs = tradeablePairs;
    }

    public String getSpecificMarketInfoPrefix() {
        return specificMarketInfoPrefix;
    }

    public void setSpecificMarketInfoPrefix(String specificMarketInfoPrefix) {
        this.specificMarketInfoPrefix = specificMarketInfoPrefix;
    }

    public String getSpecificMarketHistorySuffix() {
        return specificMarketHistorySuffix;
    }

    public void setSpecificMarketHistorySuffix(String specificMarketHistorySuffix) {
        this.specificMarketHistorySuffix = specificMarketHistorySuffix;
    }

    public String getSpecificMarketOrderDepthsuffix() {
        return specificMarketOrderDepthsuffix;
    }

    public void setSpecificMarketOrderDepthsuffix(String specificMarketOrderDepthsuffix) {
        this.specificMarketOrderDepthsuffix = specificMarketOrderDepthsuffix;
    }

    public String getMarketTicker() {
        return marketTicker;
    }

    public void setMarketTicker(String marketTicker) {
        this.marketTicker = marketTicker;
    }

    public String getSpecificMarketTickerSuffix() {
        return specificMarketTickerSuffix;
    }

    public void setSpecificMarketTickerSuffix(String specificMarketTickerSuffix) {
        this.specificMarketTickerSuffix = specificMarketTickerSuffix;
    }
}
