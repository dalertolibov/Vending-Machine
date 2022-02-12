package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipTest {
    private Product sut;

    @Before
    public void setUp() {
        sut=new Chip("Cloud Popcorn","3.65");
    }

    @Test
    public void get_price_in_pennies_should_return_399(){
        Assert.assertEquals(365,sut.getPriceInPennies());}

    @Test
    public void get_eating_sound_should_return_crunch_creunch_yum() {
        Assert.assertEquals("\"Crunch Crunch, Yum!\"",sut.getEatingSound());

    }
}