//Problem statement:
// Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Return the indices of the two numbers as an array [index1, index2] (1-based indexing).

//Approach:
//Use the two-pointer technique:
//initialize two pointers: one at the beginning (`start`) and one at the end (`end`) of the array.
//calculate the sum of numbers at these two pointers.
//   - If the sum equals the target, return the 1-based indices.
//   - If the sum is greater than the target, move the `end` pointer left.
//   - If the sum is less than the target, move the `start` pointer right.
// continue until the pointers meet.
// this approach works efficiently because the array is already sorted.

//Time complexity:
//O(n), where n is the length of the input array.
//each element is visited at most once.

//space complexity:
//O(1), constant extra space is used.

//Code
public class TwoSumSortedArray{
	public int[] twoSum(int[] numbers, int target) {
        int start=0;
        int end=numbers.length-1;
        while(start<end){
            int sum=numbers[start]+numbers[end];
            if(sum==target){
                return new int[] {start+1,end+1};//1-based indexing is used(Given in the problem statement)
            }
            else if(sum>target)
            {
                end--; 
            }
            else{
                start++;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TwoSumSortedArray ts = new TwoSumSortedArray();

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = ts.twoSum(numbers, target);

        if (result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found.");
        }
    }
} 
//Output: 
//Indices: [1, 2]