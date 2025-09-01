//problem statement
//Given a string s, find the length of the longest substring without repeating characters.
//A substring is a contiguous sequence of characters within a string.

//time and space complexity
//it will traverse the whole array once so time complexity is O(n)
//The HashSet stores the current substring characters.
//in the worst case, the substring contains all unique characters.
//so, space complexity: O(min(n, charset_size))

//code
import java.util.HashSet;
import java.util.Set;
public class LongestSubstring{
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int max_length=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max_length=Math.max(max_length, (right-left)+1);
        }
        return max_length;
    }
    public static void main(String[] args){
        LongestSubstring obj=new LongestSubstring();
        String str="pwwkew";
        System.out.println("Max length: "+obj.lengthOfLongestSubstring(str));
    }
}

//output:
//Max length: 3