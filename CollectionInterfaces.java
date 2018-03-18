/**
 * 
 */
package com.questions.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author sanketkumar
 *
 */
public class CollectionInterfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> list = new ArrayList<String>();
		list.isEmpty();
		
		LinkedHashSet<String> lHashSet = new LinkedHashSet<String>();
		lHashSet.isEmpty();
		
		TreeSet<String> tset = new TreeSet<String>();
		tset.isEmpty();
		
		SortedSet<Integer> sortedSet = new TreeSet<Integer>();
		sortedSet.isEmpty();
		
		Set<Integer> set = new HashSet<Integer>();
		set.isEmpty();
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.isEmpty();
		
		Queue<String> q = new PriorityQueue<String>();
		q.isEmpty();
		q.peek();
		
		List<String> vector = new Vector<String>();
		vector.isEmpty();
		
		List<String> linkedList = new LinkedList<String>();
		linkedList.isEmpty();
		
		Queue<String> queue = new PriorityQueue<String>();
		queue.isEmpty();
		
	}

}
