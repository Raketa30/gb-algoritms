package ru.training.algoritm;

public class Karatsuba {
    public static void main(String[] args) {
        System.out.println(karatsuba(12771L, 2323L));
    }

    public static long karatsuba(long num1, long num2) {

        int m = Math.max(
                String.valueOf(num1).length(),
                String.valueOf(num2).length()
        );

        if (m < 2)
            return num1 * num2;

        m = (m / 2) + (m % 2);

        long b = num1 >> m;
        long a = num1 - (b << m);
        long d = num2 >> m;
        long c = num2 - (d << m);

        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long abcd = karatsuba(a + b, c + d);

        return ac + (abcd - ac - bd << m) + (bd << 2 * m);
    }
}
