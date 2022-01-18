package ru.training.geekbrains.hw7;

/*
   1. Реализовать программу, в которой задается граф из 10 вершин.
   Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(2, 5);
        graph.addEdge(7, 6);
        graph.addEdge(8, 1);
        graph.addEdge(2, 9);

        BreadthFirstPath bfp = new BreadthFirstPath(graph, 1);
        System.out.println(bfp.pathTo(7));


    }
}
