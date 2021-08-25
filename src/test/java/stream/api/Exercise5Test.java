package stream.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;

public class Exercise5Test {
	private OnlineShoppingMall mall;

	@Before
	public void setup() {
		mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
	}

	@Test
	public void nameList() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a list of customer names by using {@link Stream#collect} and
		 * {@link Collectors#toList}
		 */
		List<String> nameList = null;

		assertThat(nameList) //
				.contains("Joe", "Steven", "Patrick", "Diana", "Chris", "Kathy", "Alice", "Andrew", "Martin", "Amy");
	}

	@Test
	public void ageSet() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a set of customer age by using {@link Stream#collect} and
		 * {@link Collectors#toSet}
		 */
		Set<Integer> ageSet = null;

		assertThat(ageSet).hasSize(9).contains(21, 22, 26, 27, 28, 32, 35, 36, 38);
	}

	@Test
	public void nameInCsv() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a csv string of customer names in brackets "[]" by using
		 * {@link Collectors#joining}
		 */
		String string = null;

		assertThat(string).isEqualTo("[Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy]");
	}

	@Test
	public void oldestCustomer() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Get the oldest customer by using {@link Collectors#maxBy}. Don't use any
		 * intermediate operations.
		 */
		Optional<Customer> oldestCustomer = null;

		assertThat(oldestCustomer).hasValue(customerList.get(3));
	}

	@Test
	public void ageDistribution() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Create a map of age as key and number of customers as value using
		 * {@link Collectors#groupingBy} and {@link Collectors#counting}
		 */
		Map<Integer, Long> ageDistribution = null;

		assertThat(ageDistribution).hasSize(9);
		ageDistribution.forEach((k, v) -> {
			if (k.equals(22)) {
				assertThat(v).isEqualTo(2L);
			} else {
				assertThat(v).isEqualTo(1L);
			}
		});
	}
}
