int[] mul(int[] a, int[] b, int w) {
    int[] f = new int[w];
    for (int i = 0; i < w; ++i) {
        for (int j = 0; j < w && i + j < w; ++j) {
            f[i + j] += a[i] * b[j];
        }
    }
    for (int i = 0; i < w; ++i) {
        if (i + 1 < w) {
            f[i + 1] += f[i] / 10;
        }
        f[i] = f[i] % 10;
    }
    return f;
}