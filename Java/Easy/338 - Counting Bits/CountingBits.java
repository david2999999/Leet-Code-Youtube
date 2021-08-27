public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int x = 1; x <= n; x++) {
            ans[x] = ans[x & (x - 1)] + 1;
        }

        return ans;
    }
}