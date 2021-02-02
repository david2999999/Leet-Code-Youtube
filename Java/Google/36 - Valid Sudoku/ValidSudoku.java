public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.') continue;

                if (!seen.add(stringify("row", r, board[r][c])) ||
                        !seen.add(stringify("col", c, board[r][c])) ||
                        !seen.add(stringify("box", r / 3, c / 3, board[r][c]))) {
                    return false;
                }
            }
        }

        return true;
    }

    private String stringify(String d, int num, char value) {
        return new StringBuilder(d).
            append("-").
            append(num).
            append("#").
            append(value).
            toString();
    }

    private String stringify(String box, int r, int c, char value) {
        return new StringBuilder(box).
            append("-").
            append(r).
            append("-").
            append(c).
            append("#").
            append(value).
            toString();
    }
}