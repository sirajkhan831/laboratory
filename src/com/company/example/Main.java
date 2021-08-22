package com.company.example;

import java.util.Scanner;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        int store = 0;
        int store1 = 0;
        while (store <= 99 && store1 <= 99) {
            int roll = roll();
            System.out.println("PLayer1 got : " + roll);
            store += roll;
            System.out.println("Player1 is now at : " + store);
            if (store > 100) {
                store -= roll;
                System.out.println("Player 1 can not surpass 100 and is reverted back to : " + store);
            }
            if (store < 89 && store > 11) {
                switch (luck()) {
                    case 1 -> {
                        store += roll;
                        System.out.println("Player1 got a ladder is now at : " + store);
                    }
                    case 2 -> {
                        store -= 2 * roll;
                        System.out.println("Player1 got a snake is now at : " + store);
                    }
                }
            }
            int roll2 = roll2();
            System.out.println("Player2 got : " + roll2);
            store1 += roll2;
            System.out.println("Player2 is now at : " + store1);
            if (store1 > 100) {
                store1 -= roll2;
                System.out.println("Player 2 can not surpass 100 and is reverted back to : " + store1);
            }
            if (store1 < 89 && store1 > 11) {
                switch (luck()) {
                    case 1 -> {
                        store1 += roll2;
                        System.out.println("Player2 got a ladder is now at : " + store1);
                    }
                    case 2 -> {
                        store1 -= 2 * roll2;
                        System.out.println("Player2 got a snake is now at : " + store1);
                    }
                }
            }
        }
        System.out.println("Player 1 finished in : " + store);
        System.out.println("Player 2 finished in : " + store1);
        if (store > store1) {
            System.out.println("Player 1 has won the game. The total number of time the dice was rolled per player is : " + count);
        } else
            System.out.println("Player 2 has won the game. The total number of time the dice was rolled per player is : " + count);
    }

    public static int roll() {
        count++;
        return (int) Math.floor(Math.random() * 6) + 1;
    }

    public static int roll2() {
        return (int) Math.floor(Math.random() * 6) + 1;
    }

    public static int luck() {
        return (int) Math.floor(Math.random() * 3);
    }

}