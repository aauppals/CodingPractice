package hackerRankProblems;
//elements of first array are all factors of integer being considered (LCM)
//integer being considered is a factor of all elements of the second array (GCD)

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        int size_a = a.size();
        int size_b = b.size();


        int lowerBound = a.get(size_a - 1);
        int upperBound = b.get(0);

        int count = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            int sum_mod = 0;

            for (int j = 0; j < size_a; j++) {
                sum_mod += i % a.get(j);
            }

            for (int k = 0; k < size_b; k++) {
                sum_mod += b.get(k) % i;
            }

            if (sum_mod == 0) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96)));
        //should print 3
    }
}
