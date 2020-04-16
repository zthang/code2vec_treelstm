public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    char[][] board = new char[N][N];
    int[][][] state = new int[N][N][2];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            state[i][j] = new int[] { Math.max(-1, in.nextInt() - 1), Math.max(-1, in.nextInt() - 1) };
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] == '\u0000' && ((state[i][j][0] == i && state[i][j][1] == j) || state[i][j][0] == -1)) {
                if (state[i][j][0] != -1) {
                    ArrayDeque<int[]> coords = new ArrayDeque<>();
                    coords.add(new int[] { i, j });
                    board[i][j] = 'X';
                    while (!coords.isEmpty()) {
                        int[] next = coords.remove();
                        for (int m = 0; m < 4; m++) {
                            int[] nextM = new int[] { next[0] + moveR[m], next[1] + moveC[m] };
                            if (isValid(next, nextM, board, state)) {
                                board[nextM[0]][nextM[1]] = draw(nextM, next);
                                coords.add(nextM);
                            }
                        }
                    }
                } else {
                    int[] next = new int[] { i, j };
                    for (int m = 0; m < 4; m++) {
                        int[] nextM = new int[] { next[0] + moveR[m], next[1] + moveC[m] };
                        if (!(nextM[0] < 0 || nextM[0] >= N || nextM[1] < 0 || nextM[1] >= N)) {
                            if (state[nextM[0]][nextM[1]][0] == -1) {
                                if (board[nextM[0]][nextM[1]] == '\u0000') {
                                    board[nextM[0]][nextM[1]] = draw(nextM, next);
                                    board[next[0]][next[1]] = draw(next, nextM);
                                } else {
                                    board[next[0]][next[1]] = draw(next, nextM);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (board[i][j] == '\u0000') {
                out.println("INVALID");
                return;
            }
        }
    }
    out.println("VALID");
    for (int i = 0; i < N; i++) {
        out.println(new String(board[i]));
    }
}