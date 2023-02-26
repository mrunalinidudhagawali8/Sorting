package com.example.demo;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String args[]) {
		int arr[] = new int[] { 5, 4, 3, 2, 1 };

		algo(arr);

	}

	private static void algo(int[] arr) {

		int size = arr.length;

		for (int i = 1; i < size; i++) {
			int j = i-1;
			while(j>=0 && arr[j+1]<arr[j])
			{
				swap(arr, j+1, j);
				j--;
			}
		}

		System.out.println("Sorted array " + Arrays.toString(arr));

	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
