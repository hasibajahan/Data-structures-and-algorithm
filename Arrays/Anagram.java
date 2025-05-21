//Problem statement:
//Given two strings, check if they are anagrams of each other.
//note:
//Two strings are anagrams if they contain the same characters in the same frequency, but possibly in a different order.

//Approach:
//First, check if the lengths of both strings are equal. If not, they cannot be anagrams.
//Use a HashMap to store the frequency of each character from the first string.

//Traverse the second string:
//For each character:
//If the character doesn't exist in the map, return false.
//Decrease its count in the map.
//If count becomes 0, remove the character from the map.

//If all characters matched and their frequencies canceled out, the map should be empty, meaning the strings are anagrams.

//Time complexity:
//O(n), where n is the length of the strings.

//Space complexity:
//O(1) – Because the maximum size of the HashMap is limited to the number of unique characters (at most 26 for lowercase letters).

//code
import java.util.*;

class Anagram {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        
        HashMap<Character,Integer> mpp1=new HashMap<>();
        if(s1.length()!=s2.length()){
            return false;
        }
        for(char c:s1.toCharArray()){
            if(mpp1.containsKey(c)){
                mpp1.put(c,mpp1.get(c)+1);   
            }else{
            mpp1.put(c,1);
            }
        }
        for(char c:s2.toCharArray()){
            if(!mpp1.containsKey(c)){
                return false;
            }
            mpp1.put(c,mpp1.get(c)-1);
            if(mpp1.get(c)==0){
            	mpp1.remove(c);
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string1: ");
        String string1=sc.nextLine();
        System.out.println("Enter string2: ");
        String string2=sc.nextLine();
        
        boolean result=areAnagrams(string1, string2);
        if(result){
            System.out.println("Valid anagram");
        }else{
            System.out.println("Not anagram");
        }
    }
}

//Output:
//Enter string1:
//aab
//Enter string2:
//abb
//Not anagram