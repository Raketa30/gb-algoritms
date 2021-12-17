package ru.training.geekbrains;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        sortBySystem();
        long start = System.currentTimeMillis();
        sortByMyMethod();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void sortByMyMethod() {
        NoteBook[] noteBookArray = initArray(10000);
        selectionSort(noteBookArray);
//        System.out.println(Arrays.toString(noteBookArray));
    }

    private static void sortBySystem() {
        NoteBook[] noteBookArray = initArray(10000);
        Arrays.sort(noteBookArray);
//        System.out.println(Arrays.toString(noteBookArray));
    }

    private static void selectionSort(NoteBook[] noteBookArray) {
        int length = noteBookArray.length;
        for (int min = 0; min < length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < length; j++) {
                if (noteBookArray[j].compareTo(noteBookArray[least]) < 0) {
                    least = j;
                }
            }

            NoteBook temp = noteBookArray[min];
            noteBookArray[min] = noteBookArray[least];
            noteBookArray[least] = temp;
        }
    }

    private static NoteBook[] initArray(int size) {
        NoteBook[] noteBooks = new NoteBook[size];
        fillArray(noteBooks);
        return noteBooks;
    }

    private static void fillArray(NoteBook[] noteBooks) {
        Random random = new Random();
        Model[] models = Model.values();

        for (int i = 0; i < noteBooks.length; i++) {
            int price = 500 + random.nextInt((2000 - 500) / 50 + 1) * 50;
            int ram = 4 + random.nextInt(24 / 4) * 4;
            int model = random.nextInt(models.length);

            noteBooks[i] = new NoteBook(models[model], ram, price);
        }
    }


}
