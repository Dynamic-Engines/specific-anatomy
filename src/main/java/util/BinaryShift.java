package main.java.util;

public class BinaryShift {


    public static void binaryShift(int input, int by) {
        System.out.println(Integer.toBinaryString(input));

        //left shift x by n positions <=> x * 2n
        System.out.println("Shifting Left");
        System.out.println(Integer.toBinaryString(input << by));
        System.out.println(input << by);


        //This is equivalent to dividing the number by 2^N, where N is the number of positions to shift.
        System.out.println("Shifting Right");
        System.out.println(Integer.toBinaryString(input >> by));
        System.out.println(input >> by);

        System.out.println("Shifting Zero Fill Right");
        System.out.println(Integer.toBinaryString(input >>> by));
        System.out.println(input >>> by);

        System.out.println("-------------");

    }

    public static void main(String[] args) {
        
        binaryShift(10, 2);
        
        // Negative numbers aare 2's compliment of their positive counter part,
        // 2's = insverse binary of +ve and add 1
        binaryShift(-10, 2); 
    }
}