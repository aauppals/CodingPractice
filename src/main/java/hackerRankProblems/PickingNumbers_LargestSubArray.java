package hackerRankProblems;

/*Given an array of integers,
        find the longest subarray where the absolute difference between any two elements is less
         than or equal to 1. For the given input, it should return 5.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PickingNumbers_LargestSubArray {

    public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int subArrLength = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(a.get(0));
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) == arr.get(0) || a.get(i) - arr.get(0) == 1) {
                arr.add(a.get(i));
            } else {
                if (subArrLength < arr.size()) {
                    subArrLength = arr.size();
                }
                arr.clear();
                arr.add(a.get(i));
            }
        }
        return subArrLength > arr.size() ? subArrLength : arr.size();
    }

    public static void main(String[] args) {
        System.out.println(pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)));
        //should print 5
    }
}
