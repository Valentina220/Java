package ru.Makval;

import java.util.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<String> stringList = new ArrayList<>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");
        stringList.add("One");

        System.out.println(removeDuplicates(stringList));

        compareLists();

        //______________Задание 3_____________________________________________________
        Map<User, Integer> gameMap = new TreeMap<>();
        gameMap.put(new User("Ivan"), 28);
        gameMap.put(new User("Sergey"), 102);
        gameMap.put(new User("Lisa"), 59);
        gameMap.put(new User("Karina"), 117);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя игрока: ");
        String user_name = scanner.nextLine();

        for (User user : gameMap.keySet()) {
            if (user.getName().equals(user_name) ) {
                System.out.println("Общий счет игрока " + user_name + ": " + gameMap.get(user));
            }
        }
        //__________________________________________________________________________________


        //___________ Задание 4 ____________________________________________________________
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        Fill_PrintArr(arr,size);
        makeMap(arr,size);
    }

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }

    public static void compareLists() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        final int n = 1000000;
        final int m = 10000;
        for (int i = 0; i < n; i++) {
            arrayList.add((int)(Math.random() * 100) + 1);
            linkedList.add((int)(Math.random() * 100) + 1);
        }

//        for (int i = 0; i < arrayList.size()/100000; i++) {
//            System.out.println(arrayList.get(i));
//        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < m; i++) {
            arrayList.get((int) (Math.random() * (n - 1)));
        }
        System.out.println("Время ArrayList: " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();

        for (int i = 0; i < m; i++) {
            linkedList.get((int) (Math.random() * (n - 1)));
        }
        System.out.println("Время LinkedList: " + (System.currentTimeMillis() - startTime));
    }

    public static class User implements Comparable <User>{
        private String name;

        @Override
        public int compareTo(User user) {
            return name.compareTo(user.name);
        }

        public User(String name){
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void makeMap(int[] arr, int k) {
        Map<Integer, Integer> arrayToMap = new HashMap<Integer, Integer>();
        int count = 1;

        for(int i = 0; i < k; i++){

            if ( arrayToMap.containsKey(arr[i])){
                arrayToMap.put(arr[i], arrayToMap.get(arr[i])+1);
            }
            else {
                arrayToMap.put(arr[i], count);
            }
        }
        System.out.println(arrayToMap.entrySet());
    }

    public static void Fill_PrintArr(int[] arr, int size){
        for(int i = 0; i < size; i++){
            arr[i] = ((int)(Math.random() * 10) + 1 );
        }

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + "; ");
        }

        System.out.println("\n");
    }
}
