package stream.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

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
	 * Count how many items there are in {@link Customer.wantToBuy}
	 */
	long sum = 0L;

	assertThat(sum).isEqualTo(32L);
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

	assertThat(comparator.getClass().getSimpleName()).isEqualTo("NaturalOrderComparator");
	assertThat(richestCustomer).hasValue(12000);
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

	assertThat(youngestCustomer).hasValue(customerList.get(8));
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

}
