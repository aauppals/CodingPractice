package Eclipse;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    private int V;
    private List<List<Integer>> adj;

    public Solution () {
    }

    private void initialize (int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private boolean cyclicUtil(int i, boolean[] visited, boolean[] recordingStack) {

        if (recordingStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recordingStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer child : children)
            if (cyclicUtil(child, visited, recordingStack))
                return true;

        recordingStack[i] = false;

        return false;
    }

    private void addEdge(int source, int destination) {
        adj.get(source-1).add(destination-1);
    }


    private boolean isCyclic() {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (cyclicUtil(i, visited, recStack))
                return true;

        return false;
    }

    //driver code
    public static void main (String[] args){
        int[] A = {1, 2, 3, 4};
        int[] B = {2, 1, 4, 4};

        Solution solution = new Solution();

        boolean sol = solution.solution(A,B);
        System.out.println(sol);
    }


    public boolean solution(int[] A, int[] B) {
        Solution solution = new Solution();
        solution.initialize(A.length);
        for (int i = 0; i < A.length; i++) {
            solution.addEdge(A[i], B[i]);
        }

        return (solution.isCyclic());
    }


//    Example test:   ([1, 2, 3, 4], [2, 1, 4, 4])
//    WRONG ANSWER (got True expected False)
//
//    Example test:   ([1, 2, 3, 4], [2, 1, 4, 3])
//    WRONG ANSWER (got True expected False)

}
