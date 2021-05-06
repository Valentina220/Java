package ru.Makval;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Я\nхорошо\nзнаю\nJava\n");

        double num1 = (46 + 10) * (10 / 3);
        double num2 = (29) * (4) * (-15);
        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);

        int number = 10500;
        int result = (number/10)/10;
        System.out.println("Result1: " + result + "\n");

        double res =  3.6 * 4.1 * 5.9;
        System.out.println("Result2: " + res + "\n");

        Scanner num = new Scanner(System.in);
        int number1 = num.nextInt();
        int number2 = num.nextInt();
        int number3 = num.nextInt();
        System.out.println(number1 + "\n" + number2 + "\n" + number3 + "\n");


        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        if(b%2 != 0){
            System.out.println("Нечетное число");
        }
        else if(b%2 == 0 && b<100){
            System.out.println("Четное число");
        }
        else if((b%2==0) && (b>100)){
            System.out.println("Выход за пределы диапазона");
        }
    }
}
