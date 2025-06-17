//problem statement:
//Design an algorithm to encode a list of strings into a single string.
//The encoded string should be able to be decoded back into the original list of strings.

//Approach:
//Encoding:
//initialize an empty StringBuilder to store the encoded string.
//For each string in the input list:
//calculate its length.
//append the length, then a special separator (for example, *), then the original string to the StringBuilder.
//example:"apple" becomes "5*apple".
//return the combined encoded string.

//Decoding:
//Initialize an empty list to store the decoded strings.
//use a pointer i to traverse the encoded string.
//move a second pointer j to find the position of the separator *.
//extract the substring from i to j — which is the length of the next word.
//Convert the length string to an int.
//Use j + 1 and the extracted length to get the original word from the encoded string.
//add the word to the result list.
//Move pointer i to the start of the next encoded segment (j + 1 + length).
//Return the final list of decoded strings.

//time complexity:
//O(N+L)(encode->O(N) for traversing the list and O(L) for appending the actual characters)
//O(L)(decode)
//N=number of strings
//L=total number of characters across all strings

//space complexity:
//O(L)(encode)
//O(L)(decode-> since we are reconstructing it will be less than or equal to the total length of the strings)

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode{
    //Encode a list of strings to a single string
    public String encodeString(List<String> strs){

      //we will use this pattern for encoding -> length*string
      StringBuilder sb=new StringBuilder();

      //Traverse the whole list of strings only once
      for(String str:strs){

        //keep appending the length and * and then the original strings
        sb.append(str.length()).append("*").append(str);
      }
      //returning the original string
      return sb.toString();
    }

    //Decode the string back to the original list of strings
    public List<String> decodeString(String str){
      List<String> result=new ArrayList<>();
      int i=0;
      while(i<str.length()){
        int j=i;

        //find the position of the first *
        while(str.charAt(j)!='*'){
          j++;
        }
        //get the length of the original strings
        int length=Integer.parseInt(str.substring(i, j));
        
        //Extract the original string
        String word=str.substring(j+1, j+1+length);
        //add the stirng to the result list
        result.add(word);

        //move i to the next string's length
        i=j+1+length;
      }
      return result;
    }
    //Main method
    public static void main(String[] args){
      EncodeDecode ed=new EncodeDecode();

      List<String> originalStrings=new ArrayList<>();
      originalStrings.add("apple");
      originalStrings.add(" ");
      originalStrings.add("banana");

      //encode
      String encodedString=ed.encodeString(originalStrings);
      System.out.println("Encoded string: "+encodedString);

      //decode
      List<String> decodedStrings=ed.decodeString(encodedString);
      System.out.println("Decoded strings: " + decodedStrings);
    }
}

//Output:
//C:\Users\Hasiba\Desktop\Data_structures_and_algorithm\Arrays>javac EncodeDecode.java
//C:\Users\Hasiba\Desktop\Data_structures_and_algorithm\Arrays>java EncodeDecode
//Encoded string: 5*apple1* 6*banana
//Decoded strings: [apple,  , banana]