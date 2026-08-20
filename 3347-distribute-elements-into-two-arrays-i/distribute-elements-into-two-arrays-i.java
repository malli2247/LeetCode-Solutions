class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int x = 0, y = 0;
        a[x++] = nums[0];
        b[y++] = nums[1];
        for (int i = 2; i < n; i++) {
            if (a[x - 1] > b[y - 1])
                a[x++] = nums[i];
            else
                b[y++] = nums[i];
        }
        int[] ans = new int[n];
        System.arraycopy(a, 0, ans, 0, x);
        System.arraycopy(b, 0, ans, x, y);
        return ans;
    }
}