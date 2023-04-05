package swe.Strings;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] words) {
      Map<String,List<String>> map = new HashMap<>();
        for ( String word: words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);
            List<String> anagram = map.getOrDefault(signature,new ArrayList<>());
            anagram.add(word);
            map.put(signature,anagram);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> result = ga.groupAnagrams(words);
        System.out.println(result);
    }
}
