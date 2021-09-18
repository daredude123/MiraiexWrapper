package com.andynordevelop.miraiexwrapper;

import com.andynordevelop.miraiexwrapper.client.MiraiexClient;
import com.andynordevelop.miraiexwrapper.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.RoundingMode;
import java.text.DecimalFormat;


@SpringBootTest
public class MiraiexClientTest {

    @Autowired
    MiraiexClient miraiexClient;

    @Test
    public void TestTime() {
        MiraiexTime time  = miraiexClient.getTime();
        Assert.notNull(time.getTime(), "Check if time is null");
        System.out.println(time);
    }

    @Test
    public void testTradeablePairs() {
        MiraiexPair[] miraiexTradeablePairs = miraiexClient.getmiraiexTradeablePairs();
        Assert.notNull(miraiexTradeablePairs, "Check if pairs is not null");
        for (int i = 0; i < miraiexTradeablePairs.length; i++) {
            System.out.println(miraiexTradeablePairs[i]);
        }
    }

    @Test
    public void testSpecificMarketPair() {
        MiraiexPair miraiexPair = miraiexClient.getSpecificMarketInfo(MiraiexPairEnum.XRPNOK);
        System.out.println(miraiexPair);
        Assert.notNull(miraiexPair, "Check if specific pair is not null");
    }

    @Test
    public void testSpecificMarketPairHistory() {
        MiraiexPairHistory[] miraiexPairHistories = miraiexClient.getspecificMarketHistory(MiraiexPairEnum.BTCNOK, 1000);
        Assert.notNull(miraiexPairHistories, "check if history of specific pair is not null");
        for (int i = 0; i < miraiexPairHistories.length; i++) {
            System.out.println(miraiexPairHistories[i]);
        }
    }

    @Test
    public void testSpecificMarketPairOrderDepth() {
        MiraiexOrderDepth miraiexOrderDepths = miraiexClient.getSpecificMarketOrderDepth(MiraiexPairEnum.BTCNOK);
        Assert.notNull(miraiexOrderDepths, "check if order pairs are not null");
        System.out.println(miraiexOrderDepths);
    }

    @Test
    public void testMarketticker() {
        MiraiexMarketTicker[] miraiexMarketTicker = miraiexClient.getMarketTicker();
        System.out.println("testing");
        Assert.notNull(miraiexMarketTicker, "check if ticker is not null");
        
    }

    @Test
    public void testSpecificMarketTicker() {
        MiraiexMarketTicker miraiexMarketTicker = miraiexClient.getMarketTicker(MiraiexPairEnum.BTCNOK);
        Assert.notNull(miraiexMarketTicker, "check if ticker array is not null");
        System.out.println(miraiexMarketTicker);
    }


    @Test
	public void testPriceGeneration() {
    	double price = 6.56;
    	double gebyr = 0.005;
    	double balance = 157.73;
		double cryptoBalance = 0;
	    double balancetest = balance - (balance * gebyr);
	    System.out.println(balancetest);

	    DecimalFormat df = new DecimalFormat("#.##");
	    DecimalFormat dfAmount = new DecimalFormat("#.########");
	    df.setRoundingMode(RoundingMode.FLOOR);
	    dfAmount.setRoundingMode(RoundingMode.FLOOR);
	    double gebyrRounded = Double.parseDouble(df.format(balance * gebyr));
	    System.out.println("gebyr : "+ gebyrRounded);

	    //gebyr er rundet ned til 2 desimaler
	    double balanceAfterGebyr = balance - gebyrRounded;

	    //pris og mengde å kjøpe for er regnet ut ifra balanse etter trekt gebyr
	    double maxAmount = Double.parseDouble(dfAmount.format(balanceAfterGebyr / price));

	    System.out.println("totalpris : " + balanceAfterGebyr);
	    System.out.println("max mengde å kjøpe : " + maxAmount);


	    //kjøpt 23,92458439
	    //gebyr 0.005 som blir 23,804961468 som er verdt 156,16054723

	    // etter kjøp og salg med samme pris. er det tapt 157.73-156.95 = 0.78 + (23,92458439−23,804961468) * 6.56  = 0.78
    }
}