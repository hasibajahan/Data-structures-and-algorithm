//Problem statement:
//Given an array of integers and an integer k. Find the k most frequent element in that array.

//Approach
//count the frequency of each element
//first take a bucket array
//Then, take the frequencies as the indices of the bucket array
//fill the buckets(put each number into the buckets corresponding to its frequency)
//traverse the bucket array from right to left and take a result array and store k most frequent numbers in the result array
//convert the result list to array and return it 

//Time complexity:
//Frequency map filling=O(n),as traversing the whole input array once
//Creating array=O(n)
//Fill buckets from the frequency map=O(n)
//traverse buckets to collect top k element=O(n)(worst case)
//T.C.=O(n)

//Space complexity:
//Frequency map=O(n)
//Bucket array=O(n+1)
//result list=O(k)
//S.c.= O(n)

//code

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent{
  public int[] kFrequent(int[] nums, int k){
      //using bucket sort approach
      //count the frequency of each element
      Map<Integer, Integer> freqMap=new HashMap<>();
      for(int num:nums){
        freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
      }

      //first take a bucket array
      List<Integer>[] bucket=new List[nums.length+1]; //as the max frequency of the elements in the nums array <= nums.length

      //Then, take the frequencies as the indices of the bucket array
      for(int i=0;i<=nums.length;i++){
        bucket[i]=new ArrayList<>();
      }

      //fill the buckets(put each number into the buckets corresponding to its frequency)
      for(Map.Entry<Integer, Integer> entry:freqMap.entrySet()){
        int freq=entry.getValue();
        bucket[freq].add(entry.getKey());
      }

      //traverse the bucket array from right to left and take a result array and store k most frequent numbers in the result array
      List<Integer> result=new ArrayList<>();
      for(int i=bucket.length-1;i>=0 && result.size()<k;i--){
        result.addAll(bucket[i]);
      }
      //convert the result list to array and return it 
      int[] topK = new int[k];
      for (int i = 0; i < k; i++) {
        topK[i] = result.get(i);
      }
      return topK;
    }
    public static void main(String[] args){
      int[] array={1, 1, 1, 2, 3, 2};
      int k=2;
      TopKFrequent tkf=new TopKFrequent();
      int[] res=tkf.kFrequent(array,k);
      System.out.println("Top " + k + " frequent elements are: " + Arrays.toString(res));
}
} 

//Output:
//Top 2 frequent elements are: [1, 2]
