boolean isValid(int[] from, int[] to, char[][] board, int[][][] state) {
    if (to[0] < 0 || to[0] >= board.length || to[1] < 0 || to[1] >= board.length) {
        return false;
    }
    return (Arrays.equals(getState(from, state), getState(to, state)) && board[to[0]][to[1]] == '\u0000');
}