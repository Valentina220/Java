package ru.Makval;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //Задание 1
        //int[] array = {1,14,13,4,5,16,7,3,9,10,11,12,2};
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(Arrays.toString(array));
        System.out.println(ascendingChecking(array));

        // Задание 2
        Scanner scanner = new Scanner(System.in);

        System.out.println("Array length: ");
        int arrayLength = scanner.nextInt();
        System.out.println("Numbers of array: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        System.out.println("Result: " + Arrays.toString(makeArray(arrayLength,a,b,c,d))+"\n");


        //Задание 3
        System.out.println("Array 1: " + Arrays.toString(makeArray(arrayLength,a,b,c,d)));
        System.out.println("Array 2: " + Arrays.toString(swapElements(makeArray(arrayLength,a,b,c,d))));

        //Задание 4

        int[] array1 = {1, 2, 3, 1, 1, 2, 4, 2};
        System.out.println(uniqueNumber(bubbleSort(array1)));

        //Задание 5
        System.out.println("Введите N: ");
        int N = scanner.nextInt();
        FibonacciNumbers(N);

        //Задание 6
        System.out.println("Введите размер массива: ");
        int s = scanner.nextInt();
        //randomArray(k);
        //int[] result = mergesort(randomArray(k));
        //System.out.println(Arrays.toString(result));

        //int[] Arr1 = {3,5,9,1,4,7,1,0,6,10,15,11,12,20};
        System.out.println(Arrays.toString(MergeSort(randomArray(s))));

        //Задание 7

//        System.out.println("Введите количество чисел: ");
//        int K = scanner.nextInt();
//        int[] Arr2 = {1,2,3,4,5,4,6,1,7,8,4};
//        //CommonElements(randomArray(s));
//        CommonElements(Arr2, K);

        //System.out.println(Arrays.toString(bubbleSort(randomArray(s))));
    }


    //Методы

    public static String ascendingChecking(int[] array) {
        int k = 0;
        String res;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                k = k + 1;
            }
        }
        if (k == array.length - 1) {
            res = "OK";
        } else {
            res = "Please, try again";
        }
        return res;
    }

    public static int[] makeArray(int arrayLength, int a, int b, int c, int d) {
        int arr[];
        arr = new int[arrayLength];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;

        return arr;
    }

    public static int[] swapElements(int[] arr) {
        int moving = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = moving;
        return arr;
    }

    public static int[] bubbleSort(int[] array1) {
        for (int i = 0; i < array1.length - 1; i++) {
            for (int j = 0; j < array1.length - i - 1; j++) {
                /* если пара соседних элементов имеет неправильный порядок, он меняет их местами */
                if (array1[j] > array1[j + 1]) {
                    int temp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = temp;
                }
            }
        }
        return array1;
    }

    public static int uniqueNumber(int[] array1) {
        int numb = 0;
        for (int i = 0; i < array1.length - 1; i++) {
            if (array1[i] == array1[i + 1]) {
                //System.out.println(array1[i]);
                continue;
            } else {
                for (int j = i + 1; j < array1.length - 1; j++) {
                    if (array1[j] == array1[j + 1]) {
                        //System.out.println(array1[j]);
                        continue;
                    } else {
                        numb = array1[j + 1];
                    }
                    break;
                }
            }
            break;
        }
        return numb;
    }

    public static int FibonacciNumbers(int N) {
        int a = 0, b = 1, c, d, res = 0, bord;//
        if (N % 2 == 0) {
            for (int i = 0; i < N / 2 - 1; i++) {
                c = a + b;
                d = c + b;
                a = c;
                b = d;
                //System.out.println(c+"\n"+d);
                res = d;
            }
        } else {
            for (int i = 0; i < N / 2; i++) {
                c = a + b;
                d = c + b;
                a = c;
                b = d;
                //System.out.println(c + "\n" + d);
                res = c;
            }
        }
        System.out.println("N-number is: " + res);
        return 0;
    }

    public static int[] randomArray(int s) {
        int[] array2;
        array2 = new int[s];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = ((int) (Math.random() * 30));
            //System.out.println(array2[i]);
        }
        return array2;
    }

        //Вариант 1

    public static int[] MergeSort(int[] Arr1){
        int size = 1;
        int[] swap;
        int[] Src = Arr1;
        int[] res = new int [Arr1.length];

        while (size < Arr1.length){
            for (int i = 0; i < Arr1.length; i+= 2 * size){
                MergeArr(Src, i, Src, i + size, res, i, size);
            }

            swap = Src;
            Src = res;
            res = swap;

            size = size * 2;
        }
        return Src;
    }

    public static void MergeArr(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++){
            if(index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])){
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

//    public static int CommonElements(int[] Arr2, int K){
//
//        int[] count = new int[K];
//        //int counter = 0;
//        int c = 0;
//        int max = 1;
//
//        for (int i = 0; i < Arr2.length; i++){
//            int counter = 0;
//            for (int j = 0; j < Arr2.length; j++){
//                if (Arr2[j] == Arr2[i]){
//                    counter ++;
//                }
//            }
//            if (counter > max){
//                count[c] = Arr2[i];
//                //max = counter;
//                c++;
//            }
//            //count[i] = counter;
//            //System.out.println(Arr2[i] + " " + counter);
//        }
//        System.out.println(Arrays.toString((count)));
//        return 0;
//    }



    //Вариант 2

//    public static int[] mergesort(int[] array2) {
//        int[] buffer1 = Arrays.copyOf(array2, array2.length);
//        int[] buffer2 = new int[array2.length];
//        int[] result = mergesortInner(buffer1, buffer2, 0, array2.length);
//        return result;
//    }
//
//    public static int[] mergesortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
//        if (startIndex >= endIndex - 1) {
//            return buffer1;
//        }
//        // уже отсортирован.
//        int middle = startIndex + (endIndex - startIndex) / 2;
//        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
//        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);
//
//        // Слияние
//        int index1 = startIndex;
//        int index2 = middle;
//        int destIndex = startIndex;
//        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
//        while (index1 < middle && index2 < endIndex) {
//            result[destIndex++] = sorted1[index1] < sorted2[index2]
//                    ? sorted1[index1++] : sorted2[index2++];
//        }
//        while (index1 < middle) {
//            result[destIndex++] = sorted1[index1++];
//        }
//        while (index2 < endIndex) {
//            result[destIndex++] = sorted2[index2++];
//        }
//        return result;
//    }
}
