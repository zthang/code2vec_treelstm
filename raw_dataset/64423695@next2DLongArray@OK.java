public long[][] next2DLongArray(int N, int M) {
    long[][] ret = new long[N][];
    for (int i = 0; i < N; i++) ret[i] = nextLongArray(M);
    return ret;
}