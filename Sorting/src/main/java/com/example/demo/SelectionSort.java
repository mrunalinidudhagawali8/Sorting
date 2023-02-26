package com.example.demo;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String args[])
	{
		int arr[] = new int[] {5,4,3,2,1};
		
		algo(arr);
	}

	private static void algo(int[] arr) {
		
		int size = arr.length;
		int minimum ;
		int ind = 0;
		
		for(int i=0;i<size;i++)
		{
			System.out.println("Trying to place :" + arr[i] + " to its correct place");
			minimum = arr[i];
			ind = i;
			for(int j=i+1;j<size;j++)
			{
				if(arr[j]<minimum)
				{
					minimum = arr[j];
					ind = j;
				}
				System.out.println("Minimum number found at index [" + ind + "] with value : " + minimum);
			}
			int temp = arr[i];
			arr[i] = arr[ind];
			arr[ind] = temp;
			System.out.println("Current Sorted array : " + Arrays.toString(arr));
			
		}
		
		System.out.println("Total sorted array " + Arrays.toString(arr));
			
	}

}
