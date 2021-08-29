package com.company.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final String[][] array = new String[3][3];
    private static boolean win = false;
    private static int attempt = 0;

    public static void main(String[] args) {
        start();
    }

    public static void fillBoard1() {
        attempt++;
        System.out.print("\nEnter the number to write X : ");
        Scanner writeScan = new Scanner(System.in);
        int write = writeScan.nextInt();
        switch (write) {
            case 1 -> array[0][0] = "X";
            case 2 -> array[0][1] = "X";
            case 3 -> array[0][2] = "X";
            case 4 -> array[1][0] = "X";
            case 5 -> array[1][1] = "X";
            case 6 -> array[1][2] = "X";
            case 7 -> array[2][0] = "X";
            case 8 -> array[2][1] = "X";
            case 9 -> array[2][2] = "X";
        }
    }

    public static void fillBoard2() {
        attempt++;
        System.out.print("\nEnter the number to write O : ");
        Scanner writeScan = new Scanner(System.in);
        int write = writeScan.nextInt();
        switch (write) {
            case 1 -> array[0][0] = "O";
            case 2 -> array[0][1] = "O";
            case 3 -> array[0][2] = "O";
            case 4 -> array[1][0] = "O";
            case 5 -> array[1][1] = "O";
            case 6 -> array[1][2] = "O";
            case 7 -> array[2][0] = "O";
            case 8 -> array[2][1] = "O";
            case 9 -> array[2][2] = "O";
        }
    }

    public static void printBoard() {
        int count = 0;
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length; j++) {
                count++;
                if (!Objects.equals(array[i][j], "X") && !Objects.equals(array[i][j], "O")) {
                    array[i][j] = Integer.toString(count);
                }
                System.out.print(" " + array[i][j] + " ");
                if (j < array.length - 1) {
                    System.out.print(" | ");
                }
            }
            if (i < array.length - 1) {
                System.out.println("\n----|-----|----");
            }
        }
    }

    public static void checkWin() {
        if (Objects.equals(array[0][0], array[0][1]) && Objects.equals(array[0][0], array[0][2])) {
            win = true;
        } else if (Objects.equals(array[0][0], array[1][0]) && Objects.equals(array[0][0], array[2][0]))
            win = true;
        else if (Objects.equals(array[0][0], array[1][1]) && Objects.equals(array[0][0], array[2][2]))
            win = true;
        else if (Objects.equals(array[1][0], array[1][1]) && Objects.equals(array[1][0], array[1][2]))
            win = true;
        else if (Objects.equals(array[2][0], array[2][1]) && Objects.equals(array[2][0], array[2][2]))
            win = true;
        else if (Objects.equals(array[0][1], array[1][1]) && Objects.equals(array[0][1], array[2][1]))
            win = true;
        else if (Objects.equals(array[0][2], array[1][2]) && Objects.equals(array[0][2], array[2][2]))
            win = true;
        else if (Objects.equals(array[0][2], array[1][1]) && Objects.equals(array[0][2], array[2][0]))
            win = true;
    }

    public static void start() {
        printBoard();
        while (true) {
            checkWin();
            fillBoard1();
            printBoard();
            checkWin();
            if (win) {
                System.out.println("\n\nPlayer with 'X' has Won.");
                break;
            }
            fillBoard2();
            printBoard();
            checkWin();
            if (win) {
                System.out.println("\n\nPlayer with 'O' has Won");
                break;
            }
            if (attempt > 7) {
                System.out.println("\nNo more possible plays remaining.");
                break;
            }
        }
        System.out.println("\nMatch finished");
        checkWin();
        if (!win) {
            System.out.println("\nMatch finished with no winners");
        }
    }
}
// Created by Siraj Khan