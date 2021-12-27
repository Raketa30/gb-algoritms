package ru.training.geekbrains.hw4;

public interface MyCollection<E> extends Iterable<E> {
    boolean add(E value);

    boolean remove(E value);

    int size();

    void clear();

    boolean contains(E value);

    boolean isEmpty();
}
