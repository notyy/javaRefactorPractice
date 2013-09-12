package com.github.notyy.testing.priceCalculatorWithDI;

import com.github.notyy.testing.common.DiscountDAO;
import com.github.notyy.testing.common.MessageSender;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class PriceCalculatorTest {

    @Ignore @Test public void testGetPrice() throws Exception {
        PriceCalculator priceCalculator = new PriceCalculator(new DiscountDAO(), new MessageSender());
        assertThat(priceCalculator.getPrice(10, 100.0), is(800.0));
    }

    @Ignore @Test
    public void should_return_price_calc_by_baseprice(){
        fail("not implemented");
    }

    @Ignore @Test
    public void should_throw_exception_if_quantity_is_too_small(){
        fail("not implemented");
    }

    @Ignore @Test
    public void should_send_message_if_database_error_occur(){
        fail("not implemented");
    }

}
