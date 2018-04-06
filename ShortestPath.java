package com.homework8.minheap;

class ShortestPath
{
 static final int V=9;
 int minimumDistance(int distance[], Boolean spTreeSet[])
 {
     int minimum = Integer.MAX_VALUE, minimumIndex=-1;

     for (int i = 0; i < V; i++)
         if (spTreeSet[i] == false && distance[i] <= minimum)
         {
             minimum = distance[i];
             minimumIndex = i;
         }

     return minimumIndex;
 }

 void print(int dist[], int n)
 {
     System.out.println("Vertex --->  Distance");
     for (int i = 0; i < V; i++)
         System.out.println(i+" ---> "+dist[i]);
 }

 void dijkstra(int graph[][], int source)
 {
     int distance[] = new int[V];
                             
     Boolean spTreeSet[] = new Boolean[V];

     for (int i = 0; i < V; i++)
     {
         distance[i] = Integer.MAX_VALUE;
         spTreeSet[i] = false;
     }

     distance[source] = 0;

     for (int i = 0; i < V-1; i++)
     {
         int u = minimumDistance(distance, spTreeSet);

         spTreeSet[u] = true;

         for (int v = 0; v < V; v++)

             if (!spTreeSet[v] && graph[u][v]!=0 &&
                     distance[u] != Integer.MAX_VALUE &&
                     distance[u]+graph[u][v] < distance[v])
                 distance[v] = distance[u] + graph[u][v];
     }

     print(distance, V);
 }

 public static void main (String[] args)
 {
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                               {4, 0, 8, 0, 0, 0, 0, 11, 0},
                               {0, 8, 0, 7, 0, 4, 0, 0, 2},
                               {0, 0, 7, 0, 9, 14, 0, 0, 0},
                               {0, 0, 0, 9, 0, 10, 0, 0, 0},
                               {0, 0, 4, 14, 10, 0, 2, 0, 0},
                               {0, 0, 0, 0, 0, 2, 0, 1, 6},
                               {8, 11, 0, 0, 0, 0, 1, 0, 7},
                               {0, 0, 2, 0, 0, 0, 6, 7, 0}
                              };
     ShortestPath sp = new ShortestPath();
     sp.dijkstra(graph, 0);
 }
}

