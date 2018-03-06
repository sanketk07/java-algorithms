/**
 * 
 */
package com.java.simpleanswer;

import java.util.LinkedHashSet;

/**
 * @author sanketkumar
 *
 */

public class Elevator {
    /*A = Weights array
      B = Target floor
      M = No of floors
      X = Max capacity
      Y = Max weight
      */
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        if(A.length != B.length) {
            return 0;
        }
        int ans = solve(A,B,M,X,Y);
        return ans;
    }

    private int solve(int[] weights, int[] targetFloor, int totalFloors, int maxCap, int maxWeight) {
        int length = weights.length;
        int i = 0;
        int stops = 0;
        while(i < length) {
            long groupWeight = 0;
            int cap = 0;

            LinkedHashSet uniqueFloors = new LinkedHashSet();
            while(cap < maxCap && i < length && groupWeight + weights[i] <= maxWeight) {
                groupWeight = groupWeight + weights[i];
                uniqueFloors.add(targetFloor[i]);
                i++;
                cap++;
            }
            stops = stops + uniqueFloors.size() + 1;
        }
        return stops;
    }

    public static void main(String args[]) {
    	Elevator ele = new Elevator();
    	int A[]= {40,40,100,80,20};
    	int B[] = {3,3,2,2, 3};
    	int M=3;
    	int X=5;
    	int Y=200;
    	int res=ele.solution(A, B, M, X, Y);
    	System.out.println("res:"+res);
    }

}