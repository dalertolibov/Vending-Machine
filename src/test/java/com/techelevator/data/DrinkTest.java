package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
    private Product sut;

    @Before
    public void setUp() {
        sut=new Drink("Dr. Salt","1.50");
    }
    @Test
    public void get_price_in_pennies_should_return_150(){
        Assert.assertEquals(150,sut.getPriceInPennies());
    }

    @Test
    public void get_eating_sound_should_return_munch_munch_yum() {

        Assert.assertEquals("\"Glug Glug, Yum!\"",sut.getEatingSound());
    }
}