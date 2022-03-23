package com.lab1;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //https://dirask.com/posts/WSEI-2021-2022-lato-labN-2-PROGN-Programowanie-aplikacji-back-endowych-lab-1-jQk38D

        // 1
        readFile("text.txt");

        // 2
        //writeFile("text2.txt");

        // 3
        int[] array = new int[]{4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
        int index = searchIndex(array, 7);
        System.out.println(index);


        // 5
        Date date = new Date();
        System.out.println(date);

        // 6

        // 7
        ObjectMapper objectMapper = new ObjectMapper();

        User userObject = new User();
        userObject.setName("Patryk");
        userObject.setSurname("Baranek");
        userObject.setAge(22);
        String userJson = objectMapper.writeValueAsString(userObject);

        System.out.println(userJson);

        // 8

        String stringUserJson = "{\"name\":\"John\", \"surname\":\"Doe\", \"age\":\"24\"}";
        User stringUserObject = objectMapper.readValue(stringUserJson, User.class);

        System.out.println(stringUserObject.getName());
        System.out.println(stringUserObject.getSurname());
        System.out.println(stringUserObject.getAge());


        // 9

        System.out.println("Array List");
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("e");
        arrayList.add("e");
        arrayList.add("f");
        arrayList.add("f");
        arrayList.add("f");
        arrayList.add("g");
        arrayList.add("g");
        arrayList.add("g");
        arrayList.add("g");
        arrayList.forEach(item -> System.out.println(item));


        for(int i = 0; i < arrayList.size(); i += 2){
            arrayList.remove(i);
        }

        System.out.println();
        arrayList.forEach(item -> System.out.println(item));


        System.out.println("Linked List");
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.forEach(item -> System.out.println(item));

        for(int i = 0; i < linkedList.size(); i += 2){
            linkedList.remove(i);
            System.out.println(linkedList.size());
        }




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








       // System.out.println(Crc32("text"));


    }

    public static void readFile(String filePath){
        var file = new File(filePath);
        try(FileInputStream fis = new FileInputStream(file)) {
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();


        }catch(IOException e){
            e.printStackTrace();
        }

    }

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

    public static int searchIndex(int[] array, int value) {
        int index = 0;
        int limit = array.length - 1;
        while (index <= limit) {
            double point = Math.ceil((index + limit) / 2);
            int entry = array[(int) point];
            if (value > entry) {
                limit = (int)point + 1;
                continue;
            }
            return (int) point;
        }
        return -1;
    }

   /* public static long int Crc32(String text) {
        int[] CRC_TABLE = new int[256];

        for (int i = 0; i < 256; ++i) {
            int code = i;
            for (int j = 0; j < 8; ++j) {
                code = (code & 0x01 ? 0xEDB88320 ^ (code >>> 1) : (code >>> 1));
            }
            CRC_TABLE[i] = code;
        }

        int crc = -1;
        for (int i = 0; i < text.length(); ++i) {
            int code = (int) text.charAt(i);
            crc = CRC_TABLE[(code ^ crc) & 0xFF] ^ (crc >>> 8);
        }
        return (-1 ^ crc) >>> 0;


    }*/
}