public class ClimbingStairsMemoizationApproach {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private int climbStairs(int n, int[] memo) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] != 0) return memo[n];

        return memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }
}