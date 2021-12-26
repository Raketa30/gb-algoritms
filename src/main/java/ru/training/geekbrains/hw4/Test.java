package ru.training.geekbrains.hw4;


public class Test {
    public static void main(String[] args) {
        System.out.println("\nlist---------------");
        testList();
        System.out.println("\nstack---------------");
        testStack();
        System.out.println("\nqueue---------------");
        testQueue();
    }

    private static void testQueue() {
        IQueue<String> queue = new QueueIm<>();

        for (int i = 0; i < 10; i++) {
            queue.offer(String.valueOf(i));
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(queue.poll() + " ");
        }
    }

    private static void testList() {
        IList<String> numbers = new ArrayListIm<>();
        System.out.println(numbers.size());
        for (int i = 1; i < 25; i++) {
            numbers.add(String.valueOf(i));
        }
//
        System.out.println(numbers);
        System.out.println(numbers.size());
        System.out.println(numbers.contains("2"));
        System.out.println(numbers.remove(2));
        System.out.println(numbers);
        System.out.println(numbers.contains("14"));
        System.out.println(numbers.remove("14"));
        System.out.println(numbers.contains("14"));
        System.out.println(numbers);
        System.out.println(numbers.size());
    }

    private static void testStack() {
        IStack<String> stack = new StackIm<>();

        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf(i));
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
