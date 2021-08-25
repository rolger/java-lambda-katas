package stream.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;
import common.test.tool.entity.Shop;

public class Exercise7Test {
	private OnlineShoppingMall mall;

	@Before
	public void setup() {
		mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
	}

	@Test
	public void averageAge() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create {@link IntStream} with customer ages by using {@link Stream#mapToInt}
		 * Then calculate the average of ages by using {@link IntStream#average}
		 */
		IntStream ageStream = null;
		OptionalDouble average = null;

		assertThat(average.getAsDouble()).isEqualTo(28.7);
	}

	@Test
	public void howMuchToBuyAllItems() {
		List<Shop> shopList = this.mall.getShopList();

		/**
		 * Create {@link LongStream} with all items' prices using
		 * {@link Stream#mapToLong} Then calculate the sum of prices using
		 * {@link LongStream#sum}
		 */
		LongStream priceStream = null;
		long priceSum = 0;

		assertThat(priceSum).isEqualTo(60930L);
	}
}
