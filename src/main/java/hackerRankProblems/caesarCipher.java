package hackerRankProblems;

public class caesarCipher {

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder stringBuilder = new StringBuilder("");

        for (char ch : s.toCharArray()) {
            if (!Character.isLetter(ch))
                stringBuilder.append(ch);

            if (Character.isLowerCase(ch)) {
                int oldPos = ch - 'a';//convert to number
                int newPos = (oldPos + k) % 26;
                char newChar = (char) (newPos + 'a');
                stringBuilder.append(newChar);

            } else if (Character.isUpperCase(ch)) {
                int oldPos = ch - 'A';
                int newPos = (oldPos + k) % 26;
                char newChar = (char) (newPos + 'A');
                stringBuilder.append(newChar);
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz", 2));
    }
}
