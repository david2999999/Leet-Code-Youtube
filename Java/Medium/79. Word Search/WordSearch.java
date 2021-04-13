public class WordSearch {
    private static final int[][] DIRECTIONS = {
            { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }
    };

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (exist(r, c, 0, board, word)) return true;
            }
        }

        return false;
    }

    private boolean exist(int r, int c, int i, char[][] board, String word) {
        if (i >= word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] != word.charAt(i)) return false;

        char ch = board[r][c];
        board[r][c] = '#';

        for (int[] d: DIRECTIONS) {
            if (exist(r + d[0], c + d[1], i + 1, board, word)) return true;
        }

        board[r][c] = ch;
        return false;
    }
}