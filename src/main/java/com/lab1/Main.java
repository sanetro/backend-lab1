package com.lab1;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //https://dirask.com/posts/WSEI-2021-2022-lato-labN-2-PROGN-Programowanie-aplikacji-back-endowych-lab-1-jQk38D

        // 1
        readFile("D:\\test\\text2.txt");

        // 2
        //writeFile("D:\\test\\text2.txt");

        // 3
        int[] array = new int[]{4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
        int index = searchIndex(array, 7);
        System.out.println(index);


        // 5
        Date date = new Date();
        System.out.println(date);

        // 6

        ObjectMapper objectMapper = new ObjectMapper();
        User userObject = new User("Patryk", "Baranek", new String[]{"console games", "computers", "football"});
        String userJson = objectMapper.writeValueAsString(userObject);

        System.out.println(userJson);







       // System.out.println(Crc32("text"));


    }

    public static  void readFile(String filePath){
        var file = new File(filePath);
        try(FileInputStream fis = new FileInputStream(file)) {
            Scanner scanner = new Scanner(fis);
            System.out.println(scanner.nextLine());

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
            int point = (int) Math.ceil((index + limit) / 2);
            int entry = array[point];
            if (value > entry) {
                limit = point + 1;
                continue;
            }
            return point;
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