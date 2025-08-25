//problem statement
//You are given an array of integers. You must sort the array using the Bubble Sort algorithm and count the number of swaps that occur during the sorting process.
//At the end, print the following three lines:
//Array is sorted in X swaps. – where X is the number of swaps performed.
//First Element: Y – where Y is the first element of the sorted array.
//Last Element: Z – where Z is the last element of the sorted array.


//code

import java.util.*;
public class BubbleSort{
	public static void countSwaps(List<Integer> a) {
        	int n=a.size();
        	int[] arr = a.stream().mapToInt(Integer::intValue).toArray();
        	int swap=0;
        	for(int i=0;i<n-1;i++){
            		for(int j=0;j<n-1-i;j++){
                		if(arr[j]>arr[j+1]){
                    			//swap
                    			int temp=arr[j];
                    			arr[j]=arr[j+1];
                    			arr[j+1]=temp;
                    			swap++;
                		}
          		  }
        		}
       	  System.out.println("Array is sorted in " + swap + " swaps.");
        	System.out.println("First Element: "+arr[0]);
        	System.out.println("Last Element: "+arr[n-1]);

    	}
	 public static void main(String[] args) {
		List<Integer> a = new ArrayList<>(Arrays.asList(3, 2, 1));
		countSwaps(a);
	}
}

//output:
//Array is sorted in 3 swaps.
//First Element: 1
//Last Element: 3