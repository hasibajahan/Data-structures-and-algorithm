//problem statement:
//Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

//Approach:
//Two-pointer approach with manual normalization
//steps:
//Two pointers: start at the beginning, end at the end of the string.
//at each step->
//Convert uppercase letters to lowercase manually using ASCII arithmatic (left_char+('a'-'A')).
//skip non-alphanumeric characters (ignore punctuation, spaces,symbols).
//Compare characters from both ends.
//If characters don’t match → return false.
//If they match → move both pointers inward and continue.
//After passing the entire stringreturn true.

//Time and Space Complexity
//Time Complexity: O(n)
//Each character is processed at most once by either start or end. All operations inside the loop are constant time.

//Space Complexity: O(1)
//No extra string is created (no toLowerCase(), replaceAll(), or reverse()).


//Code
public class ValidPalindrome{
  public boolean isPalindrome(String s) {
        //1. Brute_force:
        // convert the string into lower case
        // String sb=s.toLowerCase();
        // //remove all non-alphanumeric characters
        // sb = sb.replaceAll("[^a-z0-9]", "");
        
        // //reverse the string
        // String reversed=new StringBuilder(sb).reverse().toString();
        // //compare them and return the result 
        // return sb.equals(reversed);

        //using two pointer approach
        // if(s==null || s.isEmpty()){
        //     return true;
        // }
        // String sb=s.toLowerCase();
        // sb=sb.replaceAll("[^a-z0-9]","");
        // int start=0,end=sb.length()-1;
        // while(start<end){
        //     if(sb.charAt(start)!=sb.charAt(end)){
        //         return false;
        //     }
        //     start++;
        //     end--;
        // }
        // return true;

        //using two pointer approach but manually converting uppercase to lowercase
        if(s.isEmpty()){
            return true;
        }
        
        int start=0,end=s.length()-1;
        while(start<end){
            char left_char=s.charAt(start);
            char right_char=s.charAt(end);
            //uppercase to lowercase conversion
            if('A'<=left_char && left_char<='Z'){
                left_char +='a'-'A';
            }
            if('A'<=right_char && right_char<='Z'){
                right_char += 'a'-'A';
            }
            //skip the non-alphanumeric characters
            if((left_char<'0' || left_char>'9') && (left_char<'a' || left_char>'z')){
                start++;
                continue;
            }
            if((right_char<'0' || right_char>'9') && (right_char<'a' || right_char>'z')){
                end--;
                continue;
            }
            if(left_char!=right_char){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
       ValidPalindrome vp = new ValidPalindrome();

      String test = "A man, a plan, a canal: Panama";
          boolean result = vp.isPalindrome(test);
          System.out.println("Result: "+result);
     }
}
