// Problem statement:
// Given an array of integers and another integer k is given. Using interpolation search algorithm find the position of the k(0-based indexing). 

// Note:
// Interpolation search:
// It is a searching algorithm. It is an improvement over binary search.
// Here we guess closer to where the target value is, kind of like searching in a dictionary.
// The conditions given are- the array must be sorted, and the elements are uniformly distributed.

//Approach:
//Initialize:
//low = 0 (start of the array) high = arr.length - 1 (end of the array)
//Loop until low is less than or equal to high. Also, make sure that k lies between arr[low] and arr[high], to avoid division by zero or invalid pos.
//Estimate the Position (pos) using interpolation formula:
//pos = low + ((k - arr[low]) * (high - low)) / (arr[high] - arr[low]);

//Compare arr[pos] with k:
//1. If arr[pos] == k: Target found, return pos.
//2. If arr[pos] < k: Search on the right side. 
//3. If arr[pos] > k: Search on the left side 
//If loop exits, and k was not found, return -1.

//Time complexity:
//Best Case:	O(1) – if the element is exactly at the guessed position.
//Average Case:	O(log (log (n))) – when the data is uniformly distributed.
//Worst Case:	O(n) – when data is not uniformly distributed or values are all clustered at one end.

//Space complexity:
//O(1) – Constant space. No extra memory or data structures are used.

public class Interpolation{
  public static int interpolationSearch(int[] arr, int k){
    int low = 0;
    int high = arr.length-1;

    while(low<=high && k >= arr[low] && k <= arr[high]){
      //Estimate the position
      int pos=low + ((k - arr[low]) * (high - low))/(arr[high] - arr[low]);//Interpolation formula
    
      if(arr[pos]==k){
        return pos;
      }
      else if(arr[pos]<k){
        //search in the right side of pos
        low = pos+1;
      }
      else{
        high = pos-1;//search in the left side of pos
      }
    }
    return -1;//Not found
  }

  //Main method
  public static void main(String[] args) {
    //Input array
    int[] arr={10,20,30,40,50,60,70,80,90};

    //Target value
    int key=70;
    
    //Performing interpolation search
    int result=interpolationSearch(arr, key);
    if(result !=-1){
      System.out.println("Element found at index: "+result);
  }else{
    System.out.println("Element not found!!");
  }
  }
}

//Output
//Element found at index: 6