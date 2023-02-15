import java.util.HashMap;
import java.util.Map;

public class syntaxPractice {
    public int lengthOfLongestSubstring(String s) {
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
        int var1 = 2;
        int var2 = 8;
        System.out.println("var1 before " + var1);
        System.out.println("var2 before " + var2);

//        swap(var1, var2);

        System.out.println("var1 after " + var1);
        System.out.println("var2 after " + var2);

    }
}


