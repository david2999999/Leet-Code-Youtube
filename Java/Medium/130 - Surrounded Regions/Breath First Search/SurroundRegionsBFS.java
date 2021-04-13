public class SurroundRegionsBFS {
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
        if (board[r][c] != 'O') return;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(r, c));
        board[r][c] = 'U';

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            r = pair.getKey(); c = pair.getValue();

            for (int[] d: DIRECTIONS) {
                int nr = r + d[0], nc = c + d[1];

                if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[nr].length || board[nr][nc] != 'O') continue;

                queue.add(new Pair<>(nr, nc));
                board[nr][nc] = 'U';
            }
        }
    }
}