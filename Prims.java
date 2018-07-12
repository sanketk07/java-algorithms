package com.homework10.mst;

/**
 * @author sanketkumar
 *
 */

import java.util.*;

public class Prims {

static class Edge{
    int source, destination;
    double edgeWeight;

    Edge(int source, int destination, double edgeWeight){
        this.source = source;
        this.destination = destination;
        this.edgeWeight = edgeWeight;
    }
}

public static ArrayList<Edge> primsMST(ArrayList<ArrayList<Edge>> graph){
    if(graph.isEmpty()) {
    		throw new NullPointerException("Please input a valid graph!");
    }

    ArrayList<Edge> edgeList = new ArrayList<>();
    PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>((Object obj1, Object obj2) -> {
        Edge first = (Edge)obj1;
        Edge second = (Edge)obj2;

        if(first.edgeWeight<second.edgeWeight) {
        		return -1;
        }
        else if(first.edgeWeight>second.edgeWeight) {
        		return 1;
        }
        else {
        		return 0;
        }
    });

    for(Edge edge : graph.get(0)){
        edgePriorityQueue.add(edge);
    }

    boolean[] visited = new boolean[graph.size()];
    visited[0] = true;
    while(!edgePriorityQueue.isEmpty()){
        Edge e = edgePriorityQueue.peek();

        edgePriorityQueue.poll();
        if(visited[e.source] && visited[e.destination])continue;
        visited[e.source] = true;  
        for(Edge edge:graph.get(e.destination)){
            if(!visited[edge.destination]){
                edgePriorityQueue.add(edge);  
            }
        }
        visited[e.destination] = true; 
        edgeList.add(e);

    }
    return edgeList;
}

public static ArrayList<ArrayList<Edge>> createGraph(Edge[] edges){
    ArrayList<ArrayList<Edge>> listEdges = new ArrayList<>();
    int len = edges.length * 2;
    for(int i=0;i<len;++i){
        listEdges.add(new ArrayList<>());
    }

    for(Edge e:edges){
        Edge other = new Edge(e.destination, e.source, e.edgeWeight);
        listEdges.get(e.source).add(e);
        listEdges.get(e.destination).add(other);
        System.out.println("Added edge ["+e.source+", "+e.destination+" : "+e.edgeWeight+"] "+"["+e.destination+", "+e.source+" : "+e.edgeWeight+"]");
    }

    return listEdges; 
}

public static void main(String[] args){
    Edge[] edges = new Edge[16];

    edges[0] = new Edge(0, 7, 0.16);
    edges[1] = new Edge(2, 3, 0.17);
    edges[2] = new Edge(1, 7, 0.19);
    edges[3] = new Edge(0, 2, 0.26);

    edges[4] = new Edge(5, 7, 0.28);
    edges[5] = new Edge(1, 3, 0.29);
    edges[6] = new Edge(1, 5, 0.32);
    edges[7] = new Edge(2, 7, 0.34);

    edges[8] = new Edge(4, 5, 0.35);
    edges[9] = new Edge(1, 2, 0.36);
    edges[10] = new Edge(4, 7, 0.37);
    edges[11] = new Edge(0, 4, 0.38);

    edges[12] = new Edge(6, 2, 0.40);
    edges[13] = new Edge(3, 6, 0.52);
    edges[14] = new Edge(6, 0, 0.58);
    edges[15] = new Edge(6, 4, 0.93);

    ArrayList<ArrayList<Edge>> graph = createGraph(edges);
    ArrayList<Edge> edgeList = primsMST(graph);

    System.out.println("MST using Prim's algorithm: ");
    for(Edge edge: edgeList){
        System.out.println(edge.source+" - "+edge.destination+" : "+edge.edgeWeight);
    } 
}
}