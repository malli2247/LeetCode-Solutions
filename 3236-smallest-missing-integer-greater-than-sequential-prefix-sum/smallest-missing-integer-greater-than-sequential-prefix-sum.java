class Solution{
    public int missingInteger(int[] nums){
        int prefix=nums[0];
        int n=nums.length;
        if(n==1){
            return prefix+1;
        }
        int i=1;
    while(i<n&&nums[i]==nums[i-1]+1){
            prefix+=nums[i];
            i++;
        }
        Set<Integer> present=new HashSet<>();
        for(int num:nums)present.add(num);
        while(present.contains(prefix)){
            prefix++;
        }
        return prefix;
    }
}