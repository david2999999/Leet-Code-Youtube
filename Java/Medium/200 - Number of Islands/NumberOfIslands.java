public class NumberOfIslands {
    private static final int[][] DIRECTIONS = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    islands++;
                    sinkIsland(r, c, grid);
                }
            }
        }

        return islands;
    }

    private void sinkIsland(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] != '1') return;

        grid[r][c] = '0';

        for (int[] d: DIRECTIONS) {
            sinkIsland(r + d[0], c + d[1], grid);
        }
    }
}