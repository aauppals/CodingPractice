package hackerRankProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class truckTour {

    public static int truckTour(List<List<Integer>> petrolpumps) {

        final int size = petrolpumps.size();

        for (int start = 0; start < size; start++) {
            //if petrol at tank is < distance to next pump, go back and start next iteration
            if (petrolpumps.get(start).get(0) < petrolpumps.get(start).get(1)) continue;

            long tank = 0;
            int position = start;
            int pumpCount = 0;

            while (true) {
                if (pumpCount == size) return start; // all pumps have been visited
                if (tank < 0) break;                 // not enough petrol to move further

                //find leftover petrol (petrol - distance to next petrol pump)
                tank += petrolpumps.get(position % size).get(0) - petrolpumps.get(position % size).get(1);
                //mod is used above to move to next pump in cycle; will give index out of bound exception otherwise

                position++;
                pumpCount++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> pumps = new ArrayList<>();


        List<Integer> entry1 = new ArrayList<>();
        entry1.add(1);
        entry1.add(5);
        pumps.add(entry1);

        List<Integer> entry2 = new ArrayList<>();
        entry2.add(10);
        entry2.add(3);
        pumps.add(entry2);

        List<Integer> entry3 = new ArrayList<>();
        entry3.add(3);
        entry3.add(4);
        pumps.add(entry3);

        System.out.println("Size of arrayList: " + pumps.size());

        System.out.println(truckTour(pumps));
        //should output 1
    }
}
