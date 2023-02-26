package com.example.demo;

import java.util.ArrayList;

public class InversionCountSolution {
	
	public static void main(String[] args) {
		int brr[] = new int[] { 6, 12, 10, 17, 10, 22, 9, 19, 21, 31, 26, 8  };
		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<brr.length;i++)
		{
			arr.add(brr[i]);
		}
		
		System.out.println(inversionCount(arr, 0, arr.size()-1));
	}

	private static int inversionCount(ArrayList<Integer> arr, int l, int r) {
		
		if(l==r)
		{
			return 0;
		}
		
		int mid = (l+r)/2;
		
		int x = inversionCount(arr, l, mid);
		int y = inversionCount(arr, mid+1, r);
		System.out.println("Inversion count in the left half : " + x + " and in Right half " + y);

		int z = merge(arr, l, mid, r);
		
		return x+y+z;
	}

	private static int merge(ArrayList<Integer> arr, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid+1;
		int count = 0;
		
		ArrayList<Integer> brr = new ArrayList<Integer>();
		
		while(p1<=mid && p2<=r)
		{
			if(arr.get(p1)<=arr.get(p2))
			{
				brr.add(arr.get(p1));
				p1++;
				
			}else
			{
				brr.add(arr.get(p2));
				p2++;
				count += mid - p1 + 1;
			}
		}
		
		while(p1<=mid)
		{
			brr.add(arr.get(p1));
			p1++;
		}
		while(p2<=r)
		{
			brr.add(arr.get(p2));
			p2++;
		}
		
		for(int i=l;i<=r;i++)
		{
			arr.set(i, brr.get(i-l));
		}
		
 		
		return count;
	}

}
