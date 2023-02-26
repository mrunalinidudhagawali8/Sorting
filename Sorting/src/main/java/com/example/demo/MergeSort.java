package com.example.demo;

import java.util.Arrays;

public class MergeSort {

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 3, 5, 7, 2, 4, 6, 8, 10, 12 };

		mergeSort(arr, 0, arr.length - 1);

		System.out.println("Sorted array " + Arrays.toString(arr));

	}

	private static void mergeSort(int[] arr, int l, int r) {

		if (l == r)
			return;

		int mid = (l + r) / 2;

		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);

		merge(arr, l, mid, r);

	}

	private static void merge(int[] arr, int l, int y, int r) {
		int p1 = l;
		int p2 = y + 1;
		int p3 = 0;
		
		int brr[] = new int[r - l + 1];
		while (p1 <= y && p2 <= r) {
			if (arr[p1] < arr[p2]) {
				brr[p3] = arr[p1];
				p1++;
				p3++;

			} else {
				brr[p3] = arr[p2];
				p2++;
				p3++;
			}
		}
		
		//copy rest of the elements if any
		while (p1 <= y) {
			brr[p3] = arr[p1];
			p1++;
			p3++;
		}
		
		//copy rest of the elements if any
		while (p2 <= r) {
			brr[p3] = arr[p2];
			p2++;
			p3++;
		}

		// copy back to arr
		for (int i = l; i <= r; i++) {
			arr[i] = brr[i - l];
		}

	}

}
