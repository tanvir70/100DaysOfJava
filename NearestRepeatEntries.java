package swe.HashTable;

import java.util.HashMap;
import java.util.Map;

public class NearestRepeatEntries {

    public static int nearestEntry(String[] words){
        Map<String,Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length ; i++) {
            String word = words[i];
            if (map.containsKey(word)){
                int previousIndex = map.get(word);
                int distance = i - previousIndex;
                minDistance = Math.min(minDistance,distance);
            }
            map.put(word,i);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    public static void main(String[] args) {
        String[] words1 = {
                "This",
                "is",
                "a",
                "sentence",
                "with",
                "is",
                "repeated",
                "then",
                "repeated"
        };
        System.out.println(nearestEntry(words1)); // Output: 2

        String[] words2 = {
                "This",
                "is",
                "a"
        };
        System.out.println(nearestEntry(words2)); // Output: -1
    }
}
