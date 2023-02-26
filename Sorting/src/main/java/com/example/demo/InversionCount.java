package com.example.demo;

public class InversionCount {

	public static void main(String args[]) {
		int arr[] = new int[] { 6, 12, 10, 17, 10, 22, 9, 19, 21, 31, 26, 8  };

		int count = inversionCountUsingMergeSort(arr, 0, arr.length - 1);

		System.out.println("Inversion count is " + count);

	}

	private static int inversionCountUsingMergeSort(int[] arr, int l, int r) {

		if (l == r)
			return 0;

		int mid = (l + r) / 2;

		int x = inversionCountUsingMergeSort(arr, l, mid);

		int y = inversionCountUsingMergeSort(arr, mid + 1, r);

		System.out.println("Inversion count in the left half : " + x + " and in Right half " + y);

		int z = merge(arr, l, mid, r);

		return x + y + z;

	}

	private static int merge(int[] arr, int l, int y, int r) {
		int p1 = l;
		int p2 = y + 1;
		int p3 = 0;
		int count = 0;

		int flag = 0;

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
//				System.out.println("current y = " + y + " current p1 = " + p1);
				count += y - p1 + 1;
			}

			System.out.println("during flag : " + flag + " count is :" + count);
			flag++;

		}
		while (p1 <= y) {
			brr[p3] = arr[p1];
			p1++;
			p3++;
		}

		while (p2 <= r) {
			brr[p3] = arr[p2];
			p2++;
			p3++;
		}

		// copy back to arr
		for (int i = l; i <= r; i++) {
			arr[i] = brr[i - l];
		}

		return count;

	}

}
