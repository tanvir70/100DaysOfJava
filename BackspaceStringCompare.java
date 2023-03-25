package HundredDaysOfJava;

import java.util.Stack;

public class BackspaceStringCompare {
    public static boolean compare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#' && !sStack.empty()) {
                sStack.pop();
            } else if (c != '#') {
                sStack.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#' && !tStack.empty()) {
                tStack.pop();
            } else if (c != '#') {
                sStack.push(c);
            }
        }
        return sStack.equals(tStack);
    }
}
