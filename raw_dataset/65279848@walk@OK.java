static int walk(int v, int d) {
    for (int k = 0; k <= blsz; k++) {
        if (((1 << k) & d) > 0)
            v = bl[k][v];
    }
    return v;
}