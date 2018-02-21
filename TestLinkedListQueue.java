package com.homework2.linkedListImplQueue;

public class TestLinkedListQueue<T> {

	 public static void main(String[] args) {
	        TestLinkedListQueue<Integer> q = new TestLinkedListQueue<Integer>();
	        q.enqueue(5);
	        q.enqueue(7);
	        q.enqueue(2);
	        System.out.println("Printing queue ");
	        System.out.println(q.toString());
	        System.out.println("Deleting from queue. ");
	        q.dequeue();
	        System.out.println("Printing queue ");
	        System.out.println(q.toString());
	        System.out.println("Deleting from queue. ");
	        q.dequeue();
	        System.out.println("Printing queue ");
	        System.out.println(q.toString());
	        System.out.println("Checking if queue is empty: "+ q.isQueueEmpty());
	        q.displayQueue();
	    }
	    private class Node{
	        T item;
	        Node next;

	        Node(T t){
	            item = t;
	            next = null;
	        }

	        public String toString()  {
	            return item.toString();
	        }
	    }

	    private Node front, rear;

	    TestLinkedListQueue (){
	        front = null;
	        rear = null;
	    }

	    public boolean isQueueEmpty(){
	    	
	    		//if front equals null, queue is empty
	         if(front == null) {
	        	 	return true;
	         }
	         return false;
	    }

	    public void enqueue(T t){
	    	
	    		//Store previous rear to another node
	        Node prevRear = rear;
	        
	        //Assign new node as rear
	        rear = new Node(t);
	        
	        //If queue is empty, then assign front to rear
	        if (isQueueEmpty()) {
	        		front = rear;
	        }
	       
	        //Otherwise, point rear of previous rear to new node
	        else {
	        		prevRear.next = rear;
	        }
	    }

	    public T dequeue(){
	    	
	    		//Check if queue is empty
	        if (isQueueEmpty()) {
	        		return  null;
	        }
	        
	        //Check if front == rear, i.e there is only one element in the queue
	        if (front == rear){
	        	
	        		//Assign the front item as item to be removed
	            T t = (T) front.item;
	            
	            //Now as queue is empty, assign front and rear to null
	            front = rear = null;
	            return  t;
	        }

	        T t = (T) front.item;
	        front = front.next;
	        return t;
	    }

	    public String toString(){
	    	
	    		//If front equals null, queue is empty
	        if (front == null) {
	            return null;
	        }
	        
	        //Check if front == rear, i.e there is only one element in the queue
	        if (front == rear) {
	            return front.item.toString();
	        }
	     
	        StringBuffer sb = new StringBuffer();
	        Node cursor = front;
	        while(cursor != rear){
	            sb.append(cursor.item.toString()+" ");
	            cursor = cursor.next;
	        }
	        sb.append(rear.item.toString());
	        return sb.toString();
	    }
	    
	    public void displayQueue()
	    {
	        Node n = front;
	        System.out.print("Printing queue using printList: ");
	        while (n != null)
	        {
	            System.out.print(n.item+" ");
	            n = n.next;
	        }
	    }

}
