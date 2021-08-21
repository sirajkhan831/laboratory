package com.company.example;

import java.util.Scanner;

public class Main {
    private static int[][] array = new int[3][3];
    private static boolean win = false;

    public static void main(String[] args) {
        printBoard();
        while (true) {
            checkWin();
            if (!win) {
                fillBoard();
                printBoard();
            } else {
                System.out.println("Player has won");
                break;
            }
        }
    }

    public static void fillBoard() {
        System.out.println("Enter the number to write X : ");
        Scanner writeScan = new Scanner(System.in);
        int write = writeScan.nextInt();
        switch (write) {
            case 11 -> array[0][0] = 8;
            case 12 -> array[0][1] = 8;
            case 13 -> array[0][2] = 8;
            case 14 -> array[1][0] = 8;
            case 15 -> array[1][1] = 8;
            case 16 -> array[1][2] = 8;
            case 17 -> array[2][0] = 8;
            case 18 -> array[2][1] = 8;
            case 19 -> array[2][2] = 8;
        }
    }

    public static void printBoard() {
        int count = 10;
        int i;
        for (i = 0; i < 3; i++) {
            int j;
            for (j = 0; j < 3; j++) {
                count++;
                if (array[i][j] != 8) {
                    array[i][j] = count;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void checkWin() {
        if (array[0][0] == array[0][1] && array[0][0] == array[0][2])
        {
            win = true;
        }
        else if (array[0][0] == array[1][0] && array[0][0] == array[2][0])
            win = true;
        else if (array[0][0] == array[1][1] && array[0][0] == array[2][2])
            win = true;
    }
}