package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

    private Product sut;

    @Before
    public void setUp() {
        sut=new Gum("U-Chews","0.85");
    }
    @Test
    public void get_price_in_pennies_should_return_85(){
        Assert.assertEquals(85,sut.getPriceInPennies());
    }

    @Test
    public void get_eating_sound_should_return_chew_chew_yum() {

        Assert.assertEquals("\"Chew Chew, Yum!\"",sut.getEatingSound());
    }
}