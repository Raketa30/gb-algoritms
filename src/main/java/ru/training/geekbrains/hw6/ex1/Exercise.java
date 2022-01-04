package ru.training.geekbrains.hw6.ex1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise {
    public static void main(String[] args) {
        /*
            1. Создать и запустить программу для построения двоичного дерева.
            В цикле построить двадцать деревьев с глубиной в 4 уровней.
            Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
            Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -25 до 25.
         */
        List<ITree<Integer>> trees = new ArrayList<>();
        doTask(100000, trees);
//        doTask2();
    }

    private static void doTask(int size, List<ITree<Integer>> trees) {
        int isBalanced = 0;
        for (int i = 0; i < size; i++) {
            ITree<Integer> tree = new BinarySearchTree<>();
            while (tree.height() < 4) {
                tree.add(ThreadLocalRandom.current().nextInt(-25, 25));
            }
            trees.add(tree);
            if (tree.isBalanced()) {
                isBalanced++;
            }
        }
        System.out.printf(" Total: %d%n balanced: %d%n not balanced: %d", size, isBalanced, size - isBalanced);
    }
//
//
//    private static void doTask2() {
//        ITree<Integer> tree = new BinarySearchTree<>();
//        tree.add(10);
//        tree.add(6);
//        tree.add(15);
//        tree.add(8);
//        tree.add(13);
//        tree.add(12);
//        tree.add(14);
//        tree.add(7);
//        tree.add(2);
//        tree.add(18);
//        tree.display();
//        tree.remove(6);
//        tree.display();
//    }
}
