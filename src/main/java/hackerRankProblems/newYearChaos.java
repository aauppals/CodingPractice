package hackerRankProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class newYearChaos {
    //essentially question is, how many minimum swaps needed to sort array, where 3 is the most no. of swaps considered

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int i = q.size();
        int swapCounter = 0;
        while (i > 0) {
            if (q.get(i - 1) == i) { //check array element(starting from 0) is equal to actual number
                i--;
                continue;
            } else if (q.get(i - 2) == i) {
                Collections.swap(q, i - 2, i - 1);
                swapCounter++;

//                manual swap?
//                int temp = q.get(i-2);
//                q.get(i-2) = q.get(i-1);
//                q.get(i-1)=temp;

            } else if (q.get(i - 3) == i) {
                Collections.swap(q, i - 3, i - 2);
                swapCounter++;
                Collections.swap(q, i - 2, i - 1);
                swapCounter++;
            } else {
                System.out.println("Too chaotic");
                break;
            }
            i--;
        }
        if (i == 0) {
            System.out.println(swapCounter);
        }
    }

    public static void main(String[] args) {
        List<Integer> q = new ArrayList<>();
        q.add(2);
        q.add(1);
        q.add(5);
        q.add(3);
        q.add(4);

        minimumBribes(q);

        //Should print: 3
    }
}
