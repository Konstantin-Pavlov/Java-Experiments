package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphWithWeight implements Graph {
    private final Map<String, List<EdgeWithWeight>> graph = new HashMap<>();


    @Override
    public void addVertex(String vertex) {
        graph.put(vertex, new ArrayList<>());
    }

    @Override
    public void addEdge(String vertexOne, String vertexTwo) {
        graph.get(vertexOne).add(new EdgeWithWeight(vertexOne, vertexTwo, 5));
        graph.get(vertexTwo).add(new EdgeWithWeight(vertexOne, vertexTwo, 5));
    }

    public List<EdgeWithWeight> getDependencies(String vertex) {
        return graph.get(vertex);
    }

    @Override
    public void search(String vertex) {
        Set<String> visited = new HashSet<>();
        searchHelper(vertex, visited);
    }

    private void searchHelper(String vertex, Set<String> visited) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.println(vertex);
            for (EdgeWithWeight currentVertex : getDependencies(vertex)) {
                searchHelper(currentVertex.vertexOne(), visited);
                searchHelper(currentVertex.vertexTwo(), visited);
            }
        }
    }
}
