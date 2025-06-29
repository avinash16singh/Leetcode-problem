public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);       // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);   // Even length palindrome
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;   // New start index
                end = i + len / 2;          // New end index
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of the palindrome
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestPalindrome("babad")); // Output: "bab" or "aba"
        System.out.println(sol.longestPalindrome("cbbd"));  // Output: "bb"
    }
}
