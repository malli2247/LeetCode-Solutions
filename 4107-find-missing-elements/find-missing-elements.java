class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                ans.add(j);
            }
        }
        return ans;
    }
}