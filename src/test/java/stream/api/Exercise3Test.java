package stream.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;

public class Exercise3Test {
	private OnlineShoppingMall mall;

	@Before
	public void setup() {
		mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
	}

	@Test
	public void howManyItemsWanted() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Count how many items there are in {@link Customer.wantToBuy} using
		 * {@link Stream#count}
		 */
		long sum = 0L;

		assertThat(sum, is(32L));
	}

	@Test
	public void richestCustomer() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Find the richest customer's budget by using {@link Stream#max} and
		 * {@link Comparator#naturalOrder} Don't use {@link Stream#sorted}
		 */
		Comparator<Integer> comparator = null;
		Optional<Integer> richestCustomer = null;

		assertThat(comparator.getClass().getSimpleName(), is("NaturalOrderComparator"));
		assertThat(richestCustomer.get(), is(12000));
	}

	@Test
	public void youngestCustomer() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Find the youngest customer by using {@link Stream#min} Don't use
		 * {@link Stream#sorted}
		 */
		Comparator<Customer> comparator = null;
		Optional<Customer> youngestCustomer = null;

		assertThat(youngestCustomer.get(), is(customerList.get(8)));
	}
}
