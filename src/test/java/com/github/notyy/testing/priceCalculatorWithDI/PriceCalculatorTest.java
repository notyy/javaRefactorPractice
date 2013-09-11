package com.github.notyy.testing.priceCalculatorWithDI;

import com.github.notyy.testing.common.DiscountDAO;
import com.github.notyy.testing.common.MessageSender;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    @Ignore @Test public void testGetPrice() throws Exception {
        PriceCalculator priceCalculator = new PriceCalculator(new DiscountDAO(), new MessageSender());
        assertThat(priceCalculator.getPrice(10, 100.0), is(800.0));
    }

    @Test
    public void should_throw_exception_if_quantity_is_too_small(){
        PriceCalculator priceCalculator = new PriceCalculator(new DiscountDAO(), new MessageSender());
        try{
            priceCalculator.getPrice(50, 100.0);
            fail("should throw exception");
        }catch (IllegalArgumentException ex){
            assertTrue("quantity too small", true);
        }
    }

    @Test
    public void should_return_price_calc_by_baseprice(){
        fail("not implemented");
    }

    @Test
    public void should_throw_exception_if_base_price_is_too_large(){
        fail("not implemented");
    }
}
