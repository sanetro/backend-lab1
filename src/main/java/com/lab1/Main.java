package com.lab1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //https://dirask.com/posts/WSEI-2021-2022-lato-labN-2-PROGN-Programowanie-aplikacji-back-endowych-lab-1-jQk38D

        // 1
        readFile("text.txt");

        // 2
        writeFile("text2.txt");

        // 3
        int[] array = new int[]{4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
        int index = searchIndex(array, 7);
        System.out.println(index);


        // 5
        Date now = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Warsaw"));
        System.out.println("Czas lokalny: ");
        System.out.println(now);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("Czas globalny: ");
        System.out.println(now);

        // 6

        showAllLinesInFile("example.txt");


        // 7
        ObjectMapper objectMapper = new ObjectMapper();

        User userObject = new User();
        userObject.setName("Bartek");
        userObject.setSurname("Saleta");
        userObject.setAge(22);
        String userJson = objectMapper.writeValueAsString(userObject);

        System.out.println(userJson);

        //8

        String stringUserJson = "{\"name\":\"John\", \"surname\":\"Doe\", \"age\":\"24\"}";
        User stringUserObject = objectMapper.readValue(stringUserJson, User.class);

        System.out.println(stringUserObject.getName());
        System.out.println(stringUserObject.getSurname());
        System.out.println(stringUserObject.getAge());


        // 9

        System.out.println("Array List");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");
        arrayList.add("six");
        arrayList.add("seven");
        arrayList.add("eight");
        arrayList.add("nine");
        arrayList.add("ten");
        arrayList.add("eleven");

        showItemsInList(arrayList);

        System.out.println();
        arrayList.forEach(item -> System.out.println(item));


        System.out.println("Linked List");
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");

        showItemsInList(linkedList);

        System.out.println();
        linkedList.forEach(item -> System.out.println(item));


        // 10

        System.out.println();

        var namesArrayList = new ArrayList<String>();
        namesArrayList.add("Patryk");
        namesArrayList.add("Patryk");
        namesArrayList.add("Patryk");
        namesArrayList.add("Dominik");
        namesArrayList.add("Dominik");
        namesArrayList.add("Dominik");
        namesArrayList.add("Bartek");
        namesArrayList.add("Bartek");
        namesArrayList.add("Bartek");
        namesArrayList.add("Bartek");

        Set<String> hashSet = new HashSet<String>();

        for(var name : namesArrayList){
            hashSet.add(name);
        }

        System.out.println("Names in hashSet");
        for (var item : hashSet) {
            System.out.println(item);
        }
    }

    // 1
    public static void readFile(String filePath){
        var file = new File(filePath);
        try(FileInputStream fis = new FileInputStream(file)) {
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();


        }catch(IOException e){
            e.printStackTrace();
        }

    }

    // 2
    public static void writeFile(String filePath){
        var file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file)){
            PrintWriter pw = new PrintWriter(fos);
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            pw.write(userInput);
            pw.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    // 3
    public static int searchIndex(int[] array, int value) {
        int index = 0;
        int limit = array.length - 1;
        while (index <= limit) {
            int point = (int)Math.ceil((index + limit) / 2);
            int entry = array[point];
            if (value > entry) {
                limit = point + 1;
                continue;
            }
            return point;
        }
        return -1;
    }

    // 4
//    public static int Crc32(String text) {
//        int[] CRC_TABLE = new int[256];
//
//        for (int i = 0; i < 256; ++i) {
//            int code = i;
//            for (int j = 0; j < 8; ++j) {
//                code = (code & 0x01 ? 0xEDB88320 ^ (code >>> 1) : (code >>> 1));
//            }
//            CRC_TABLE[i] = code;
//        }
//
//        int crc = -1;
//        for (int i = 0; i < text.length(); ++i) {
//            int code = (int) text.charAt(i);
//            crc = CRC_TABLE[(code ^ crc) & 0xFF] ^ (crc >>> 8);
//        }
//        return (-1 ^ crc) >>> 0;
//
//
//    }

    // 6
    public static List<String> readAllLinesInFile(String fileName){
        List<String> lines = Collections.emptyList();
        try{
            lines = Files.readAllLines(Paths.get(fileName));
        }catch (IOException e){
            e.printStackTrace();
        }

        return lines;

    }

    public static void showAllLinesInFile(String filePath){
        var lines = readAllLinesInFile(filePath);

        for (int i = 0; i < lines.size(); i++){
            int temp = i;
            System.out.println(++temp + ". " + lines.get(i));
        }
    }

    // 9 10
    public static void showItemsInList(List<String> list){
        Iterator<String> newList = list.iterator();

        int temp = 0;
        while (newList.hasNext()){
            if(temp % 2 == 0 && temp != 0){
                newList.remove();
            }

            System.out.println(newList.next());

            ++temp;
        }
    }
}