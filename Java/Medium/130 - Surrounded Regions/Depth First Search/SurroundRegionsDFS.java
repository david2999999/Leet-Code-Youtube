public class SurroundRegionsDFS {
    private int[][] DIRECTIONS = {
        { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    public void solve(char[][] board) {
        if (board.length == 0) return;

        markUnflippable(board);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                if (board[r][c] == 'U') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void markUnflippable(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            markUnflippable(r, 0, board);
            markUnflippable(r, board[r].length - 1, board);
        }

        for (int c = 0; c < board[0].length - 1; c++) {
            markUnflippable(0, c, board);
            markUnflippable(board.length - 1, c, board);
        }
    }

    private void markUnflippable(int r, int c, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] != 'O') return;

        board[r][c] = 'U';

        for (int[] d: DIRECTIONS) {
            markUnflippable(r + d[0], c + d[1], board);
        }
    }
}