import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Dungeon {
    public static void main(String[] args) {
        final int[][] ints = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(ints));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        System.out.println("Dungeon: " + Arrays.deepToString(dungeon));
        System.out.println("dungeon.length: " + dungeon.length);
        System.out.println("dungeon[0].length: " + dungeon[0].length);

        int i = 0, j = 0;
        int health = dungeon[i][j];
        System.out.println("==>row: " + i + ", column: " + j + ", d: " + dungeon[i][j]);

        for (i = 0; i < dungeon.length; i++) {
            for (j = 0; j < dungeon[0].length; j++) {
                if (isArrived(i, j, dungeon)) {
                    System.out.println("Arrived=>row: " + i + ", column: " + j);
                    return abs(health) + 1;
                }

                System.out.println("==>Moving ");
                final List<Integer> coordinates = nextStep(i, j, dungeon);
                i = coordinates.get(0);
                j = coordinates.get(1);
                health += dungeon[i][j];
                System.out.println("==>row: " + i + ", column: " + j + ", d: " + dungeon[i][j]);
                System.out.println("==>health: " + health);
            }
        }
        return 0;
    }

    private static List<Integer> nextStep(int r, int c, int[][] dungeon) {
        int right = r + 1;
        int down = c + 1;

        List<Integer> coordinates = new ArrayList<>();
        final int rows = dungeon.length - 1;
        final int cols = dungeon[0].length - 1;

        if (c == cols) {
            if (r < rows) {
                return Arrays.asList(r + 1, c);
            }
        }
        if (r == rows) {
            if (c < cols) {
                return Arrays.asList(r, c + 1);
            }
        }

        if (dungeon[min(right, rows - 1)][c] > dungeon[r][min(down, cols - 1)]) {
            coordinates.add(right);
            coordinates.add(c);
        } else {
            coordinates.add(r);
            coordinates.add(down);
        }
        return coordinates;
    }

    private static boolean isDead(int r, int c, int[][] dungeon) {
        return dungeon[r][c] <= 0;
    }

    private static boolean isArrived(int r, int c, int[][] dungeon) {
        return r == dungeon.length - 1 && c == dungeon[0].length - 1;
    }

}
