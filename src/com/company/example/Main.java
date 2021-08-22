package com.company.example;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final String[][] array = new String[3][3];
    private static boolean win = false;

    public static void main(String[] args) {
        printBoard();
        while (true) {
            checkWin();
            if (!win) {
                fillBoard1();
                printBoard();
                checkWin();
                if (win) {
                    System.out.println("Player with X has Won.");
                    break;
                }
                fillBoard2();
                printBoard();
                checkWin();
                if (win) {
                    System.out.println("Player with O has Won");
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println("Match Finished");
        checkWin();
        if (!win) {
            System.out.println("Match finished with no winners");
        }
    }

    public static void fillBoard1() {
        System.out.println("Enter the number to write X : ");
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
        System.out.println("Enter the number to write O : ");
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
        int i;
        for (i = 0; i < 3; i++) {
            int j;
            for (j = 0; j < 3; j++) {
                count++;
                if (!Objects.equals(array[i][j], "X") && !Objects.equals(array[i][j], "O")) {
                    array[i][j] = Integer.toString(count);
                }
                System.out.print("| " + array[i][j] + " | ");
            }
            System.out.println("\n-----------------");
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
}