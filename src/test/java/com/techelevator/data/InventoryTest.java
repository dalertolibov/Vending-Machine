package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {

    private Inventory sut;

    @Before
    public void setup() {
        sut = new Inventory(new FileReaderCSV());
    }


    @Test
    public void starting_inventory_returns_5() {
        Assert.assertEquals( 5, sut.returnCurrentInventory("A1"));
    }

    @Test
    public void inventory_subtracts_and_updates_quantity() {
        sut.subtractFromInventory("A1");
        Assert.assertEquals( 4, sut.returnCurrentInventory("A1"));
    }


}