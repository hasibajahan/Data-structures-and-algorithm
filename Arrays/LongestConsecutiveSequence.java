//Problem statement: 
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//You must achieve O(n) time complexity.

//Approach:
//we can traverse the input array only once.(given,we have to achieve o(n) T.C.) 
//So we will need a lookup table (hash map) to check whether the particular element is included in a current sequence already or not
//1. take a variable to store the max length
//2. take a hashmap(Lookup table)
//3. Initialize the lookup table
//4. traverse the input array and find the sequences
//5. if the subsequent number exists in the hashmap and it is not included in the current sequence then add it to the current sequence 
//6. Check for previous number
//7. Return the maximum length

//Time Complexity: O(n) (traversing the input array once and checking the hashmap for each element)
//Space Complexity: O(n) (using a HashMap)

import java.util.HashMap;
import java.util.Map;
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        //1. take a variable to store the max length
        int longestLength=0;

        //2. take a hashmap(Lookup table)
        Map<Integer, Integer> mpp=new HashMap<>();
        
	//3. Initialize the lookup table
        for(int num:nums){
            mpp.put(num, 0);
        }

        //4. traverse the input array and find the sequences
        for(int num:nums){
            int currentLength=1;

            //5. if the subsequent number exists in the hashmap and it is not included in the current sequence then add it to the current sequence 
            int nextNumber=num+1;
            while(mpp.containsKey(nextNumber) && mpp.get(nextNumber)!=1){
                currentLength++;
                mpp.put(nextNumber, 1);
                nextNumber++;
            }
            //Check for previous number
           int previousNumber=num-1;
           while(mpp.containsKey(previousNumber) && mpp.get(previousNumber)!=1){
                currentLength++;
                mpp.put(previousNumber, 1);
                previousNumber--;
            }
            longestLength=Math.max(longestLength,currentLength);
        }
        return longestLength;
    }

    //Main method
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("Length of the longest consecutive sequence: " + lcs.longestConsecutive(nums)); 
    }
}

//Output:
//Length of the longest consecutive sequence: 9
