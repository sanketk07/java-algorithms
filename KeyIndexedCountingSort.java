/**
 * 
 */
package com.homework6.sanket;

/**
 * @author sanketkumar
 *
 */
public class KeyIndexedCountingSort {

	public static void main(String args[]){
    	KeyIndexedCountingSort objKeyIndexedCountingSort = new KeyIndexedCountingSort();
        char charArr[] = {'a', 'b', 'd', 'c', 'e', 'd', 'd', 'f', 'c', 'a', 'b', 'b', 'e', 'e', 'c', 'c', 'e', 'f', 'd', 'd', 'a', 'a' };
        
        objKeyIndexedCountingSort.sort(charArr);
 
        System.out.print("Sorted character array --> ");
        for (int i=0; i<charArr.length; ++i)
            System.out.print(charArr[i]);
    }
	
    void sort(char arr[])
    {
        int charArrayLength = arr.length;
 
        char outputCharArray[] = new char[charArrayLength];
 
        int charCount[] = new int[256];
        for (int i=0; i<256; ++i) {
            charCount[i] = 0;
        }

        for (int i=0; i<charArrayLength; ++i) {
            ++charCount[arr[i]];
        }
 
        for (int i=1; i<=255; ++i) {
            charCount[i] += charCount[i-1];
        }
        
        for (int i = 0; i<charArrayLength; ++i){
            outputCharArray[charCount[arr[i]]-1] = arr[i];
            --charCount[arr[i]];
        }
 
        for (int i = 0; i<charArrayLength; ++i) {
            arr[i] = outputCharArray[i];
        }
    }

}
