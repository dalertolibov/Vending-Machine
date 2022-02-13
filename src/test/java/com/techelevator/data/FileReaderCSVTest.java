package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileReaderCSVTest {

    private FileReaderCSV sut;

    @Before
    public void setup() {
        sut = new FileReaderCSV();
    }

    @Test
    public void map_location_and_product_d3_return_chiclets () {
        Assert.assertEquals("Chiclets", sut.mapLocationAndProduct().get("D3").getName());
    }

    @Test
    public void map_location_and_product_a4_return_cloud_popcorn() {
        Assert.assertEquals("3.65", sut.mapLocationAndProduct().get("A4").getPriceAsString());
    }


}