/**
 * 
 */
package com.homework9.algos;

/**
 * @author sanketkumar
 *
 */
import java.util.Scanner;

public class BellmanFord{
    private int weights[];
    private int verticesCount;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord(int verticesCount){
        this.verticesCount = verticesCount;
        weights = new int[verticesCount + 1];
    }
 
    public void BellmanFordEvaluation(int src, int adjacencymatrix[][]){
        for (int n = 1; n <= verticesCount; n++){
            weights[n] = MAX_VALUE;
        }
 
        weights[src] = 0;
        for (int n = 1; n <= verticesCount - 1; n++){
            for (int srcNode = 1; srcNode <= verticesCount; srcNode++){
                for (int destNode = 1; destNode <= verticesCount; destNode++){ 
                		if (adjacencymatrix[srcNode][destNode] != MAX_VALUE){ 
                			if (weights[destNode] > weights[srcNode] 
                                + adjacencymatrix[srcNode][destNode])
                            weights[destNode] = weights[srcNode]
                                + adjacencymatrix[srcNode][destNode];
                    }
                }
            }
        }
 
        for (int srcNode = 1; srcNode <= verticesCount; srcNode++){
            for (int destNode = 1; destNode <= verticesCount; destNode++){ 
            		if (adjacencymatrix[srcNode][destNode] != MAX_VALUE){ 
            			if (weights[destNode] > weights[srcNode]
                           + adjacencymatrix[srcNode][destNode])
                        System.out.println("A negative cycle is present in the entered Graph.");
                }
            }
        }
 
        for (int vertex = 1; vertex <= verticesCount; vertex++){
            System.out.println("The distance of source  " + src + " to " + vertex + " is " + weights[vertex]);
        }
    }
 
    public static void main(String args[]){
        int verticesCount = 0;
        int src;
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Please enter the number of vertices: ");
        verticesCount = sc.nextInt();
 
        int adjacencymatrix[][] = new int[verticesCount + 1][verticesCount + 1];
        System.out.println("Please enter the adjacency matrix: ");
        for (int srcNode = 1; srcNode <= verticesCount; srcNode++){
            for (int destNode = 1; destNode <= verticesCount; destNode++){
                adjacencymatrix[srcNode][destNode] = sc.nextInt();
 	        if (srcNode == destNode){
                    adjacencymatrix[srcNode][destNode] = 0;
                    continue;
                }
                if (adjacencymatrix[srcNode][destNode] == 0){
                    adjacencymatrix[srcNode][destNode] = MAX_VALUE;
                }
            }
        }
 
        System.out.println("Please enter the source vertex: ");
        src = sc.nextInt();
 
        BellmanFord bellmanford = new BellmanFord(verticesCount);
        bellmanford.BellmanFordEvaluation(src, adjacencymatrix);
        
        sc.close();	
    }
}