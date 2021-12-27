package ru.training.geekbrains.hw4;

public interface IQueue<E> {
    boolean offer(E value);

    E element();

    E peek();

    E poll();

    boolean isEmpty();
}
