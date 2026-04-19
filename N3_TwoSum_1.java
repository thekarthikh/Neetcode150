import java.util.*;

class N3_TwoSum_1 {

    // ✅ 1. Brute Force
    public static int[] twoSumBrute(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // ✅ 2. Sorting + Two Pointer
    public static int[] twoSumSort(int[] nums, int target) {

        int n = nums.length;
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int left = 0, right = n - 1;

        while(left < right){
            int sum = arr[left][0] + arr[right][0];

            if(sum == target){
                return new int[]{arr[left][1], arr[right][1]};
            } else if(sum < target){
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }

    // ✅ 3. HashMap (Best)
    public static int[] twoSumHash(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("Brute: " + Arrays.toString(twoSumBrute(nums, target)));
        System.out.println("Sort: " + Arrays.toString(twoSumSort(nums, target)));
        System.out.println("Hash: " + Arrays.toString(twoSumHash(nums, target)));
    }
}