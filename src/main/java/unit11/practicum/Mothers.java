package unit11.practicum;

import java.util.ArrayList;
import java.util.List;
import unit11.graphs.AdjacencyGraph;
import unit11.graphs.Graph;

public class Mothers<E> {
    
    public static List<String> findMothers(Graph<String> unweightedGraph, List<String> values) {
        List<String> mothers = new ArrayList<>();
        for(String value : values) {
            boolean isMother = true;
            for(String valueRepeated : values) {
                if(unweightedGraph.bfSearch(value, valueRepeated) == false) {
                    isMother = false;
                    break;
                }
            }
            if(isMother == true) {
                mothers.add(value);
            }
        }
        return mothers;
    }

    public static void main(String[] args) {
        Graph<String> graphA = new AdjacencyGraph<>();
        List<String> valuesA = new ArrayList<>();
        graphA.add("A");
        valuesA.add("A");
        graphA.add("B");
        valuesA.add("B");
        graphA.add("C");
        valuesA.add("C");
        graphA.add("D");
        valuesA.add("D");
        graphA.add("E");
        valuesA.add("E");
        graphA.connectDirected("A", "B");
        graphA.connectDirected("B", "C");
        graphA.connectDirected("C", "D");
        graphA.connectDirected("B", "E");
        graphA.connectDirected("E", "A");
        System.out.println(findMothers(graphA, valuesA));

        Graph<String> graphB = new AdjacencyGraph<>();
        List<String> valuesB = new ArrayList<>();
        graphB.add("T");
        valuesB.add("T");
        graphB.add("U");
        valuesB.add("U");
        graphB.add("V");
        valuesB.add("V");
        graphB.add("W");
        valuesB.add("W");
        graphB.add("X");
        valuesB.add("X");
        graphB.add("Y");
        valuesB.add("Y");
        graphB.add("Z");
        valuesB.add("Z");
        graphB.connectDirected("Z", "U");
        graphB.connectDirected("Z", "Y");
        graphB.connectDirected("Y", "W");
        graphB.connectDirected("Y", "X");
        graphB.connectDirected("X", "U");
        graphB.connectDirected("X", "T");
        graphB.connectDirected("T", "V");
        graphB.connectDirected("W", "T");
        System.out.println(findMothers(graphB, valuesB));
    }
}
