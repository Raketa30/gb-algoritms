package ru.training.geekbrains.hw5.ex1;

/*
    1. Написать программу по возведению числа в степень с помощью рекурсии.
 */
public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.power(3, 18));
        System.out.println(Math.pow(3.0, 18.0));
        System.out.println(power.power(3, -6));
        System.out.println(Math.pow(3.0, -6));
    }

    private double power(double number, double pow) {
        if (pow > 0) {
            if (pow == 1) {
                return number;
            }
            if (pow % 2 == 1) {
                return number * power(number, pow - 1);
            }
            return power(number * number, pow / 2);
        } else {
            if (pow == 0) {
                return 1;
            }
            return power(number, pow + 1) / number;
        }
    }

}
