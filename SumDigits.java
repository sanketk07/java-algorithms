package com.homework2.sumDigits;

public class SumDigits {

	public static void main(String[] args) {
		
		System.out.println(sumDigits(1234));

	}
	
	public static int sumDigits(int number) {
		
		//Initialize output to 0
		int output = 0;
		try {
			
			//Return if number is 0
			if(number==0) {
				return output;
			}
			
			//If number > 0, get the last digit using mod and add it to the o/p of the recursive method
			if(number>0) {
				output = number % 10 + sumDigits(number/10);
				return output;
				
			}else {
				
				//Throw an IllegalArgumentException if an illegal or inappropriate argument has been passed to the method
				throw new IllegalArgumentException(Integer.toString(number));
			}
		}
		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
		
		return output;
	}
}
