package ru.training.geekbrains.hw5.ex2;

import java.util.Objects;

public class Item implements Comparable<Item> {
    private final double pricePerKg;
    private final int cost;
    private final int weight;

    public Item(int weight, int cost) {
        this.cost = cost;
        this.weight = weight;
        pricePerKg = (double) cost / weight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Item o) {
        double r2 = (double) o.cost / o.weight;
        return -Double.compare(pricePerKg, r2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.pricePerKg, pricePerKg) == 0 &&
                cost == item.cost &&
                weight == item.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pricePerKg, cost, weight);
    }

    @Override
    public String toString() {
        return String.format("Item: weight - %d, cost - %d, pricePerKg - %.2f", cost, weight, pricePerKg);
    }
}
