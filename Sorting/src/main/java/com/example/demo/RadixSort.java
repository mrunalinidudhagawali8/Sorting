package com.example.demo;

import java.util.Arrays;

public class RadixSort {

	public static void main(String args[]) {
		int arr[] = new int[] { 573, -25, 415, 12, 161, 6 };

		radixSort(arr);
		
	}

	private static void radixSort(int[] arr) {

		int maxNumber = Arrays.stream(arr).max().getAsInt();
		int maxDigits = Integer.toString(maxNumber).length();
		
		for(int i=0;i<maxDigits;i++)
		{
			countSort(arr, (int) Math.pow(10, i));
		}
	}

	private static void countSort(int[] arr, int radix) {

		
		int sortedarr[] = new int[arr.length];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		// find the min/max index
		for (int i = 0; i < arr.length; i++) {
			int digits = Integer.toString(arr[i]).length();
			int pow = (int)Math.pow(10, digits-1);
			int msb = (arr[i]/pow)%10;
			if(((arr[i] / radix) % 10)==msb && min>((arr[i] / radix) % 10))
			{
				min = (arr[i] / radix) % 10;
			}else if(((arr[i] / radix) % 10)<min)
			{
				min = (arr[i] / radix) % 10*(-1);
			}else if(((arr[i] / radix) % 10)>max)
			{
				max = (arr[i] / radix) % 10;
			}
		}
		
		System.out.println("min "+ min + " max =" + max);
		int freqArr[] = new int[max-min+1];
		
		// build count array
		for (int i = 0; i < arr.length; i++) {
			freqArr[((arr[i] / radix) % 10)-min]++;
		}

		// making cumulative count of frequencies
		for (int i = 1; i < freqArr.length; i++) {
			freqArr[i] += freqArr[i - 1];
		}

		// put the array elements in its correct position
		for (int i = arr.length - 1; i >= 0; i--) {
			int digit = (arr[i] / radix)%10-min;
			sortedarr[freqArr[digit]] = arr[i];
			freqArr[digit]--;
		}
		
		//copy back all array elements
		 System.arraycopy(sortedarr, 0, arr, 0, arr.length);
		System.out.println("After 1st iteration the sorted array is " + Arrays.toString(sortedarr));
	}
	

}
