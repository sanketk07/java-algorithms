/**
 * 
 */
package com.homework6.sanket;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sanketkumar
 *
 */
public class RandomString {

	/**
	 * Generate a random string.
	 */
	public String getGeneratedString() {
		for (int i = 0; i < charBuffer.length; ++i) {
			charBuffer[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(charBuffer);
	}

	final static String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String lowercaseLetters = uppercaseLetters.toLowerCase();
	final static String validCharacterSet = uppercaseLetters + lowercaseLetters;
	final Random random;
	final char[] symbols;
	final char[] charBuffer;
	
	
	public static void main(String[] args) {
		RandomString gen = new RandomString(20, ThreadLocalRandom.current());
		String str = "";
		
		String reversedString ="";
		//System.out.println("reversedString ==> "+ reversedString);
		String reversedUsingStringBuilder = "";
		//System.out.println("reversedUsingStringBuilder ==> "+ reversedUsingStringBuilder);
		
		Map<Long, Integer> dataSet = new HashMap<Long, Integer>();
		
		for(int i = 0; i <= 5; i++) {
			
			
			long reverseStartTime = System.nanoTime();
			reversedString = reverseString(gen.getGeneratedString());
			str = str +reversedString;
			System.out.println(str);
			long reverseEndTime = System.nanoTime();
			long executionTime = reverseEndTime - reverseStartTime;
			System.out.println("executionTime ==> "+ executionTime);
			System.out.println("\n");
			System.out.println("Normal reverse --> "+ reversedString);
			System.out.println("length: "+ str.length());
			
			dataSet.put(executionTime, str.length());
			
			long reverseStartTimeSB = System.nanoTime();
			reversedUsingStringBuilder = reverseUsingStringBuilder(gen.getGeneratedString());
			str = str +reversedUsingStringBuilder;
			long reverseEndTimeSB = System.nanoTime();
			long executionTimeSB = reverseEndTimeSB - reverseStartTimeSB;
			System.out.println("executionTime builder==> "+ executionTimeSB);
			System.out.println("\n");
			System.out.println("Reverse using StringBuilder --> "+ reversedUsingStringBuilder);
			System.out.println("length: "+ str.length());
			
			
			
		}
		ChartUtilities cu = new ChartUtilities(dataSet);
		//cu.initUI(dataSet);
		
		
	}

	public RandomString(int length, Random random, String symbols) {
		if (length < 1) throw new IllegalArgumentException();
		if (symbols.length() < 2) throw new IllegalArgumentException();
		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.charBuffer = new char[length];
	}

	public RandomString(int length, Random random) {
		this(length, random, validCharacterSet);
	}

	public static String reverseString(String input) {
		
		char[] b = input.toCharArray();
		int len = b.length;
		char[] tempArray = new char[len];
		int i, j = 0;
		for(i = len-1; i >= 0; i--) {
			tempArray[j] = b[i];
			j++;
		}
		String reversedString = String.valueOf(tempArray);
		
		
		return reversedString;
	}
	
	public static String reverseUsingStringBuilder(String input) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		sb = sb.reverse();
		
		return sb.toString();
	}


}
