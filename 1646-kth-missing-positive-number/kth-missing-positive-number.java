class Solution {
    public int findKthPositive(int[] arr, int k) {
       int l=0,h=arr.length-1;

       while(l<=h){
        int mid=l+(h-l)/2;
        int miss=arr[mid]-(mid+1);
        if(miss<k){
            l=mid+1;
        }else{
            h=mid-1;
        }
       }
       return h+1+k;
    }
}