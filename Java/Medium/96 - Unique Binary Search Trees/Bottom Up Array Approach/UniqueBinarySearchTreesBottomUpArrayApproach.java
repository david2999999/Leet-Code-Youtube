public class UniqueBinarySearchTreesBottomUpArrayApproach {
    public int numTrees(int n) {
        int[] trees = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                trees[i] = 1;
                continue;
            }

            for (int j = 1; j <= i; j++) {
                trees[i] += (trees[j - 1] * trees[i - j]);
            }
        }

        return trees[n];
    }
}