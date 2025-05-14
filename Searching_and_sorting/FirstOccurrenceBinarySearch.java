// Problem statement:
// Given a sorted array arr and an integer k, find the position(0-based indexing) at which k is present in the array using 
// binary search.
// Note: If multiple occurrences are there, return the first occurrence.

// Approch:
// 1. Start with two pointers: start at the beginning and end at the end of the array.

// 2. Use a while loop that runs as long as start <= end.

// 3. Calculate the middle index: mid = (start + end) / 2.

// 4. If arr[mid] == k, store the index and move end to (mid - 1) to search in the left half.

// 5. If k > arr[mid], move start to mid + 1 to search the right half.

// 6. If k < arr[mid], move end to mid - 1 to search the left half.

// 7. Continue until the loop ends. The variable index will hold the first occurrence if found.

// 8. Return index.

//***Time complexity: O(log N)
//Binary Search works by halving the search space each time.
//So for an array of size N, the number of steps to find the element is approximately log(N).

//***Space complexity: O(1)
//We’re not using any extra data structures (like arrays, lists, hashmaps).

import java.util.*;

public class FirstOccurrenceBinarySearch{
	public int binarySearch(int[] arr, int k) {
     		int start = 0, end = arr.length - 1;
     		int index = -1;

     		while (start <= end) {
         		int mid = (start + end) / 2;//Calculate the middle index

         		if (arr[mid] == k) {
             		index = mid;     // Store the index where k is found
             		end = mid - 1;   // Continue searching in the left half for first occurrence
         		}else if (k > arr[mid]){ 
                		start = mid + 1; // Search in the right half
            		} else {
                		end = mid - 1;   // Search in the left half
            		}
        	}
        return index;
    }

   // Main method
    public static void main(String[] args) {
        FirstOccurrenceBinarySearch searcher = new FirstOccurrenceBinarySearch();

        // Sorted input array with duplicates
        int[] array = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5};

        // Element to search
        int key = 3;

        // Performing binary search
        int result = searcher.binarySearch(array, key);

        if (result != -1) {
            System.out.println("First occurrence of " + key + " is at index: " + result);
        } else {
            System.out.println(key + " not found in the array.");
        }
    }
}

// Output:
// First occurrence of 3 is at index: 5