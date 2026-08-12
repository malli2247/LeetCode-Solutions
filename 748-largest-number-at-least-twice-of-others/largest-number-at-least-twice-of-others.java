class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(i,max);
        }
        int pos = 0;
        for(int x = 0; x < nums.length; x++){
            if (nums[x] == max) pos = x;
            int twice = nums[x] * 2;
            if(twice > max && nums[x] != max) return -1;
        }
        return pos;
    }
}