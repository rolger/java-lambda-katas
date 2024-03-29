package stream.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.OnlineShoppingMall;
import common.test.tool.util.CollectorImpl;

public class Exercise9Test {
    private OnlineShoppingMall mall;

    @Before
    public void setup() {
	mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
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

    @Test
    public void simplestStringJoin() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Implement a {@link Collector} which can create a String with comma separated
	 * names shown in the assertion. The collector will be used by serial stream.
	 */
	Supplier<Object> supplier = null;
	BiConsumer<Object, String> accumulator = null;
	BinaryOperator<Object> combiner = null;
	Function<Object, String> finisher = null;

	Collector<String, ?, String> toCsv = new CollectorImpl<>(supplier, accumulator, combiner, finisher,
		Collections.emptySet());
	String nameAsCsv = customerList.stream().map(Customer::getName).collect(toCsv);
	assertThat(nameAsCsv).isEqualTo("Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy");
    }

    @Test
    public void mapKeyedByItems() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Implement a {@link Collector} which can create a {@link Map} with keys as
	 * item and values as {@link Set} of customers who are wanting to buy that item.
	 * The collector will be used by parallel stream.
	 */
	Supplier<Object> supplier = null;
	BiConsumer<Object, Customer> accumulator = null;
	BinaryOperator<Object> combiner = null;
	Function<Object, Map<String, Set<String>>> finisher = null;

	Collector<Customer, ?, Map<String, Set<String>>> toItemAsKey = new CollectorImpl<>(supplier, accumulator,
		combiner, finisher,
		EnumSet.of(Collector.Characteristics.CONCURRENT, Collector.Characteristics.IDENTITY_FINISH));
	Map<String, Set<String>> itemMap = customerList.stream().parallel().collect(toItemAsKey);
	assertThat(itemMap.get("plane")).contains("Chris");
	assertThat(itemMap.get("onion")).contains("Patrick", "Amy");
	assertThat(itemMap.get("ice cream")).contains("Patrick", "Steven");
	assertThat(itemMap.get("earphone")).contains("Steven");
	assertThat(itemMap.get("plate")).contains("Joe", "Martin");
	assertThat(itemMap.get("fork")).contains("Joe", "Martin");
	assertThat(itemMap.get("cable")).contains("Diana", "Steven");
	assertThat(itemMap.get("desk")).contains("Alice");
    }

    @Test
    public void bitList2BitString() {
	String bitList = "22-24,9,42-44,11,4,46,14-17,5,2,38-40,33,50,48";

	/**
	 * Create a {@link String} of "n"th bit ON. for example "3" will be "001"
	 * "1,3,5" will be "10101" "1-3" will be "111" "7,1-3,5" will be "1110101"
	 */
	Collector<String, ?, String> toBitString = null;

	String bitString = Arrays.stream(bitList.split(",")).collect(toBitString);
	assertThat(bitList).isEqualTo("01011000101001111000011100000000100001110111010101");
    }

}
