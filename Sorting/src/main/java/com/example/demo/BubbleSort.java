package com.example.demo;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 1,2,4,5 };
//		iterativeApproach_ascending(arr);
//		iterativeApproach_ascending_efficient(arr);
//		iterativeApproach_descending_efficient(arr);
//		recursiveApproach_ascending(arr, 0);
		recursiveApproach_descending(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

	public static void iterativeApproach_ascending(int[] arr) {
		int n = arr.length;
		int itr = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				itr++;
			}
		}
		System.out.println("Sorted array (iterativeApproach_ascending) : " + Arrays.toString(arr)
				+ " with number of iterations : " + itr);
	}

	/*
	 * In this implementation we are trying to reduce the number of iteration by
	 * breaking the loop if the inner for loop doesn't make any swap
	 */
	public static void iterativeApproach_ascending_efficient(int[] arr) {

		int n = arr.length;
		int flag = 0;
		int itr = 0;

		outer: for (int i = 0; i < n - 1; i++) {
			flag = 0;
			for (int j = 0; j < n - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					flag = 1;
				}
				if (j == n - 2 && flag == 0) {
					break outer;
				}
				itr++;
			}
		}
		System.out.println("Sorted array (iterativeApproach_ascending_efficient) : " + Arrays.toString(arr)
				+ " with number of iterations : " + itr);
	}

	/*
	 * In this implementation we are trying to reduce the number of iteration by
	 * breaking the loop if the inner for loop doesn't make any swap
	 */
	public static void iterativeApproach_descending_efficient(int[] arr) {

		int n = arr.length;
		int flag = 0;
		int itr = 0;

		outer: for (int i = 0; i < n - 1; i++) {
			flag = 0;
			for (int j = 0; j < n - 1; j++) {
				if (arr[j + 1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					flag = 1;
				}
				if (j == n - 2 && flag == 0) {
					break outer;
				}
				itr++;
			}
		}
		System.out.println("Sorted array (iterativeApproach_ascending_efficient) : " + Arrays.toString(arr)
				+ " with number of iterations : " + itr);
	}

	/*
	 * Recursive approach - Ascending order
	 */
	public static int[] recursiveApproach_ascending(int[] arr, int ind) {
		int n = arr.length;

		if (ind == n - 1) {
			return arr;
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}

		return recursiveApproach_ascending(arr, ind + 1);
	}

	/*
	 * Recursive approach - Descending order
	 */
	public static int[] recursiveApproach_descending(int[] arr, int ind) {
		int n = arr.length;

		if (ind == n - 1) {
			return arr;
		}

		for(int i=0;i<n-1;i++)
		{
			if(arr[i+1]>arr[i])
			{
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		return recursiveApproach_descending(arr, ind + 1);
	}

}