import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static int[] twoSum(int[] nums, int target) {

        int[] returnArray = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { //check complement

                returnArray[0] = i;
                returnArray[1] = map.get(target - nums[i]);
                return returnArray;

            } else {
                map.put(nums[i], i);
            }

        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 4};
        System.out.print(twoSum(array, 6));
    }
}

