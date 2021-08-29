public class IntegerBreakRecursiveApproach {
    public int integerBreak(int n) {
        if (n == 1) return 1;

        int maxProduct = 0;

        for (int x = 1; x < n; x++) {
            int y = n - x;
            int p1 = integerBreak(x);
            int p2 = integerBreak(y);
            maxProduct = Math.max(maxProduct, Math.max(x, p1) * Math.max(y, p2));
        }

        return maxProduct;
    }
}