class Solution {
    public int removeCoveredIntervals(int[][] in) {
        Arrays.sort(in, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int n = in.length, ans = n;
        int l = in[0][0], r = in[0][1];

        if (n == 1) return 1;

        for (int i = 1; i < n; i++) {
            // Current interval is covered by [l, r]
            if (r >= in[i][1] && l <= in[i][0]) {
                ans--;
            }
            // Same start, larger interval covers previous one
            else if (l == in[i][0]) {
                ans--;
                r = in[i][1];
            }
            // Move to the new active interval
            else {
                l = in[i][0];
                r = in[i][1];
            }
        }

        return ans;
    }
}