package ru.training.geekbrains.hw4;

public interface IStack<E> {
    void push(E value);

    E pop();

    E peek();

    boolean isEmpty();
}
