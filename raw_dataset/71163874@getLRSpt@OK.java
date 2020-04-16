private static int getLRSpt(int[][] st, int L, int R, BinaryOperator<Integer> binaryOperator) {
    int j = log[R - L + 1];
    return binaryOperator.apply(st[L][j], st[R - (1 << j) + 1][j]);
}