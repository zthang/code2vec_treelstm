private static int[][][] dwgraph(int N, int[][] E) {
    int[] D = new int[N];
    for (int[] e : E) ++D[e[0]];
    int[][][] res = new int[2][N][];
    for (int i = 0; i < 2; ++i) for (int j = 0; j < N; ++j) res[i][j] = new int[D[j]];
    D = new int[N];
    for (int[] e : E) {
        int x = e[0], y = e[1], z = e.length > 2 ? e[2] : 1;
        res[0][x][D[x]] = y;
        res[1][x][D[x]] = z;
        ++D[x];
    }
    return res;
}