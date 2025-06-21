//Problem statement:
//Given an array nums, return a new array result such that result[i] is equal to the product of all elements of nums except nums[i], without using division.

//Approach:
//create two auxiliary arrays:
//left[i] stores the product of all elements to the left of index i.
//right[i] stores the product of all elements to the right of index i.

//initialize->
//left[0] = 1 because there's nothing to the left of index 0.
//right[n-1] = 1 because there's nothing to the right of the last element.

//Fill the left[] array by traversing from left to right:
//left[i] = left[i-1] * nums[i-1]

//fill the right[] array by traversing from right to left:
//right[i] = right[i+1] * nums[i+1]

//multiply left[i] * right[i] to get the result for each index i.
//return the result array.

//time complexity:
//O(N)

//space complexity:
//O(N), as Extra space used for left[],right[],and result[] arrays.

//code
class ProductOfArray{
  public int[] productExceptSelf(int[] nums){
        //Take two arrays-left and right
        int[] left=new int[nums.length];

        int[] right=new int[nums.length];

        //in the left array for each element store the multiplication of the elements on its left

        left[0]=1;//as there is no element on the left of the first element
        for(int j=1;j<nums.length;j++){
            left[j]=left[j-1]*nums[j-1];
        }

        //in the right array for each element store the multiplication of the elements on its right

        right[nums.length-1]=1;//as there is no element on the right of the last element
        for(int j=nums.length-2;j>=0;j--){
            right[j]=right[j+1]*nums[j+1];
        }

        //then for the result array for a particular element multiply the elements on its left and right 
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=left[i]*right[i];
        }
        return result;
  }
    //main method
    public static void main(String[] args) {
        ProductOfArray obj = new ProductOfArray();
        int[] nums = {-1,1,0,2,3};
        int[] result = obj.productExceptSelf(nums);
        System.out.print("Result: [ ");
        for (int num : result) {
        System.out.print(num + " ");
        }
	System.out.print("]");
    }
}

//Output:
//C:\Users\Hasiba\Desktop\Data_structures_and_algorithm\Arrays>javac ProductOfArray.java
//C:\Users\Hasiba\Desktop\Data_structures_and_algorithm\Arrays>java ProductOfArray
//Result: [ 0 0 -6 0 0 ]