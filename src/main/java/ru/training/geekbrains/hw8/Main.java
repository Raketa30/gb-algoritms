package ru.training.geekbrains.hw8;

public class Main {

    public static void main(String[] args) {
        doTask2();
    }

    public static void doTask1() {
        LinearProbingHashMap<Integer, String> map = new LinearProbingHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.toString());
        System.out.println(map.get(1));
    }

    public static void doTask2() {
        ChainingHashMap<Integer, String> map = new ChainingHashMap<>(10);
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map.toString());
        System.out.println(map.get(1));
        map.delete(2);
        System.out.println(map.toString());
    }
}
