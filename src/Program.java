import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
//https://dirask.com/posts/WSEI-2021-2022-lato-labN-2-PROGN-Programowanie-aplikacji-back-endowych-lab-1-jQk38D

       // 1
        try(FileInputStream fs = new FileInputStream("D:\\Users\\patryk.baranek\\Desktop\\test.txt")){
            System.out.println(fs.read());
        }catch (Exception e){
            System.out.println(e);
        }

        //2
        try(FileOutputStream fs = new FileOutputStream("D:\\Users\\patryk.baranek\\Desktop\\test.txt")){

        }



        //3
        int[] array = new int[]{4, 5, 7, 11, 12, 15, 15, 21, 40, 45 };
        int index = searchIndex(array, 7);
        System.out.println(index);


        //5
        Date date = new Date();
        System.out.println(date);





       // System.out.println(Crc32("text"));


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