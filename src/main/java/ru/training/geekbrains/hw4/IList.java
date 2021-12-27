package ru.training.geekbrains.hw4;

public interface IList<E> extends MyCollection<E> {

    boolean add(int index, E value);

    boolean remove(int index);
}
