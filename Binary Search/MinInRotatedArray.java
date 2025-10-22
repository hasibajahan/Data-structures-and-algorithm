//problem statement:
//find the minimum element in a rotated sorted array

//time complexity: O(log n)
//space complexity: O(1)


class MinInRotatedArray {
    
    public int findMin(int[] nums) {
        //using binary search
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;

            if(nums[mid]>nums[right]){
                // it means min is in the right half
                left=mid+1;
            }
            else{
                right=mid;//min is in the left half
            }
        }
        return nums[left];
    }
public static void main(String[] args) {
    MinInRotatedArray m = new MinInRotatedArray();
    int[] nums={3,4,5,1,2};
    System.out.println("The minimum element in the rotated sorted array is " + m.findMin(nums));
}
}

//output:
//The minimum element in the rotated sorted array is 1