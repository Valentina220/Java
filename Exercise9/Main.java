package ru.Makval;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        System.out.println("Определите размер массива");
        System.out.println("Введите количество строк: ");
        int m = scanner.nextInt();
        System.out.println("Введите количество столбцов: ");
        int n = scanner.nextInt();

        int[][] array = new int[m][n];
        //int[][] arr = new int[m][n];

        fillArray(array,m,n);
        showArray(array,m,n);
        //showArray(arr,m,n);

        maxValue(array,m,n);
        isCub(m,n);
        maxRow(array,m,n);
        fill_asAlphabet(m,n);

    }


    public static void fillArray(int[][] array, int m, int n){
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                array[i][j] = ((int)(Math.random() * 50) + 1 );
            }
        }
    }

    public static void showArray(int[][] array, int m, int n){
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void maxValue(int[][] array, int m, int n){
        int max = 0;
        //int count = 0;

        if (array == null) {
            throw new NullPointerException("Массив не должен быть равен null");
        }

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (array[i][j] > max) {
                        max = array[i][j];
                }
            }
        }

        System.out.println("Максимальный элемент массива: " + max);
    }

    public static void isCub(int m, int n){
        if (m == 0 || n == 0) {
            throw new IllegalArgumentException("Массив должен содержать хотя бы 1 строку и 1 столбец");
        }

        if (m == n)
            System.out.println("Массив квадратный");
        else
            System.out.println("Массив не является квадратным");

    }

    public static void maxRow(int[][] array, int m, int n){

        if (m <= 1 ) {
            throw new IllegalArgumentException("Для поиска массив должен иметь хотя бы 2 строки");
        }

        int Row_numb = 0;     // номер строки с макс. суммой
        int maxRow_sum = 0;

        for(int i = 0; i < m; i++){
            int rowSum = 0;
            for (int j = 0; j < n; j++){
                rowSum += array[i][j];
                if(rowSum > maxRow_sum)
                    maxRow_sum = rowSum;
                    Row_numb = i;
            }
        }
        System.out.println("В строке № " + (Row_numb + 1) + " сумма элементов максимальна");
    }

    public static void fill_asAlphabet(int m, int n){
        if (m == 0 || n == 0) {
            throw new IllegalArgumentException("Массив должен содержать хотя бы 1 строку и 1 столбец");
        }

        char[][] newArr = new char [m][n];
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int number = (int)(Math.random() * 26) + 65;
                newArr[i][j] = (char) number;
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }


}
