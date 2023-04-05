package swe.Strings;

public class LongestSubstringBetter {
    public int longestUniqueCharacterSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int indexOfFirstAppearInSubstring = s.indexOf(s.charAt(right), left);
            if (indexOfFirstAppearInSubstring != right) {
                left = indexOfFirstAppearInSubstring + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}