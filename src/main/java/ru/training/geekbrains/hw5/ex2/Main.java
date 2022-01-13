package ru.training.geekbrains.hw5.ex2;

import java.util.ArrayList;
import java.util.List;

/*
 Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */
public class Main {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(7, 5));
        itemList.add(new Item(8, 3));
        itemList.add(new Item(3, 2));
        itemList.add(new Item(4, 6));
        itemList.add(new Item(4, 8));
        itemList.add(new Item(6, 6));
        itemList.add(new Item(7, 8));
        itemList.add(new Item(6, 7));

        KnapsackGenerator knapsackGenerator = new KnapsackGenerator(30);
        knapsackGenerator.generate(itemList);
        Knapsack knapsack = knapsackGenerator.getBestPack();
        knapsack.print();
        System.out.println("Total weight: " + knapsack.getTotalWeight());
        System.out.println("Total price: " + knapsack.getTotalPrice());
        System.out.println();

        KnapsackGenerator knapsackGenerator2 = new KnapsackGenerator(20);
        knapsackGenerator2.generate(itemList);
        Knapsack knapsack2 = knapsackGenerator2.getBestPack();
        knapsack.print();
        System.out.println("Total weight: " + knapsack2.getTotalWeight());
        System.out.println("Total price: " + knapsack2.getTotalPrice());
        System.out.println();
    }

}
