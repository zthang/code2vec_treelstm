public int[][] next2DIntArray(int N, int M) {
    int[][] ret = new int[N][];
    for (int i = 0; i < N; i++) ret[i] = this.nextIntArray(M);
    return ret;
}