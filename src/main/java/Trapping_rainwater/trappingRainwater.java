package Trapping_rainwater;

public class trappingRainwater {
    public static int trap(int[] height) {
        if (height.length == 0) return 0;

        int water = 0;
        int size = height.length;

        int[] leftmax = new int[size];
        int[] rightmax = new int[size];

        leftmax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        rightmax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        for (int i = 1; i < size - 1; i++) {
            water += Math.min(leftmax[i], rightmax[i]) - height[i];
        }

        return water;

    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.print(trap(input));
    }
}
