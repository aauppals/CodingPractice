import java.util.HashMap;
import java.util.List;

public class divisibleSumPairs {

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

        // O(n^2) complexity
//        int count = 0;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//
//                if ((ar.get(i) + ar.get(j)) % k == 0) count++;
//            }
//        }
//        return count;

//        two numbers are divisible by k ~~ the remainders of the two numbers are individually divisible by k
//
//        Maintain a map containing remainders and everytime a complement of remainder is found increment the count.


// O(n) complexity

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int remainder = ar.get(i) % k;
            count = count + map.getOrDefault((k - remainder) % k, 0);
            //ar.get(i) % k will match with (k-remainder) % k  --> E.g. 1 will work with (2 % 3) gives 2
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 3, 2, 6, 1, 2);
//        int res = divisibleSumPairs(6, 3, list);
//        System.out.println(res);
//
    }

}
