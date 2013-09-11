package com.github.notyy.reafactoring.priceCaculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PriceCalculatorTest {
    @Test
    public void testGetPrice() throws Exception {
        PriceCalculator priceCalculator = new PriceCalculator();
        assertThat(priceCalculator.getPrice(10,100.0), is(800.0));
        assertThat(priceCalculator.getPrice(9,100.0), is(810.0));
    }
}
