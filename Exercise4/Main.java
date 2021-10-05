package ru.Makval;

import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Задание 1

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int s = scanner.nextInt();

        String[] str = new String[s];

        //System.out.println("Введите строки:");
        for (int i = 0; i < str.length; i++){
            System.out.println("Введите " + (i+1) + " строку: ");
            str[i] = scanner.next();
        }

        //MaxLength(str, s);


        //Задание 2

        System.out.println("Введите строку для проверки:");
        String string = scanner.next();
        System.out.println(isPalindrome(string));


        //Задание 3
        System.out.println("Введите текс для обработки:");
        String text = scanner.nextLine();
        System.out.println(rewriteText(text));
    }


    public static void MaxLength(String[] str, int s){
        String maxString = str[0];
        int length = maxString.length();
        for(int i = 1; i < s; i++){
            if(str[i].length() > maxString.length()){
                maxString = str[i];
                length = str[i].length();
            }
        }
        System.out.println("Самая длинная строка: " + maxString + ", длиной " + length + " символов");
    }

    public static String isPalindrome(String string){
        String isPal = "no, it's not a palindrome ";
        int beginIndex = string.length() /2;
        //int endIndex = string.length() / 2;
        String halfString = string.substring(beginIndex);

        char[] firstPartString = string.toCharArray();
        char[] secondPartString = halfString.toCharArray();
        for (int i = 0; i < string.length()/2; i++){
            for(int j = halfString.length()-1; j > 0; j--)

            if(firstPartString[i] == secondPartString[j]){
               isPal = "yes, it's a palindrome ";
            }
        }
        return isPal;
    }

    public static String rewriteText(String text){
        String targetString = "бяка";
        String rewriteString ="«[вырезано цензурой]";
        if (text.equalsIgnoreCase(targetString) == true){
            text.replace(targetString, rewriteString);
        }
        return text;
    }

}
