public long[] nextLongs(int N) {
    long[] res = new long[N];
    for (int i = 0; i < N; i++) {
        res[i] = nextLong();
    }
    return res;
}