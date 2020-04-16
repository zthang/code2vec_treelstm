static long max(int v, int d) {
    long m = 0;
    for (int k = 0; k <= blsz; k++) {
        if (((1 << k) & d) > 0) {
            m = Math.max(m, max[k][v]);
            v = bl[k][v];
        }
    }
    return m;
}