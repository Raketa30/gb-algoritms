package ru.training.geekbrains.hw7;

import java.util.LinkedList;

public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgTo;
    private int source;

    public DepthFirstPath(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.getVertexCount()];
        edgTo = new int[graph.getVertexCount()];
        dfs(graph, source);

    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.getAdjLists(v)) {
            if (!marked[w]) {
                edgTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        LinkedList<Integer>stack=new LinkedList<>();
        int vertex=v;
        while (vertex!=source){
            stack.push(vertex);
            vertex=edgTo[vertex];
        }
        return stack;
    }
}
