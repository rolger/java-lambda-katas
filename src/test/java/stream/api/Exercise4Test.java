package stream.api;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;

public class Exercise4Test {
	private OnlineShoppingMall mall;

	@Before
	public void setup() {
		mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
	}

	@Test
	public void firstRegistrant() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Find the first customer who registered this online store by using
		 * {@link Stream#findFirst} The customerList are ascending ordered by registered
		 * timing.
		 */
		Optional<Customer> firstCustomer = null;

		assertThat(firstCustomer.get(), is(customerList.get(0)));
	}

	@Test
	public void isThereAnyoneOlderThan40() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Check whether any customer older than 40 exists or not, by using
		 * {@link Stream#anyMatch}
		 */
		boolean olderThan40Exists = true;

		assertThat(olderThan40Exists, is(false));
	}

	@Test
	public void isEverybodyOlderThan20() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Check whether all customer are older than 20 or not, by using
		 * {@link Stream#allMatch}
		 */
		boolean allOlderThan20 = false;

		assertThat(allOlderThan20, is(true));
	}

	@Test
	public void everyoneWantsSomething() {
		List<Customer> customerList = this.mall.getCustomerList();

		/**
		 * Confirm that none of the customer has empty list for their
		 * {@link Customer.wantToBuy} by using {@link Stream#noneMatch}
		 */
		boolean everyoneWantsSomething = false;

		assertThat(everyoneWantsSomething, is(true));
	}
}
