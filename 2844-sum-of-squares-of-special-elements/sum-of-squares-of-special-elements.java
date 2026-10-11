class Solution {
    public int sumOfSquares(int[] nums) {
        int sumTot=0;
        for(int i=0;i<nums.length;i++){
            if((nums.length % (i+1))==0){
                sumTot=sumTot+(nums[i]*nums[i]);
            }
        }
        return sumTot;
    }
}