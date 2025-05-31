//Problem statement:
//Given an array of strings and group the anagrams together in a sublist and return them as a list of list.

//Approach:
//Use a HashMap to group words that are anagrams.

//For each string:
//Count the frequency of each alphabet using an array of size 26.
//Convert this frequency array into a unique string key using # as a separator to avoid ambiguity.

//use the generated key to-
//Add the string to the corresponding list in the map(if the key exists).
//if the key doesn't exist, create a new list.

//finally, return all the lists from the map as the result.

//Time complexity:
//let:
//n = number of strings in the input array
//k = maximum length of a string

//T.C.= O(n * k)

//Space complexity:
//HashMap stores up to n entries in the worst case(when all strings are unique anagrams).
//and each entry stores a string and a list.So, O(n * k) in total.

//Character count array:
//Temporary space of size 26 for each string: O(1) (as it is reused).
//Total Space Complexity=O(n * k)

import java.util.*;

class GroupAnagram{
  
    public List<List<String>> groupAnagram(String[] str) {

        //this map will store the pattern as key and group(list) of anagrams as value
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            //count the frequency of each character in each string
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            //convert the count array into a unique string key using '#' as separator(to remove ambiguity)
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append("#").append(i);
            }
            String key = sb.toString();

            //if the key is not already in the map, add it with a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            //add the current string to the corresponding anagram list
            map.get(key).add(s);
        }

        //return all the lists of anagrams
        return new ArrayList<>(map.values());
    }

    //main method 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GroupAnagram ga = new GroupAnagram();

        //take user input
        System.out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] input = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }

        //group the anagrams
        List<List<String>> result = ga.groupAnagram(input);

        // Print the grouped anagrams
        System.out.println("Grouped Anagrams:"+result);
       }
}

//Output:
//Enter the number of strings: 6
//Enter the strings:
//act
//pots
//tops
//cat
//stop
//hat
//Grouped Anagrams:[[pots, tops, stop], [hat], [act, cat]]