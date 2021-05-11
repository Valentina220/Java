package ru.Makval;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        oddNumbers(100);
        divisionCheck(100);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();
        System.out.println("Введите третье число: ");
        int c = scanner.nextInt();

        System.out.println("Результат: "+ checkSum(a,b,c));
        System.out.println("Результат: "+ checkNum(a,b,c));

        int[] number = {3, -3, 7, 4, 5, 4, 3};
        System.out.println("array = " + Arrays.toString(number));
        System.out.println(checkArr(number));
        Arrays.sort(number);
        //System.out.println( Arrays.toString(number));
        System.out.println(checkNumbArr(number));

    }

    public static void oddNumbers(int range) {
        for (int i = 1; i < range; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void divisionCheck(int range) {
        for (int i = 1; i <= range; i++) {

            if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("Делится на 3: " + i);
            } else if (i % 5 == 0 && i % 3 != 0) {
                System.out.println("Делится на 5: " + i);
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Делится на 3 и на 5: " + i);
            }
        }
    }

    public static boolean checkSum(int a, int b, int c) {

        if (a + b == c) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkNum(int a, int b, int c) {

        if (b > a && c > b) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkArr(int[] number) {
        if (number[0] == 3 || number.length == 3) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkNumbArr(int[] number) {
       boolean res = false;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == 3 || number[i] == 1) {
                res =true;
            }
        }
        return res;
    }
}


