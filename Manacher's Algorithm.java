class Solution {
    public String longestPalindrome(String s) {
        // Step 1: Transform the string to avoid handling odd and even lengths separately.
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String t = sb.toString();
        
        int n = t.length();
        int[] p = new int[n];  // Array to store the radius of palindrome at each position
        int center = 0, right = 0;
        int maxLength = 0, maxCenter = 0;  // Variables to track the longest palindrome

        // Step 2: Manacher's algorithm
        for (int i = 0; i < n; i++) {
            // Step 2.1: Find the mirror of the current position i
            int mirror = 2 * center - i;
            
            // Step 2.2: If i is within the right boundary, use the previously computed value
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            
            // Step 2.3: Try to expand around the center
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            
            // Step 2.4: Update the center and right boundary if we expanded beyond the current right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            
            // Step 2.5: Track the longest palindrome
            if (p[i] > maxLength) {
                maxLength = p[i];
                maxCenter = i;
            }
        }

        // Step 3: Extract the longest palindrome from the transformed string
        int start = (maxCenter - maxLength) / 2;  // The start index in the original string
        return s.substring(start, start + maxLength);
    }
}
