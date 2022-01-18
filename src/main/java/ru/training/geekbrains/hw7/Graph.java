package ru.training.geekbrains.hw7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjLists;

    public Graph(int vertexCount) {
        if (vertexCount < 1) {
            throw new IllegalArgumentException("vertexCount: " + vertexCount);
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < adjLists.length; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public List<Integer> getAdjLists(int vertex) {
        return Collections.unmodifiableList(adjLists[vertex]);
    }

    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 > vertexCount || v2 > vertexCount) {
            throw new IllegalArgumentException("");
        }
        adjLists[v1].add(v2);
        if (v1 != v2) {
            adjLists[v2].add(v1);
        }
    }
}
