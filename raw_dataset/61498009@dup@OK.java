private static int[][] dup(int[][] E) {
    int[][] res = new int[2 * E.length][];
    for (int i = 0; i < E.length; ++i) {
        res[2 * i] = E[i].clone();
        res[2 * i + 1] = E[i].clone();
        res[2 * i + 1][0] = E[i][1];
        res[2 * i + 1][1] = E[i][0];
    }
    return res;
}