package com.andynordevelop.miraiexwrapper;



import java.time.Duration;
import java.time.LocalDateTime;

import com.andynordevelop.miraiexwrapper.client.MiraiexPrivateClient;
import com.andynordevelop.miraiexwrapper.configuration.MiraiexClientConfiguration;
import com.andynordevelop.miraiexwrapper.domain.MiraiexAccountBalance;
import com.andynordevelop.miraiexwrapper.domain.MiraiexDepositAddress;
import com.andynordevelop.miraiexwrapper.domain.MiraiexDepositHistory;
import com.andynordevelop.miraiexwrapper.domain.MiraiexOrder;
import com.andynordevelop.miraiexwrapper.domain.MiraiexPairEnum;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@Disabled
@SpringBootTest
public class MiraiexPrivateClientTest {

	@Autowired
	MiraiexPrivateClient miraiexPrivateClient;
	@Autowired
	private MiraiexClientConfiguration miraiexClientConfiguration;

	@Test
	public void testGetAccountBalance() throws Exception {
		MiraiexAccountBalance[] miraiexAccountBalances = miraiexPrivateClient.getMiraiExAccountBalance();

		for (MiraiexAccountBalance miraiexAccountBalance : miraiexAccountBalances) {
			System.out.println(miraiexAccountBalance);
		}
		Assert.notNull(miraiexAccountBalances, "Checking if balance check is not null");
	}

	@Test
	public void testGetDepositAddresses() throws Exception {
		MiraiexDepositAddress miraiexDepositAddress = miraiexPrivateClient.getMiraiexDepositAddresses();
		System.out.println(miraiexDepositAddress);

		Assert.notNull(miraiexDepositAddress, "Checking deposit addresses");
	}

	@Test
	public void testGetDeposithistory() throws Exception {
		MiraiexDepositHistory miraiexDepositHistory = miraiexPrivateClient.getMiraiexDepositHistory();

		System.out.println(miraiexDepositHistory);
		Assert.notNull(miraiexDepositHistory, "checking deposit history");
	}

	@Test
	public void testGetOrders() throws Exception {
		MiraiexOrder[] miraiexOrders = miraiexPrivateClient.getMiraiexOrders();
		for (MiraiexOrder miraiexOrder : miraiexOrders) {
			System.out.println(miraiexOrder);
		}
		Assert.notNull(miraiexOrders, "checking orders");
	}

	@Test
	public void testGetSpecificorders() throws Exception {
		MiraiexOrder[] miraiexOrders = miraiexPrivateClient.getMiraiexSpecificOrder(MiraiexPairEnum.BTCNOK);
		for (MiraiexOrder miraiexOrder : miraiexOrders) {
			System.out.println(miraiexOrder);
		}
		Assert.notNull(miraiexOrders, "checking order");
	}


	@Test
	public void testGetOrderHistory() throws Exception {
		MiraiexOrder[] miraiexOrders = miraiexPrivateClient.getMiraiexOrderHistory();
		for (MiraiexOrder miraiexOrder : miraiexOrders) {
			System.out.println(miraiexOrder);
		}
		Assert.notNull(miraiexOrders, "checking order");
	}

	@Test
	public void testGetSpecificOrderHistory() throws Exception {
		MiraiexOrder[] miraiexOrders = miraiexPrivateClient.getSpecificOrderHistory(MiraiexPairEnum.ADANOK);
		for (MiraiexOrder miraiexOrder : miraiexOrders) {
			System.out.println(miraiexOrder);
		}
		Assert.notNull(miraiexOrders, "checking order");
	}

	@Test
	public void testDate() {
		String stringDate = "2021-07-21T20:39:04.609Z";
		LocalDateTime date = LocalDateTime.parse(stringDate.substring(0,stringDate.length()-1));
		LocalDateTime now = LocalDateTime.now();
		date = date.plusHours(2);
		System.out.println("now : " + now);
		System.out.println("date : " + date);
		Duration duration = Duration.between(date, now);
		if (duration.toMinutes() > 5) {
			System.out.println("over 5 minutes");
		}
		System.out.println("minutes : " + duration.toMinutes());
	}

	@Test
	public void testDelete() throws Exception {

		miraiexPrivateClient.deleteOrderInSpecificMarket(MiraiexPairEnum.BTCNOK.name());
	}

	@Test
	public void testPrice() {
//		0,000089 XRP

		double accountBalance = 159.61;
		double x = accountBalance*1-accountBalance*0.005;
		double gebyr = accountBalance*0.005;
		System.out.println("totalprice " + x);
		System.out.println("gebyr " + gebyr);
		System.out.println(accountBalance*1-accountBalance*0.005);
		double amount = 0.11011206 *1281.52;
		System.out.println("amount value "+ amount);
	}


}
