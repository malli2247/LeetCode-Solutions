class Solution {
    public int maxProduct(int n) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        while (n > 0) {
            int d = n % 10;
            if (d >= a) {
                b = a;
                a = d;
            } else if (d > b) {
                b = d;
            }
            n /= 10;
        }
        return a * b;
    }
}