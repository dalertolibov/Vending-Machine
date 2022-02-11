package com.techelevator.data;

import org.w3c.dom.ls.LSOutput;

public class Product {

    private String name;
    //private String category;
    private String price;
    //private String slot;



    //Constructor

    public Product(String name, String price) {
        this.name = name;
        //this.category=category;
        this.price = price;
        //this.slot = slot;

    }


    //Getters and Setters


    //public String getCategory() {
       // return category;
   // }

   // public void setCategory(String category) {
    //    this.category = category;
   // }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //public String getSlot() {
    //    return slot;
  //  }

   // public void setSlot(String slot) {
   //     this.slot = slot;
    //}

  //  public String toString(){
   //     return slot+" "+name+" "+price+" "+category+" ";

    //}


}


