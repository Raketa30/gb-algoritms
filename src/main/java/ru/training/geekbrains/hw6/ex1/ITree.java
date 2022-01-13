package ru.training.geekbrains.hw6.ex1;

public interface ITree<V> {
    boolean add(V value);

    boolean contains(V value);

    boolean remove(V value);

    int size();

    void clear();

    boolean isEmpty();

    void display();

    int height();

    boolean isBalanced();

    V minValue();

    V maxValue();
}
