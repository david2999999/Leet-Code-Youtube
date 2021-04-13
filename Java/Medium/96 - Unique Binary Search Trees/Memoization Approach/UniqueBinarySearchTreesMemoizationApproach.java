public class UniqueBinarySearchTreesMemoizationApproach {
    public int numTrees(int n) {
        return numTrees(n, new int[n + 1]);
    }

    private int numTrees(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];

        int trees = 0;

        for (int i = 1; i <= n; i++) {
            trees += (numTrees(i - 1, memo) * numTrees(n - i, memo));
        }

        return memo[n] = trees;
    }
}