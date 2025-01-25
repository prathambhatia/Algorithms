class Solution {
    public int countSubstrings(String s) {
        String t = "#" + String.join("#", s.split("")) + "#";  // Transform the string
        int n = t.length();
        int[] p = new int[n];  // p[i] is the radius of the palindrome centered at i
        int center = 0, right = 0, count = 0;

        for (int i = 0; i < n; i++) {
            // Mirror of the current position
            int mirror = 2 * center - i;
            
            // Expand around the center to find palindromes
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            
            // Try to expand further
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            
            // Update the center and right boundary if we expanded further
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            
            // Count palindromes
            count += (p[i] + 1) / 2;  // Only count actual palindromes, not intermediary ones
        }

        return count;
    }
}
