package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

	public static void main(String args[]) {
		int arr[] = new int[] { 3,4,1,6,0 };

		quicksort(arr, 0, arr.length - 1);

		System.out.println("Sorted array " + Arrays.toString(arr));
		
		ArrayList<Integer> arr1 = new ArrayList<>();
	}

	private static void quicksort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}

		int ind = rearrange(arr, l, r);
		System.out.println("returned ind = " + ind);
		quicksort(arr, l, ind - 1);
		quicksort(arr, ind + 1, r);

	}

	private static int rearrange(int[] arr, int l, int r) {
		int p1 = l + 1;
		int p2 = r;
		int pivot = arr[l];

		while (p1 <= p2) {
			if (arr[p1] <= pivot) {
				p1++;
			} else if (arr[p2] > pivot) {
				p2--;
			} else {
				swap(arr, p1, p2);
				p1++;
				p2--;
			}
		}
		System.out.println("replacing pivot =" + pivot + " with element = " + arr[p2]);
		swap(arr, p2, l);

		return p2;
	}

	private static void swap(int[] arr, int p1, int p2) {
		System.out.println(" swapping ind1 = " + p1 + " with ind2 =" + p2);
		int temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}

}
