public class IntegerBreakBottomUpApproach {
    public int integerBreak(int n) {
        int[] maxProduct = new int[n + 1];

        for (int curN = 1; curN <= n; curN++) {
            if (curN == 1) {
                maxProduct[curN] = 1;
                continue;
            }

            for (int x = 1; x < curN; x++) {
                int y = curN - x;
                maxProduct[curN] = Math.max(
                    maxProduct[curN],
                    Math.max(x, maxProduct[x]) * Math.max(y, maxProduct[y])
                );
            }
        }

        return maxProduct[n];
    }
}