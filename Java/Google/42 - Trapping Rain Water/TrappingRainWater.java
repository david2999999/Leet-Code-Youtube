public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1, water = 0;
        int maxLeft = 0, maxRight = 0;

        while (i <= j) {
            if (height[i] < height[j]) {
                if (maxLeft < height[i]) {
                    maxLeft = height[i++];
                } else {
                    water += (maxLeft - height[i++]);
                }
            } else {
                if (maxRight < height[j]) {
                    maxRight = height[j--];
                } else {
                    water += (maxRight - height[j--]);
                }
            }
        }

        return water;
    }
}