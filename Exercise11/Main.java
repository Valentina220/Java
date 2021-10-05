package ru.Makval;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        getPoem();

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите строку: ");
//        String str = scanner.nextLine();
//
//        writeString(str);
//        joinFiles();
//
//        System.out.println("Введите строку для копирования: ");
//        String copyString = scanner.nextLine();
//
//        copyFile(writeString(copyString));

        findFile();

        findStringFile();

    }

    public static void getPoem() throws IOException {
        FileReader fr = new FileReader("E:\\ИТМО\\Java\\11_Files\\file1.txt");
        Scanner scan = new Scanner(fr);

        ArrayList<String> poem = new ArrayList<String>();

        while (scan.hasNextLine()) {
            poem.add(scan.nextLine());
        }
        fr.close();
        for (Object str : poem) {
            System.out.println(str);
        }
    }

    public static File writeString(String str) throws IOException {
        File file = new File("E:\\ИТМО\\Java\\11_Files\\Example.txt");

        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        writer.write(str);
        writer.flush();
        writer.close();

        FileReader fr = new FileReader(file);
        Scanner scan = new Scanner(fr);
        String[] strings = new String[str.length()];

        System.out.println(scan.nextLine());
        return file;
    }

    public static void joinFiles() throws IOException {

        StringBuilder output = new StringBuilder();
        try (Scanner sc1 = new Scanner((new File("E:\\ИТМО\\Java\\11_Files\\file1.txt")));
             Scanner sc2 = new Scanner((new File("E:\\ИТМО\\Java\\11_Files\\Example.txt")))) {

            while (sc1.hasNext()) {
                String s1 = (sc1.hasNext() ? sc1.nextLine() : "");
                output.append(s1).append("\n");
            }
            while (sc2.hasNext()) {
                String s2 = (sc2.hasNext() ? sc2.nextLine() : "");
                output.append(s2).append("\n");
            }
        }
        try (PrintWriter pw = new PrintWriter(new File("E:\\ИТМО\\Java\\11_Files\\file2.txt"))) {
            pw.write(output.toString());
        }
    }

    private static void copyFile(File source) throws IOException {
        File copyFile = new File("E:\\ИТМО\\Java\\11_Files\\Copy.txt");

        if (!copyFile.exists()) {
            copyFile.createNewFile();
        }
        InputStream inStr = null;
        OutputStream outStr = null;
        try {
            inStr = new FileInputStream(source);
            outStr = new FileOutputStream(copyFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStr.read(buffer)) > 0) {
                outStr.write(buffer, 0, length);
            }
        } finally {
            inStr.close();
            outStr.close();
        }
    }

    public static void findFile() {
        File dir = new File("E:\\ИТМО\\Java\\11_Files\\");
        // если объект представляет каталог
        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (!item.isDirectory()) {
                    if (item.getName().startsWith("f")) {
                        System.out.println(item.getName() + "\t file");
                    }
                }
            }
        }
    }

    public static void findStringFile() throws IOException {

        File dir = new File("E:\\ИТМО\\Java\\11_Files\\");

        if (dir.isDirectory()) {
            for (File item : dir.listFiles())
                if (item.isFile()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(item))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains("без")) {
                                System.out.println(item.getName() + "\t file");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
