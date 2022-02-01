package ru.training.geekbrains.hw7;

import java.util.LinkedList;

public class BreadthFirstPath {

    private boolean[] marked;
    private int[] edgTo;
    private int source;

    public BreadthFirstPath(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.getVertexCount()];
        edgTo = new int[graph.getVertexCount()];
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : graph.getAdjLists(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgTo[w] = vertex;
                    queue.addLast(w);
                }
            }
        }
    }


    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgTo[vertex];
        }
        return stack;
    }
}
