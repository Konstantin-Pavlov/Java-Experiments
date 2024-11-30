package org.example.graph;
//todo - добавьте вес рёбрам
//todo - Измените его в принципе
//todo - Измените его на направленный
//todo - также Изучите алгоритмы такие как поиск кратчайшего пути да алгоритм дейкстры
public class GraphRunner {
    public static void main(String[] args) {
//        SimpleGraph simpleGraph = new SimpleGraph();
//        simpleGraph.addVertex("A");
//        simpleGraph.addVertex("B");
//        simpleGraph.addVertex("C");
//        simpleGraph.addVertex("D");
//
//        simpleGraph.addEdge("A", "B");
//        simpleGraph.addEdge("A", "D");
//
//        simpleGraph.addEdge("B", "D");
//        simpleGraph.addEdge("B", "C");
//
//        simpleGraph.addEdge("C", "D");
//
//        simpleGraph.search("A");

/*
A
B
D
C
*/


        GraphWithWeight graphWithWeight = new GraphWithWeight();
        graphWithWeight.addVertex("A");
        graphWithWeight.addVertex("B");
        graphWithWeight.addVertex("C");
        graphWithWeight.addVertex("D");

        graphWithWeight.addEdge("A", "B");
        graphWithWeight.addEdge("A", "D");

        graphWithWeight.addEdge("B", "D");
        graphWithWeight.addEdge("B", "C");

        graphWithWeight.addEdge("C", "D");

        graphWithWeight.search("A");
    }
}
