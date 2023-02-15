package FindMissingAlphabets;

import java.util.*;
import java.lang.*;

public class findMissingAlphabets {

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy";
        char xx = str.charAt(1);
//        System.out.print(xx);

        String str2 = str.replace(" ", "");
        System.out.println(str2);

        char s[] = str.toLowerCase().toCharArray();
        int c[] = new int[26];
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') {
                c[s[i] - 'a']++;
            }
        }
        String s2 = "";
        for (int i = 0; i < 26; i++) {
            if (c[i] == 0) {
                s2 = s2 + (char) (i + 'a');
            }
        }
        System.out.println("Missing characters are:" + s2);
    }
}
