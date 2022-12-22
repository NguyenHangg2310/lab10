package com.oop.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TestApp {
    public static void main(String[] args) throws ParseException {
        Item item1 = new Book("Soffocare", 2002,170);
        Item item2 = new Book("Moon", 2011,130);

        Student student1 = new Student("0001","Darell","Abbott");
        Student student2 = new Student("0002","Nick","Drake");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Rent[] rents = new Rent[5];
        rents[0] = new Rent(item1, student1, sdf.parse("15/06/2020"), sdf.parse("15/06/2020"));
        rents[1] = new Rent(item1, student2, sdf.parse("10/07/2020"), sdf.parse("20/07/2020"));
        rents[2] = new Rent(item1, student1, sdf.parse("15/08/2020"), sdf.parse("14/11/2020"));
        rents[3] = new Rent(item2, student2, sdf.parse("10/07/2020"), sdf.parse("20/07/2020"));
        rents[4] = new Rent(item2, student1, sdf.parse("25/08/2020"), sdf.parse("28/08/2020"));

         Library l = new Library(rents);
        System.out.println(l.getLongestRent());


    }
}
