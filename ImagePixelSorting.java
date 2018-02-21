package com.homework3.imagePixelSorting;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class ImagePixelSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("image/Boston.jpeg"));

			List<Double> imageIntensityListSelection = getPixelValueFromImage(image);
			List<Double> imageIntensityListInsertion = getPixelValueFromImage(image);
			List<Double> imageIntensityListMerge = getPixelValueFromImage(image);
			List<Double> imageIntensityListHeap = getPixelValueFromImage(image);

			
			performSelectionSort((ArrayList<Double>) imageIntensityListSelection); 

			performInsertionSort((ArrayList<Double>) imageIntensityListInsertion); 
			
			System.out.println("In performMergeSort");
			
			long startTime = System.nanoTime();
			performMergeSort((ArrayList<Double>) imageIntensityListMerge); 
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println("Execution time for MergeSort: "+ totalTime);

			System.out.println("In performHeapSort");
			startTime = System.nanoTime();
			performHeapSort((ArrayList<Double>) imageIntensityListHeap);
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			System.out.println("Execution time for HeapSort: "+ totalTime);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<Double> getPixelValueFromImage(BufferedImage image) {
		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();
		int[][] pixelsFromImage = new int[imageHeight][imageWidth];

		for (int i = 0; i < imageHeight; i++) {
			for (int j = 0; j < imageWidth; j++) {
				pixelsFromImage[i][j] = image.getRGB(j, i);
	
			}
		}
		List<Double> imageIntensityList = new ArrayList<Double>();
		double imageIntensityValue = 0.0;

		for(int i=0; i<pixelsFromImage.length; i++){
			for(int j=0; j<pixelsFromImage[i].length;j++){
				imageIntensityValue = getRGBFromPixel(pixelsFromImage[i][j]);
				imageIntensityList.add(imageIntensityValue);

			}

		}

		return imageIntensityList;
	}

	public static double getRGBFromPixel(int pixel) {
		int pixelRed = (pixel >> 16) & 0xff;
		int pixelGreen = (pixel >> 8) & 0xff;
		int pixelBlue = (pixel) & 0xff;

		return 0.2989*pixelRed + 0.587*pixelGreen + 0.114*pixelBlue;
	}

	public static void performSelectionSort(ArrayList<Double> imageIntensityList) {
		
		long startTime = System.nanoTime();
		System.out.println("In performSelectionSort");
		int imageIntensityListSize = imageIntensityList.size();

		for (int i = 0; i < imageIntensityListSize-1; i++) {

			int minimumIndex = i;
			for (int j = i+1; j < imageIntensityListSize; j++)
				if (imageIntensityList.get(j) > imageIntensityList.get(minimumIndex))
					minimumIndex = j;

			Double d = imageIntensityList.get(minimumIndex);
			imageIntensityList.set(minimumIndex, imageIntensityList.get(i));
			imageIntensityList.set(i, d);

		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Execution time for SelectionSort: "+ totalTime);
		
		PrintStream out = null;
		try {
			
			out = new PrintStream(new FileOutputStream("outputSelection.txt"));
			System.setOut(out);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<imageIntensityListSize; ++i) {
			System.out.println(imageIntensityList.get(i)+" ");
		
			
		}
		 out.close();
	}

	public static void performInsertionSort(ArrayList<Double> imageIntensityList){
		System.out.println("In performInsertionSort");
		long startTime = System.nanoTime();
		int n = imageIntensityList.size();
		for (int i=1; i<n; ++i)
		{
			Double d = imageIntensityList.get(i);
			int j = i-1;

			while (j>=0 && imageIntensityList.get(j) < d)
			{
				imageIntensityList.set(j+1, imageIntensityList.get(j));
				j = j-1;
			}

			
			imageIntensityList.set(j+1, d);
		}

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Execution time for InsertionSort: "+ totalTime);
		PrintStream out = null;
		try {
			
			out = new PrintStream(new FileOutputStream("outputInsertion.txt"));
			System.setOut(out);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<imageIntensityList.size(); ++i) {
			System.out.println(imageIntensityList.get(i)+" ");
		
			
		}
		 out.close();
	}

	public static ArrayList<Double> performMergeSort(ArrayList<Double> imageIntensityList) {

		System.out.println("In performMergeSort");

		ArrayList<Double> leftArray = new ArrayList<Double>();
		ArrayList<Double> rightArray = new ArrayList<Double>();
		int middle;

		if (imageIntensityList.size() == 1) {    
			return imageIntensityList;
		} else {
			middle = imageIntensityList.size()/2;

			for (int i=0; i<middle; i++) {
				leftArray.add(imageIntensityList.get(i));
			}

			for (int i=middle; i<imageIntensityList.size(); i++) {
				rightArray.add(imageIntensityList.get(i));
			}

			leftArray  = performMergeSort(leftArray);
			rightArray = performMergeSort(rightArray);

			merge(leftArray, rightArray, imageIntensityList);
		}
		
		
		PrintStream out = null;
		try {
			
			out = new PrintStream(new FileOutputStream("outputMerge.txt"));
			System.setOut(out);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<imageIntensityList.size(); ++i) {
			System.out.println(imageIntensityList.get(i)+" ");
		
			
		}
		 out.close();
		return imageIntensityList;
	}

	private static void merge(ArrayList<Double> leftArray, ArrayList<Double> rightArray, ArrayList<Double> totalArray) {
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int totalArrayIndex = 0;

		while (leftArrayIndex < leftArray.size() && rightArrayIndex < rightArray.size()) {
			if ( (leftArray.get(leftArrayIndex).compareTo(rightArray.get(rightArrayIndex))) > 0) {
				totalArray.set(totalArrayIndex, leftArray.get(leftArrayIndex));
				leftArrayIndex++;
			} else {
				totalArray.set(totalArrayIndex, rightArray.get(rightArrayIndex));
				rightArrayIndex++;
			}
			totalArrayIndex++;
		}

		ArrayList<Double> rest;
		int restIndex;
		if (leftArrayIndex >= leftArray.size()) {
			rest = rightArray;
			restIndex = rightArrayIndex;
		} else {
			rest = leftArray;
			restIndex = leftArrayIndex;
		}

		for (int i=restIndex; i<rest.size(); i++) {
			totalArray.set(totalArrayIndex, rest.get(i));
			totalArrayIndex++;
		}
	}

	public static void performHeapSort(ArrayList<Double> imageIntensityList) {
		int imageIntensityListSize = imageIntensityList.size();

		for (int i = imageIntensityListSize / 2 - 1; i >= 0; i--)
			heapify(imageIntensityList, imageIntensityListSize, i);

		for (int i = imageIntensityListSize - 1; i >= 0; i--) {

			double d = imageIntensityList.get(0);
			imageIntensityList.set(0, imageIntensityList.get(i));
			imageIntensityList.set(i, d);

			heapify(imageIntensityList, i, 0);
		}

		PrintStream out = null;
		try {
			
			out = new PrintStream(new FileOutputStream("outputHeap.txt"));
			System.setOut(out);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<imageIntensityList.size(); ++i) {
			System.out.println(imageIntensityList.get(i)+" ");
		
			
		}
		 out.close();
	}

	public static void heapify(ArrayList<Double> imageIntensityList, int h, int i) {
		int largest = i;

		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < h && imageIntensityList.get(left) < imageIntensityList.get(largest)) {
			largest = left;
		}

		if (right < h && imageIntensityList.get(right) < imageIntensityList.get(largest)) {
			largest = right;
		}

		if (largest != i) {
			double swap = imageIntensityList.get(i);
			imageIntensityList.set(i, imageIntensityList.get(largest));
			imageIntensityList.set(largest, swap);
			heapify(imageIntensityList, h, largest);
		}
	}


}
