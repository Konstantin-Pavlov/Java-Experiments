package org.example.graph;

public interface Graph {
    void addVertex(String vertex);

    void addEdge(String vertexOne, String vertexTwo);

    void search(String vertex);
}
