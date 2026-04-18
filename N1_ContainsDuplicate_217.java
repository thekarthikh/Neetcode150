// 🔹 Arrays & Hashing
// 🧩 Problem 1: Contains Duplicate

// LeetCode: 217
// Link: https://leetcode.com/problems/contains-duplicate/


import java.util.*;
class N1_ContainsDuplicate_217{

    // ✅ 1. Brute Force
    public static boolean containsDuplicateBrute(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // ✅ 2. Sorting
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    // ✅ 3. HashSet (Best)
    public static boolean containsDuplicateHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        System.out.println("Brute Force: " + containsDuplicateBrute(nums));
        System.out.println("Sorting: " + containsDuplicateSort(nums.clone()));
        System.out.println("HashSet: " + containsDuplicateHash(nums));
    }
}