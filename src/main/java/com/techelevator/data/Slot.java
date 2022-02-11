package com.techelevator.data;

public class Slot {
    private int size;
    private String name;

    public Slot( String name) {
        this.size = 5;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
