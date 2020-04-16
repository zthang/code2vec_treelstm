void eval(int len, int k) {
    if (laz[k] == 0)
        return;
    if (k * 2 + 1 < N * 2 - 1) {
        laz[k * 2 + 1] += laz[k];
        laz[k * 2 + 2] += laz[k];
    }
    dat[k] += laz[k] * len;
    laz[k] = 0;
}