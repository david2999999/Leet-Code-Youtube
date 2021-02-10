public class UniquePathsRecursiveApproach {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;

        return uniquePaths(m, n - 1) +
               uniquePaths(m - 1, n);
    }
}