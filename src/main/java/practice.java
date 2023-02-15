import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class practice {

    public static void findDifference(int[] nums1, int[] nums2) {
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        // List<List<Integer>
        for (int i : nums1) {
            if (!contains(i, nums2) && !unique1.contains(i)) unique1.add(i);
        }
        System.out.println(unique1);

        for (int j : nums2) {
            if (!contains(j, nums1) && !unique2.contains(j)) unique2.add(j);

        }
        System.out.println(unique2);

    }

    private static boolean contains(int i, int[] nums) {
        boolean contains = false;

        for (int x = 0; x < nums.length; x++) {
            if (i == nums[x]) contains = true;
        }
        return contains;
    }


    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {2, 4, 6};

        findDifference(array1, array2);
    }
}
