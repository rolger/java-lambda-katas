package lambda;

import java.math.BigDecimal;

@FunctionalInterface
public interface BigDecimalMath {

	BigDecimal calculate(BigDecimal firstParameter, BigDecimal secondParameter);
	
}
