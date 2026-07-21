class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> malli = new HashMap<>();
        int SIZE1 = nums.length;
        for(int i = 0; i <SIZE1; i++) {
            int diff = target - nums[i];
            if(malli.containsKey(diff)) {
                return new int[]{i, malli.get(diff)};
            }
            malli.put(nums[i], i);
        }
        return null;
    }
}