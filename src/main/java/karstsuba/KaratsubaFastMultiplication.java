package main.java.karstsuba;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * Karatsuba Algorithm:
 * This is a recursive algorithm used for fast multiplication of big integers.
 * It’s faster than the classical algorithm and works well for large numbers.
 * XY = a*c + [(a+b)*(c+d) - a*c - b*d]*2^N + b*d * 2^(2N)
 * https://www.youtube.com/watch?v=JCbZayFr9RE&list=PLEAYkSg4uSQ37A6_NrUnTHEKp6EkAxTMa&index=3
 */
public class KaratsubaFastMultiplication {

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        System.out.println("__________________________________________");
        System.out.println(x.toString(2) +" "+ y.toString(2));
        Integer n = Math.max(x.bitLength(), y.bitLength());
        // the base case of the recursion
        if (n <= 5) {
            return x.multiply(y);
        }

        // calculates the half of N, rounded up, and assigns it back to N.
        n = (n / 2) + (n % 2);

        /**
         * x = a + 2^N b, y = c + 2^N d or x = 2^N a + b, y = 2^N c + d  
         * These lines split x and y into two parts each: a and b for x, and c and d for
         * y.
         * The shiftRight and shiftLeft operations are equivalent to dividing and
         * multiplying by 2^N, respectively.
         */

        /**
         * This line divides x by 2^N (equivalent to shifting the bits of x to the right
         * by N places) and assigns the result to b.
         * This effectively extracts the higher-order half of x
         */
        BigInteger b = x.shiftRight(n);

        /**
         * This line multiplies b by 2^N (equivalent to shifting the bits of b to the left by N places)
         * and subtracts the result from x, assigning the result to a. This effectively extracts the lower-order half of x.
         */
        BigInteger a = x.subtract(b.shiftLeft(n));

        BigInteger d = y.shiftRight(n);
        BigInteger c = y.subtract(d.shiftLeft(n));

        /**
         * These lines recursively compute the products of a and c, b and d, and (a+b) and (c+d).
         */
        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        // final calculation and puts bits into place
        // binary ac + (abcd - ac - bd) 2^n + bd 2^2n  or  2^2n ac + (abcd - ac - bd) 2^n + bd
        // decimal ac + (abcd - ac - bd) 10 ^ n/2 + bd 10 ^ n
        // .shiftLeft(n) = var * 2^n
        // Gauss's Trick (abcd - ac - bd) = bc + ad, no need to compute two more multiplications
        // Final formula - XY = a*c + [(a+b)*(c+d) - a*c - b*d]*2^N + b*d * 2^(2N)
        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(n)).add(bd.shiftLeft(2 * n));
    }

    public static void main(String[] args) {
        BigInteger x = BigInteger.valueOf(5678); //new BigInteger(12, new Random());
        BigInteger y = BigInteger.valueOf(1234); //new BigInteger(12, new Random());

        BigInteger karatsuba = karatsuba(x, y);
        BigInteger multiply = x.multiply(y);

        System.out.println(x + " * " + y + " = " + multiply + " = " + karatsuba + " is same: "+ multiply.equals(karatsuba));
    }
}
