package swe.Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int longestUniqueCharacterSubstring(String s) {
        int maxLength =0;
        Map<Character,Integer> visitedCharacter = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            if(visitedCharacter.containsKey(currentCharacter) && visitedCharacter.get(currentCharacter) >= left){
                left = visitedCharacter.get(currentCharacter) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            visitedCharacter.put(currentCharacter, right);
        }
        return maxLength;
    }     
}
