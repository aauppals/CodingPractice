package Eclipse;

import java.util.*;

class test {
    int solution2(int[] A) {
        int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (A[i] == A[j])
                    result = Math.max(result, Math.abs(i - j));
        return result;
    }


    int solution(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int N = A.length;
        int result = 0;

        for (int i = 0; i < N; i++) {
            List<Integer> currIndices = map.get(A[i]);
            if (currIndices == null) {
                int key = A[i];
                List<Integer> value = new ArrayList<>();
                value.add(i);
                map.put(key, value);
            } else if (currIndices.size() == 1) {
                currIndices.add(i);
                result = Math.max(result, currIndices.get(1) - currIndices.get(0));
            } else {
                currIndices.set(1,  i);
                result = Math.max(result, currIndices.get(1) - currIndices.get(0));
            }
        }

        return result;

    }


}