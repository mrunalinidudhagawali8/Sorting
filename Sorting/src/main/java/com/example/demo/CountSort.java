package com.example.demo;

import java.util.Arrays;

public class CountSort {

	public static void main(String args[]) {
		int arr[] = new int[] { 3, 4, 5, 2, 6, 4 };

		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		
		countSort(arr, min, max);
		
		System.out.println("print original arr : " + Arrays.toString(arr));

	}

	private static void countSort(int[] arr, int start, int end) {

		int countarr[] = new int[end - start + 1];
		int sortedarr[] = new int[arr.length];
		// build count array
		for (int i = 0; i < arr.length; i++) {
			countarr[arr[i] - start]++;
		}
		System.out.println("Freq Array : " + Arrays.toString(countarr) + "min = " + start + " max = " + end);
		// making cummulutive count of frequencies
		for (int i = 1; i < countarr.length; i++) {
			countarr[i] += countarr[i - 1];
		}
		System.out.println("Cummulative Array : " + Arrays.toString(countarr));
		int correctPos;
		// put the array elements in its correct position
		for (int i = arr.length - 1; i >= 0; i--) {
			correctPos = countarr[arr[i] - start] - 1;
			sortedarr[correctPos] = arr[i];
			--countarr[arr[i] - start];
		}

		System.out.println(Arrays.toString(sortedarr));
	}

}
