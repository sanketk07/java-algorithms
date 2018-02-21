package com.homework2.arrayImplQueue;

public class ArrayImplQueue {
	
	int size, front ,rear;
	
	int array[];
	
	public ArrayImplQueue(int size) {
		
		this.front = -1;
		this.rear = -1;
		this.size = size;
		array= new int[size];
	}
	
	public static void main(String[] args) {
		
		ArrayImplQueue objArrayImplQueue = new ArrayImplQueue(5);
		
		objArrayImplQueue.enQueue(3);
		objArrayImplQueue.enQueue(8);
		objArrayImplQueue.enQueue(2);
		objArrayImplQueue.enQueue(5);
		//objArrayImplQueue.displayQueue();
		objArrayImplQueue.deQueue();
		objArrayImplQueue.displayQueue();
		System.out.println("Checking if queue is empty: "+ objArrayImplQueue.isQueueEmpty());
		
	}

	public void enQueue(int number) {
		
		if(rear == size -1) {
			//when rear is equal to size(max capacity) - 1 then queue is full
			System.out.println("Queue is full. Unable to add.");
			
		}else {
			//If front is equal to -1 that means no element is present in the queue
			if(front == -1) 
				{
				//first element has to be added so front is 0 now
				front = 0; 
				
				}
			
			//increment rear by 1
			rear++;
			//add new number to rear position in array
			array[rear] = number;
		
			System.out.println(number + " added to queue.");
				
			displayQueue();
			
		}
	}
	

	public void deQueue(){
		System.out.println("Deleting from queue. ");
		//if front is equal to rear ie either -1 or 0 then queue is empty
	   if(front == rear) {
		   	System.out.println("Queue is Empty.");
	   		return;
	   }else{
		   System.out.println("Deleted "+ array[front]);
		   
		   //increment front by 1 to point to next value in queue
		   front++;
		   
		   //if after deletion, no numbers are left in queue then initialize both front and rear to -1
		   if(front == rear) {
			   front = rear = -1;
		   }
	   }
	}
	
	public void displayQueue(){
		// if rear = -1, queue is empty
	   if(rear == -1)
		   System.out.println("Queue is Empty.");
	   else{
	      int i;
	      
	      //printing queue elements
	      System.out.print("Queue elements are: ");
	      for(i=front; i<=rear; i++)
	    	  System.out.print(array[i] + " ");
	      
	      System.out.println();
	   }
	}
	
	public boolean isQueueEmpty() {
		
		//if front and rear are same, queue is empty
		if(front==rear) {
			return true;
		}
		
		return false;
	}

}
