package com.company;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<Inventory> productsinstock = new ArrayList<Inventory>();
        Inventory ts = new Inventory();
        ts.setInvproducts("Red-Hot Spicy Doritos");
        ts.setInvprices(2.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Cool Ranch Doritos");
        ts.setInvprices(2.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Coke");
        ts.setInvprices(0.99);
        productsinstock.add(ts);


        ts = new Inventory();
        ts.setInvproducts(" Diet Coke");
        ts.setInvprices(0.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Pepsi");
        ts.setInvprices(0.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Five Hour Energy");
        ts.setInvprices(0.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Sunflower Seeds");
        ts.setInvprices(3.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Peanuts");
        ts.setInvprices(0.99);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Mac Book Chargers");
        ts.setInvprices(120.00);
        productsinstock.add(ts);

        ts = new Inventory();
        ts.setInvproducts("Dell Chargers");
        ts.setInvprices(50.00);
        productsinstock.add(ts);

        String answer = "";
        String response = "";
        ArrayList<CustomerName> customerlist = new ArrayList<CustomerName>();

        ArrayList<Purchases> purchaselist = new ArrayList<Purchases>();
        Scanner input = new Scanner(System.in);
        double price;
        price = 0.00;
        double custprice = 0.00;
        String name = "";
        String order = "";
        int quantity = 0;

        do {
            System.out.println("What do you want to do?");
            System.out.println("1) add purchase 3) finish transaction");
            answer = input.nextLine();

            if (answer.equals("1")) {
                System.out.println("Customer's name:");
                name = input.nextLine();

                String custorder = "";

                do {
                    System.out.println("What did they buy?");
                    System.out.println("Enter 2 if you want to move on to the next customer");
                    response = input.nextLine();
                    if (response.equals("2")){continue;}



                    for (int i = 0; i < productsinstock.size(); i++) {
                        if (response.equals(productsinstock.get(i).getInvproducts())){
                            price = productsinstock.get(i).getInvprices();
                            custprice += price;


                        }
                    }
                    Purchases pts = new Purchases();
                    pts.setPurchproduct(response);
                    pts.setPurchprice(price);
                    purchaselist.add(pts);
                    custorder += response + "\n";



                } while (!response.equals("2"));

                CustomerName cts = new CustomerName();
                cts.setCustname(name);
                cts.setCustorder(custorder);
                cts.setOrderprice(custprice);
                customerlist.add(cts);
                custprice = 0.00;
            }


        } while (!answer.equals("3"));
        System.out.println("Closing");
        System.out.println("Receipt");
        System.out.println("");


        for (int i = 0; i < customerlist.size(); i++) {
            System.out.println(customerlist.get(i).getCustname());
            System.out.println(customerlist.get(i).getCustorder());
            System.out.println(customerlist.get(i).getOrderprice());


        }


            double totalcost = 0.0;
            for (int j = 0; j < purchaselist.size(); j++) {
                totalcost += purchaselist.get(j).getPurchprice();

            }

        System.out.println("Inventory Sold");


        for (int i = 0; i < purchaselist.size(); i++) {
            System.out.println(purchaselist.get(i).getPurchproduct());
        }
        System.out.println("Grandtotal: " + totalcost);




    }
}



