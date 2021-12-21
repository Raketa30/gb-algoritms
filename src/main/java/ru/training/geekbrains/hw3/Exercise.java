package ru.training.geekbrains.hw3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise {


    public static void main(String[] args) {
        int size = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                size = scanner.nextInt();
                int[] numbers = initArr(size);
                System.out.println(Arrays.toString(numbers));
                System.out.println(findNumber(numbers));
            }
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
    }

    public static int findNumber(int[] numbers) {
        if (numbers.length == 0 || numbers.length == 1) {
            return 1;
        }

        int first = 0;
        int last = numbers.length - 1;
        int middle = (first + last) / 2;

        while (first <= last) {

        }
        return 1;
    }

    private static int[] initArr(int size) {
        if (size == 1 || size == 0) {
            return new int[]{1};
        }
        Random random = new Random();
        int[] arr = new int[size];

        int randomIndex = random.nextInt(size);
        int counter = 1;
        for (int i = 0; i < size; i++) {
            if (i == randomIndex) {
                counter++;
            }
            arr[i] = counter;
            counter++;
        }
        return arr;
    }
}