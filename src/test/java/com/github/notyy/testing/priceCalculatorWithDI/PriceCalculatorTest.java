package com.github.notyy.testing.priceCalculatorWithDI;

import com.github.notyy.testing.common.DiscountDAO;
import com.github.notyy.testing.common.MessageSender;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorTest {

    @Ignore @Test public void testGetPrice() throws Exception {
        PriceCalculator priceCalculator = new PriceCalculator(new DiscountDAO(), new MessageSender());
        assertThat(priceCalculator.getPrice(10, 100.0), is(800.0));
    }
}
