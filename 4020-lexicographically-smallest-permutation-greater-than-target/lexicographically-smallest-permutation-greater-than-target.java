class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        // Count characters available in s.
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Match the target from left to right as far as possible.
        int matched = 0;

        while (matched < n) {
            int idx = target.charAt(matched) - 'a';

            if (freq[idx] == 0) {
                break;
            }

            freq[idx]--;
            matched++;
        }

        // Try positions from the rightmost possible position.
        for (int i = matched; i >= 0; i--) {

            // For positions already matched, restore target[i]
            // because we are going to change the character there.
            if (i < matched) {
                freq[target.charAt(i) - 'a']++;
            }

            // Find the smallest available character greater than target[i].
            if (i < n) {
                int current = target.charAt(i) - 'a';

                for (int c = current + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        StringBuilder ans = new StringBuilder();

                        // Keep the prefix equal to target.
                        ans.append(target, 0, i);

                        // Make the first differing character greater.
                        ans.append((char) ('a' + c));
                        freq[c]--;

                        // Append all remaining characters in sorted order.
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