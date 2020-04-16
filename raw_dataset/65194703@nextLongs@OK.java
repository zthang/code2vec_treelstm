long[][] nextLongs(int count, int n) {
    long[][] res = new long[n][count];
    for (int i = 0; i < count; ++i) {
        for (int j = 0; j < n; j++) {
            res[j][i] = in.nextLong();
        }
    }
    return res;
}