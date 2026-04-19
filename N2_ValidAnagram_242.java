// 🔹 Arrays & Hashing
// 🧩 Problem 2: Valid Anagram

// LeetCode: 242
// Link: https://leetcode.com/problems/valid-anagram/

import java.util.*;

class N2_ValidAnagram_242 {

    // ✅ 1. Sorting
    public static boolean isAnagramSort(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    // ✅ 2. HashMap
    public static boolean isAnagramHash(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()){
            if(!map.containsKey(c) || map.get(c) == 0){
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    // ✅ 3. Frequency Array (Best)
    public static boolean isAnagramArray(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int c : count){
            if(c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println("Sorting: " + isAnagramSort(s, t));
        System.out.println("HashMap: " + isAnagramHash(s, t));
        System.out.println("Array: " + isAnagramArray(s, t));
    }
}