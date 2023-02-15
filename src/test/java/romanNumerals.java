import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class romanNumerals {

    @Test
    public void given_singleNumeral_then_convertsToDigit() {
        assertEquals(1, convertRoman("I"));
        assertEquals(5, convertRoman("V"));
    }

    @Test
    public void given_multipleNumerals_then_convertsToDigits() {
        assertEquals(7, convertRoman("VII"));
        assertEquals(155, convertRoman("CLV"));
    }

    @Test
    public void given_multipleNumerals_then_convertsToDigits2() {
        assertEquals(9, convertRoman("IX"));
        assertEquals(45, convertRoman("XLV"));
        assertEquals(47, convertRoman("XLVII"));
    }

    private int convertRoman(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i + 1 < str.length() && (map.get(str.charAt(i)) < map.get(str.charAt(i + 1)))) {
                sum -= map.get(ch);
            } else {
                sum += map.get(ch);
            }
        }
        return sum;
    }
}
