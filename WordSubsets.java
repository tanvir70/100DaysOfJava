package swe.Strings;

import java.util.*;

public class WordSubsets {
    public static List<String> supersetFind(List<String> A, List<String> B) {
        List<String> output = new ArrayList<>();
        int[] bCount = new int[26];

        for (String word : B) {
            int[] tempCount = count(word);
            for (int i = 0; i < 26; i++) {
                bCount[i] = Math.max(bCount[i], tempCount[i]);
            }
        }

        for (String word : A) {
            int[] tempCount = count(word);
            boolean superset = true;
            for (int i = 0; i < 26; i++) {
                if (tempCount[i] < bCount[i]) {
                    superset = false;
                }
            }
            if (superset) {
                output.add(word);
            }
        }
        return output;
    }
    private static int[] count(String word) {
        int[] result = new int[26];
        for (int letter : word.toCharArray()) {
            int index = letter - 'a';
            if (index >= 0) {
                result[index]++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        A.addAll(Arrays.asList("orange", "room", "more"));
        B.addAll(Arrays.asList("rm", "oo"));
        System.out.println(supersetFind(A, B));
    }
}

