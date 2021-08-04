public class GameOfLife {
    public void gameOfLife(int[][] board) {
        mark(board);
        convert(board);
    }

    private void convert(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == -1) board[r][c] = 0;
                if (board[r][c] == 2) board[r][c] = 1;
            }
        }
    }

    private void mark(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                int live = getLiveNeighbors(board, r, c);

                if (board[r][c] == 1) {
                    if (live < 2 || live > 3) {
                        board[r][c] = -1;
                    }
                } else {
                    if (live == 3) {
                        board[r][c] = 2;
                    }
                }
            }
        }
    }

    private int getLiveNeighbors(int[][] board, int r, int c) {
        int live = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;

                int nr = r + dr, nc = c + dc;

                if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[nr].length) continue;

                if (Math.abs(board[nr][nc]) == 1) live++;
            }
        }

        return live;
    }
}