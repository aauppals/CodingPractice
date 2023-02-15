
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        int left = 0;
        int right = 0;

        int result = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars.put(r, chars.getOrDefault(r, 0) + 1);

            while (chars.get(r) > 1) {
                char l = s.charAt(left);
                chars.put(l, chars.get(l) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdefcxz"));
    }
}


