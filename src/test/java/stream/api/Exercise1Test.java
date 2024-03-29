package stream.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;
import common.test.tool.util.AssertUtil;

public class Exercise1Test {
    private OnlineShoppingMall mall;

    @Before
    public void setup() {
	mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
    }

    @Test
    public void findRichCustomers() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a {@link Stream} from customerList only including customer who has
	 * more budget than 10000. Use lambda expression for Predicate and
	 * {@link Stream#filter} for filtering.
	 */
	Predicate<Customer> richCustomerCondition = null;
	Stream<Customer> richCustomerStream = null;

	assertTrue("Solution for Predicate should be lambda expression", AssertUtil.isLambda(richCustomerCondition));
	List<Customer> richCustomer = richCustomerStream.collect(Collectors.toList());

	assertThat(richCustomer).hasSize(2).contains(customerList.get(3), customerList.get(7));
    }

    @Test
    public void howOldAreTheCustomers() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a {@link Stream} from customerList with age values. Use method
	 * reference(best) or lambda expression(okay) for creating {@link Function}
	 * which will convert {@link Customer} to {@link Integer}, and then apply it by
	 * using {@link Stream#map}.
	 */
	Function<Customer, Integer> getAgeFunction = null;
	Stream<Integer> ageStream = null;

	assertTrue(AssertUtil.isLambda(getAgeFunction));
	List<Integer> ages = ageStream.collect(Collectors.toList());

	assertThat(ages).hasSize(10).contains(22, 27, 28, 38, 26, 22, 32, 35, 21, 36);
    }
}
