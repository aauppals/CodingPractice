package hackerRankProblems;

public class recursiveDigitSum {

    public static int superDigit(String n, int k) {
        // Write your code here
        if (n.length() == 1 && k == 1)
            return Integer.valueOf(n);

        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Integer.valueOf(n.substring(i, i + 1));
        }
        return superDigit(Long.toString(sum * k), 1);
    }


    public static void main(String[] args) {
        System.out.println(superDigit("9875", 4));
        //should print out 8
    }

}


