private static int[][] dec(int[][] E, int N) {
    for (int[] e : E) for (int i = 0; i < e.length && i < N; ++i) --e[i];
    return E;
}