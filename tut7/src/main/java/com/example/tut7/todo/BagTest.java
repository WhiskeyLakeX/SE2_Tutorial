package com.example.tut7.todo;

public class BagTest {
    public static  void  main (String [] args) {
        BagInterface<String> sports = new ArrayBag<String>();
        System.out.println("Initial size: " + sports.getCurrentSize());
        sports.add("Football");
        sports.add("Badminton");
        System.out.println("Current size:" +sports.getCurrentSize());
        sports.remove("Badminton");
        System.out.println("Current size:"+ sports.getCurrentSize() );
        System.out.println("Total appearance of Football: "+sports.getFrequencyOf("Football"));
        sports.add("Football");
        System.out.println("Total appearance of Football: "+sports.getFrequencyOf("Football"));
        sports.clear();
        System.out.println("Current size:"+ sports.getCurrentSize() );
    }
}
