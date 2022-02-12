package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CandyTest {
    private Product sut;

    @Before
    public void setUp() throws FileNotFoundException {
       sut=new Candy("Cowtales","3.99");
    }


    @Test
    public void get_price_in_pennies_should_return_399(){
        Assert.assertEquals(399,sut.getPriceInPennies());
    }

    @Test
    public void get_eating_sound_should_return_munch_munch_yum() {

        Assert.assertEquals("\"Munch Munch, Yum!\"",sut.getEatingSound());
    }
}