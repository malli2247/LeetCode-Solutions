public class Solution {
    public int thirdMax(int[] nums) {
        Integer[] largest = new Integer[3];
        for (int n: nums) {
            if (largest[0] == null || n > largest[0]) {
                largest[2] = largest[1];
                largest[1] = largest[0];
                largest[0] = n;
            } else if (largest[0] != null && largest[0] > n && (largest[1] == null || n > largest[1])) {
                largest[2] = largest[1];
                largest[1] = n;
            } else if (largest[1] != null && largest[1] > n && (largest[2] == null || n > largest[2])) {
                largest[2] = n;
            }
        }
        return largest[2] == null? largest[0]: largest[2];
    }
}