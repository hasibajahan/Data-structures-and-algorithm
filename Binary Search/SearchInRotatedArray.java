//problem statement:
//You are given a sorted array that has been rotated at some unknown pivot.
//find the index of a given target element in this rotated sorted array.
//If the target element is not found in the array, return -1.

//time complexity:
//it is just like the standard binary search where we reduce the search space by half in each iteration
//so the time complexity will be O(log n).

//space complexity:
//The space complexity of this approach is O(log n) because we are using recursion.

//code
class SearchInRotatedArray {
    //optimal approach ->modified binary search
    private int modifiedBinarySearch(int[] nums, int target,int left,int right){
        if(left>right){
            return -1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }

            //we will go to the left subarray and check if the left subarray is sorted or not
            if(nums[mid]>=nums[left]){
                //we will check if there is a possibility of the target being at the left subarray
                if(nums[left]<=target && target<=nums[mid]){
                    return modifiedBinarySearch(nums,target,left,mid-1);
                }
                else{
                    return modifiedBinarySearch(nums,target,mid+1,right);
                }
            }
            //if the left subarray is not sorted then the right subarray will definitely be sorted
            else{
                //we will check if there is a possibility of the target being at the right subarray
                if(nums[mid]<=target && target<=nums[right]){
                    return modifiedBinarySearch(nums,target,mid+1,right);
                }
                else{
                    return modifiedBinarySearch(nums,target,left,mid-1);
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return modifiedBinarySearch(nums,target,start,end);
    }
    public static void main(String[] args) {
        SearchInRotatedArray s=new SearchInRotatedArray();
        int[] arr={4,5,6,7,0,1,2};
        int target=0;
        int result=s.search(arr,target);
        if(result!=-1){
            System.out.println("Element found at index "+result);
        }else{
            System.out.println("Element not found");
        }
    }
}

//output:
//Element found at index 4