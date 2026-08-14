class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int res = 0;
        int n=s.length();
        for (int right = 0; right < n; right++) {
            int ch = s.charAt(right) - 'a';
            count[ch]++;
            while (count[ch] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}