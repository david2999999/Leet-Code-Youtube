public class UniqueBinarySearchTreesRecursiveApproach {
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;

        int trees = 0;

        for (int i = 1; i <= n; i++) {
            trees += (numTrees(i - 1) * numTrees(n - i));
        }

        return trees;
    }
}