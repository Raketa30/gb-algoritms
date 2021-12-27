package ru.training.geekbrains.hw4;

public class StackIm<E> implements IStack<E>{
    private final LinkedListIm<E> stackBase;

    public StackIm() {
        this.stackBase = new LinkedListIm<>();
    }

    @Override
    public void push(E value) {
        stackBase.offerFirst(value);
    }

    @Override
    public E pop() {
        return stackBase.pop();
    }

    @Override
    public E peek() {
        return stackBase.peek();
    }

    @Override
    public boolean isEmpty() {
        return stackBase.isEmpty();
    }

    @Override
    public String toString() {
        return stackBase.toString();
    }
}
