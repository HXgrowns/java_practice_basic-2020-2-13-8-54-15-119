package com.thoughtworks;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant();
        while (true) {
            String ordeInfo = scanner.nextLine();
          if (!ordeInfo.contains("ITEM")) {
            break;
          }
            String result = restaurant.bestCharge(ordeInfo);
            System.out.println(result);
        }
        System.out.println("点餐结束");
    }
}


