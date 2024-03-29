package stream.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;
import common.test.tool.util.AssertUtil;

public class Exercise2Test {
    private OnlineShoppingMall mall;

    @Before
    public void setup() {
	mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
    }

    @Test
    public void sortByAge() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a stream with ascending ordered age values. Use {@link Stream#sorted}
	 * to sort them.
	 */
	Stream<Integer> sortedAgeStream = null;

	List<Integer> sortedAgeList = sortedAgeStream.collect(Collectors.toList());
	assertThat(sortedAgeList).containsExactly(21, 22, 22, 26, 27, 28, 32, 35, 36, 38);
    }

    @Test
    public void descSortByAge() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a stream with descending ordered age values.
	 */
	Comparator<Integer> descOrder = null;
	Stream<Integer> sortedAgeStream = null;

	assertTrue(AssertUtil.isLambda(descOrder));
	List<Integer> sortedAgeList = sortedAgeStream.collect(Collectors.toList());
	assertThat(sortedAgeList).containsExactly(38, 36, 35, 32, 28, 27, 26, 22, 22, 21);
    }

    @Test
    public void top3RichCustomer() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a stream with top 3 rich customers using {@link Stream#limit} to limit
	 * the size of the stream
	 */
	Stream<String> top3RichCustomerStream = null;

	List<String> top3RichCustomerList = top3RichCustomerStream.collect(Collectors.toList());
	assertThat(top3RichCustomerList).contains("Diana", "Andrew", "Chris");
    }

    @Test
    public void distinctAge() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a stream with distinct age values using {@link Stream#distinct}
	 */
	Stream<Integer> distinctAgeStream = null;

	List<Integer> distinctAgeList = distinctAgeStream.collect(Collectors.toList());
	assertThat(distinctAgeList).contains(22, 27, 28, 38, 26, 32, 35, 21, 36);
    }

}
