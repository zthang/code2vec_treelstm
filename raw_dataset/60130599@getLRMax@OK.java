private static int getLRMax(int[][] st, int L, int R) {
    int j = log[R - L + 1];
    return Math.max(st[L][j], st[R - (1 << j) + 1][j]);
}