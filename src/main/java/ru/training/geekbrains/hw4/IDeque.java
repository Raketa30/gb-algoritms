package ru.training.geekbrains.hw4;

public interface IDeque<E> extends IQueue<E> {
    boolean offerFirst(E e);

    boolean offerLast(E e);

    E peekFirst();

    E peekLast();

    E pollFirst();

    E pollLast();

    E pop();
}
