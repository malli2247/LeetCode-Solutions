class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length==1){
            return res;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                res.add(nums[i]);
            }
        }
        return res;
    }
}