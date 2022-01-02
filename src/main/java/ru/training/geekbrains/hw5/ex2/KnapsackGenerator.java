package ru.training.geekbrains.hw5.ex2;

import java.util.*;

public class KnapsackGenerator {
    private Knapsack bestPack;
    private final int maxWeight;
    private int bestPrice;

    public KnapsackGenerator(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void generate(List<Item> items) {
        generateKnapsacks(items);
    }

    private void check(Knapsack knapsack) {
        if (bestPack == null) {
            if (knapsack.getTotalWeight() <= maxWeight) {
                bestPack = knapsack;
                bestPrice = knapsack.getTotalPrice();
            }
        } else {
            if (knapsack.getTotalWeight() <= maxWeight && knapsack.getTotalPrice() > bestPrice) {
                bestPack = knapsack;
                bestPrice = knapsack.getTotalPrice();
            }
        }
    }

    private void generateKnapsacks(List<Item> items) {
        if (!items.isEmpty()) {
            check(new Knapsack(items));
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> current = new ArrayList<>(items);
            current.remove(i);
            generateKnapsacks(current);
        }
    }

    public Knapsack getBestPack() {
        return bestPack;
    }
}
