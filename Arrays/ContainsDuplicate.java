/* 
* Approach:
* Create a map to keep track of the elements those are already seen.
* Loop through the array:
* If the current number is not in the map, add it to the map.
* If it is already in the map, that means it's a duplicate — so add it to the result list.
* Return the list of duplicates after the loop finishes.
* Example:
* For the input array: {1, 2, 5, 7, 1, 2, 5}
* On the first pass through the elements: 1, 2, 5, 7 → added to the map
* When 1, 2, and 5 appear again → they are found in the map → added to the duplicates list
* Output: [1, 2, 5]
*/

import java.util.*;

/**
 * This class contains a method to find duplicates in an array.
 */
public class ContainsDuplicate {

    /**
     * Finds and returns a list of duplicate integers in the input array.
     */
    public List<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map1.containsKey(arr[i])) {
                map1.put(arr[i], 1);
            } else {
                // If already present in the map, that means it is a duplicate
                list.add(arr[i]);
            }
        }

        return list;
    }

    /**
     * The main method
     */
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();

        // Input array
        int[] array = {1,2,5,7,1,2,5};

        // Finding duplicates
        List<Integer> duplicates = containsDuplicate.findDuplicates(array);

        // Printing result
        System.out.println("Duplicate elements in the array: " + duplicates);
    }
}