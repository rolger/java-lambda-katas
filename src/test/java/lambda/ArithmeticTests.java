package lambda;

import static common.test.tool.util.AssertUtil.isLambda;
import static common.test.tool.util.AssertUtil.isNotLambda;

import java.math.BigDecimal;
import java.util.function.BiFunction;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArithmeticTests {

	@Test
	public void shouldAddTwoNumbersWithAnonymousClass() {
		/*
		 * TODO: Implement a sum here with a class.
		 */
		BigDecimalMath function = null;

		BigDecimal result = function.calculate(BigDecimal.valueOf(6), BigDecimal.valueOf(32));

		Assertions.assertThat(isNotLambda(function)).isTrue();
		// TODO: fix the assertion
		Assertions.assertThat(result).isEqualTo(BigDecimal.ZERO);
	}

	@Test
	public void shouldAddTwoNumbers() {
		/*
		 * TODO: Implement a sum here with a lambda.
		 */
		BigDecimalMath function = null;

		BigDecimal result = function.calculate(BigDecimal.valueOf(6), BigDecimal.valueOf(32));

		Assertions.assertThat(isLambda(function)).isTrue();
		// TODO: fix the assertion
		Assertions.assertThat(result).isEqualTo(BigDecimal.ZERO);
	}

	@Test
	public void shouldMultiplyTwoNumbers() {
		/*
		 * TODO: Implement a product here with a lambda.
		 */
		BigDecimalMath function = null;

		BigDecimal result = function.calculate(BigDecimal.valueOf(121), BigDecimal.valueOf(3));

		Assertions.assertThat(isLambda(function)).isTrue();
		// TODO: fix the assertion
		Assertions.assertThat(result).isEqualTo(BigDecimal.ZERO);
	}

	@Test
	public void shouldSubstractTwoNumbers() {
		/*
		 * TODO: Implement a substraction here with a lambda.
		 */
		BigDecimalMath function = null;

		BigDecimal result = function.calculate(BigDecimal.valueOf(81), BigDecimal.valueOf(45));

		Assertions.assertThat(isLambda(function)).isTrue();
		// TODO: fix the assertion
		Assertions.assertThat(result).isEqualTo(BigDecimal.ZERO);
	}

	@Test
	public void shouldAddTwoNumbersWithJavaFunctionAndAnonymousClass() {
		/*
		 * TODO: Implement a sum here with a lambda.
		 */
		BiFunction<BigDecimal, BigDecimal, BigDecimal> function = null;

		// TODO: call the function with BigDecimal.valueOf(4), BigDecimal.valueOf(3)
		BigDecimal result = null;

		Assertions.assertThat(isNotLambda(function)).isTrue();
		// TODO: fix the assertion
		Assertions.assertThat(result).isEqualTo(BigDecimal.ZERO);
	}

	@Test
	public void shouldAddTwoNumbersWithJavaFunction() {
		/*
		 * TODO: Implement a sum here with a lambda.
		 */
		BiFunction<BigDecimal, BigDecimal, BigDecimal> function = null;

		// TODO: call the function with BigDecimal.valueOf(4), BigDecimal.valueOf(3)
		BigDecimal result = null;

		Assertions.assertThat(isLambda(function)).isTrue();
		// TODO: fix the assertion
		Assertions.assertThat(result).isEqualTo(BigDecimal.ZERO);
	}

}
