package stream.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Test;

import common.test.tool.entity.Customer;
import common.test.tool.entity.Item;
import common.test.tool.entity.OnlineShoppingMall;
import common.test.tool.entity.Shop;
import common.test.tool.util.AssertUtil;

public class Exercise7Test {
    private OnlineShoppingMall mall;

    @Before
    public void setup() {
	mall = JAXB.unmarshal(new File("src/test/resources/data.xml"), OnlineShoppingMall.class);
    }

    @Test
    public void itemsCustomersWantToBuy() {
	List<Customer> customerList = this.mall.getCustomerList();

	/**
	 * Create a stream with items' names stored in {@link Customer.wantToBuy}. Use
	 * {@link Stream#flatMap} to create a stream from each element of a stream.
	 */
	Function<Customer, Stream<Item>> getItemStream = null;
	Stream<String> itemStream = null;

	assertTrue(AssertUtil.isLambda(getItemStream));
	List<String> itemList = itemStream.collect(Collectors.toList());
	assertThat(itemList).contains("small table", "plate", "fork", "ice cream", "screwdriver", "cable", "earphone",
		"onion", "ice cream", "crisps", "chopsticks", "cable", "speaker", "headphone", "saw", "bond", "plane",
		"bag", "cold medicine", "chair", "desk", "pants", "coat", "cup", "plate", "fork", "spoon", "ointment",
		"poultice", "spinach", "ginseng", "onion");
    }

    @Test
    public void howMuchToBuyAllItems() {
	List<Shop> shopList = this.mall.getShopList();

	/**
	 * Create {@link LongStream} with all items' prices stored in
	 * {@link Shop.getItemList} using {@link Stream#mapToLong}. Then calculate the
	 * sum of prices using {@link LongStream#sum}
	 */
	LongStream priceStream = null;
	long priceSum = 0;

	assertThat(priceSum).isEqualTo(60930L);
    }

    @Test
    public void cheapestPriceOfAnItem() {
	List<Shop> shopList = this.mall.getShopList();

	/**
	 * Create a stream with items' names stored in {@link Shop.getItemList}. Use
	 * {@link Stream#flatMap} to create a stream from each element of a stream.
	 */
	List<Item> itemsInShops = null;

	Integer cheapestPriceForSpinach = cheapestPriceFor("spinach", itemsInShops.stream());
	assertThat(cheapestPriceForSpinach).isEqualTo(100);

	Integer cheapestPriceForPc = cheapestPriceFor("pc", itemsInShops.stream());
	assertThat(cheapestPriceForPc).isZero();

	Integer cheapestPriceForChair = cheapestPriceFor("chair", itemsInShops.stream());
	assertThat(cheapestPriceForChair).isEqualTo(600);
    }

    /**
     * Filter the stream of items' by its name with {@link Stream#filter} and find
     * the cheapest item using {@link Stream#min}. Returns 0 if the price or the
     * item is not found.
     */
    private Integer cheapestPriceFor(String itemName, Stream<Item> itemsInShops) {
	return null;
    }

}
