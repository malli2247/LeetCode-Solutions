class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);

        int operations = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                operations += nums.length - i;
            }
        }

        return operations;
    }
}