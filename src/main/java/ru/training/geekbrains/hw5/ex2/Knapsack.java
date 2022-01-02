package ru.training.geekbrains.hw5.ex2;

import java.util.List;

public class Knapsack {
    private final List<Item> itemList;

    public Knapsack(List<Item> items) {
        this.itemList = items;
    }

    public int getTotalPrice() {
        return itemList.stream().mapToInt(Item::getCost).sum();
    }

    public double getTotalWeight() {
        return itemList.stream().mapToDouble(Item::getWeight).sum();
    }

    public List<Item> getItems() {
        return itemList;
    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }

    public void print() {
        for (Item i : itemList) {
            System.out.println(i);
        }
    }

    public void put(Item item) {
        itemList.add(item);
    }

    public void remove(int index) {
        itemList.remove(index);
    }
}
