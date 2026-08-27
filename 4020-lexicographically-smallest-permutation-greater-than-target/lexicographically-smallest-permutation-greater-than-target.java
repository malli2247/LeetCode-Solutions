class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int matched = 0;
        while (matched < n) {
            int idx = target.charAt(matched) - 'a';
            if (freq[idx] == 0) {
                break;
            }
            freq[idx]--;
            matched++;
        }
        for (int i = matched; i >= 0; i--) {
            if (i < matched) {
                freq[target.charAt(i) - 'a']++;
            }
            if (i < n) {
                int current = target.charAt(i) - 'a';
                for (int c = current + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        StringBuilder ans = new StringBuilder();
                        ans.append(target, 0, i);
                        ans.append((char) ('a' + c));
                        freq[c]--;
                        for (int x = 0; x < 26; x++) {
                            while (freq[x] > 0) {
                                ans.append((char) ('a' + x));
                                freq[x]--;
                            }
                        }
                        return ans.toString();
                    }
                }
            }
        }
        return "";
    }
}